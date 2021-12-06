import { ToastAndroid } from 'react-native';

export const showToast = (message) => {
  ToastAndroid.show(message, ToastAndroid.SHORT);
}

export const groupBy = (items, key) => {
  return items.reduce((result, item) => {
    return {
      ...result,
      [item[key]]: [
        ...(result[item[key]] || []),
        item,
      ],
    };
  }, {});
}

export const getRandomColor = () => {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}
