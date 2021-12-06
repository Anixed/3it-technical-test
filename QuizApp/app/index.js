import 'react-native-gesture-handler';

import React from 'react';
import { SafeAreaView, StyleSheet, View } from 'react-native';

import AppStatusBar from './layout/AppStatusBar';
import AppNavigator from './navigation/AppNavigator';

const App = () => {
  return (
    <View style={styles.outerWrapper}>
      <SafeAreaView style={styles.innerWrapper}>
        <AppStatusBar />
        <AppNavigator />
      </SafeAreaView>
    </View>
  );
}

const styles = StyleSheet.create({
  outerWrapper: {
    flex: 1
  },
  innerWrapper: {
    flex: 1,
  },
});

export default App;
