import React, { useEffect } from 'react';
import { StyleSheet, View, Text, ActivityIndicator } from 'react-native';
import { CommonActions } from '@react-navigation/native';

import PrimaryTitle from '../components/PrimaryTitle';

const SplashScreen = ({ navigation }) => {

  useEffect(() => {
    setTimeout(() => {
      goToApp();
    }, 3000);
  }, []);

  const goToApp = () => {
    navigation.dispatch(CommonActions.reset({
      index: 0,
      routes: [{ name: 'MainApp' }],
    }));
  }

  return (
    <View style={styles.mainContainer}>
      <ActivityIndicator 
        style={styles.loadingIndicator}
        color="#06bcee"
        size="large"
      />
      <PrimaryTitle style={styles.loadingText}>Cargando</PrimaryTitle>
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
  loadingIndicator: {
    paddingHorizontal: 20,
    paddingVertical: 20,
  },
  loadingText: {
    fontSize: 22,
  },
});

export default SplashScreen;
