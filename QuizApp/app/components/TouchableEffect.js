import React from 'react';
import { TouchableNativeFeedback } from 'react-native';

const TouchableEffect = (props) => {
  return (
    <TouchableNativeFeedback
      {...props}
      background={props.background ?? props.rippleColor ?? TouchableNativeFeedback.Ripple('#06a0cb')}
      useForeground={(typeof props.useForeground === 'boolean') ? props.useForeground : true}
      delayPressIn={0}
    >
      {props.children}
    </TouchableNativeFeedback>
  );
}

export default TouchableEffect;
