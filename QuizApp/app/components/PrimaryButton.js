import React from 'react';
import { StyleSheet, View, Text } from 'react-native';

import TouchableEffect from './TouchableEffect';

const PrimaryButton = (props) => {
  const {
    title,
    onPress,
    wrapperStyle,
    textStyle,
    style
  } = props;
  
  return (
    <View style={wrapperStyle}>
      <TouchableEffect useForeground={false} onPress={onPress}>
        <View style={{ ...styles.button, ...style }}>
          <Text style={{ ...styles.text, ...textStyle }}>{title}</Text>
        </View>
      </TouchableEffect>
    </View>
  );
}

const styles = StyleSheet.create({
  button: {
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'rgb(6, 188, 239)',
    paddingVertical: 12,
    paddingHorizontal: 32,
    borderRadius: 4,
    elevation: 3,
  },
  text: {
    fontSize: 16,
    lineHeight: 21,
    fontWeight: 'bold',
    color: 'white',
    letterSpacing: 0.25,
  },
});

export default PrimaryButton;
