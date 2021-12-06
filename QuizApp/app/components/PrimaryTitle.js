import React from 'react';
import { StyleSheet, Text } from 'react-native';

const PrimaryTitle = (props) => {
  return (
    <Text
      {...props}
      style={{ ...styles.title, ...props.style }}
    >
      {props.children}
    </Text>
  );
}

const styles = StyleSheet.create({
  title: {
    fontWeight: 'bold',
    fontSize: 32,
    color: '#fff',
    marginBottom: 30,
    textAlign: 'center',
    letterSpacing: 2,
  },
});

export default PrimaryTitle;
