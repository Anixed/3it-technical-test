import React, { useState, useEffect } from 'react';
import { StyleSheet, View, Dimensions } from 'react-native';
import { PieChart } from 'react-native-chart-kit';

import useApiService from '../api/useApiService';
import { showToast, groupBy, getRandomColor } from '../helpers/Utils';

import PrimaryTitle from '../components/PrimaryTitle';
import PrimaryButton from '../components/PrimaryButton';

const screenWidth = Dimensions.get('window').width;
const chartConfig = {
  backgroundGradientFrom: "#1E2923",
  backgroundGradientFromOpacity: 0,
  backgroundGradientTo: "#08130D",
  backgroundGradientToOpacity: 0.5,
  color: (opacity = 1) => `rgba(26, 255, 146, ${opacity})`,
  strokeWidth: 2, // optional, default 3
  barPercentage: 0.5,
  useShadowColorFromDataset: false // optional
};

const ResultsScreen = (props) => {

  const [chartData, setChartData] = useState([]);
  const [quizResults, setQuizResults] = useState([]);

  const apiService = useApiService();

  useEffect(() => {

    getQuizResults();

  }, []);

  useEffect(() => {

    if (quizResults.length > 0) {
      const musicalStyles = quizResults.map((quizResult) => {
        return quizResult.musical_styles;
      }).reduce((acc, musicalStyles) => {
        return acc.concat(musicalStyles);
      }, []);
  
      const groupedMusicalStyles = groupBy(musicalStyles, 'id');
  
      setChartData(Object.keys(groupedMusicalStyles).map((key) => {
        const musicalStyle = groupedMusicalStyles[key];
        return {
          name: musicalStyle[0].name,
          total: musicalStyle.length,
          color: getRandomColor(),
          legendFontColor: '#fff',
          legendFontSize: 15,
        };
      }));
    }

  }, [quizResults]);

  const getQuizResults = () => {
    apiService
    .getQuizResults()
    .then((quizResults) => {
      setQuizResults(quizResults);
    })
    .catch((error) => {
      showToast(error.message);
    });
  }

  const handleRefreshButtonPress = () => {
    getQuizResults();
  }

  return (
    <View style={styles.mainContainer}>
      <PrimaryTitle>Resultados</PrimaryTitle>
      <View style={styles.chartContainer}>
        <PieChart
          data={chartData}
          chartConfig={chartConfig}
          accessor="total"
          width={screenWidth}
          height={280}
          backgroundColor="transparent"
          paddingLeft="20"
          center={[15, 0]}
          absolute={false}
        />
      </View>
      <PrimaryButton
        wrapperStyle={styles.buttonWrapper}
        style={styles.button}
        onPress={handleRefreshButtonPress}
        title="Actualizar resultados"
      />
    </View>
  );
}

const styles = StyleSheet.create({
  mainContainer: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#1f3a4b',
  },
  chartContainer: {
  },
  buttonWrapper: {
    marginTop: 20,
  },
  button: {
    width: 250,
    height: 50,
  },
});

export default ResultsScreen;
