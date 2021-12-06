import React from 'react';
import { StatusBar } from 'react-native';

const AppStatusBar = (props) => {
  return (
    <StatusBar
      {...props}
      barStyle={props.barStyle ?? 'light-content'}
      backgroundColor={props.backgroundColor ?? '#06a0cb'}
    />
  );
};

export default AppStatusBar;
