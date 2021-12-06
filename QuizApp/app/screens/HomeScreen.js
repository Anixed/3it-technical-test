import React, { useState, useEffect, useRef } from 'react';
import { StyleSheet, Keyboard, View, TextInput } from 'react-native';
import { Picker } from '@react-native-picker/picker';

import useApiService from '../api/useApiService';
import { showToast } from '../helpers/Utils';
import { isEmail } from '../helpers/ValidationUtils';

import PrimaryTitle from '../components/PrimaryTitle';
import PrimaryButton from '../components/PrimaryButton';

const HomeScreen = (props) => {

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [emailInputValue, setEmailInputValue] = useState('');
  const [musicalStyles, setMusicalStyles] = useState([]);
  const [selectedMusicalStyle, setSelectedMusicalStyle] = useState(null);

  const emailTextInput = useRef();

  const apiService = useApiService();

  useEffect(() => {

    apiService
    .getMusicalStyles()
    .then((musicalStyles) => {
      setMusicalStyles(musicalStyles);
    })
    .catch((error) => {
      setError(error);
      showToast(error.message);
    });

  }, []);

  const sendQuiz = (data) => {
    setLoading(true);

    apiService
    .sendQuiz(data)
    .then((res) => {
      showToast(res.message);
      setLoading(false);
      setSelectedMusicalStyle(null);
      setEmailInputValue(null);
    })
    .catch((error) => {
      showToast(error.message);
      setLoading(false);
      setError(error);
    });
  }

  const handleSendButtonPress = () => {
    if (!selectedMusicalStyle) {
      showToast('Selecciona un estilo musical');
      return null;
    }

    if (!emailInputValue) {
      showToast('No olvides tu correo electrónico');
      emailTextInput.current.focus();
      return null;
    } else if (!isEmail(emailInputValue)) {
      showToast('El correo electrónico es inválido');
      return null;
    }

    Keyboard.dismiss();

    sendQuiz({
      email: emailInputValue,
      musical_styles_ids: [selectedMusicalStyle],
    });
  }

  return (
    <View style={styles.mainContainer}>
      <PrimaryTitle>¿Cuál es tu{'\n'}estilo musical?</PrimaryTitle>
      <Picker
        mode="dropdown"
        selectedValue={selectedMusicalStyle}
        onValueChange={(itemValue, itemIndex) => setSelectedMusicalStyle(itemValue)}
        style={styles.picker}
      >
        <Picker.Item label="Selecciona uno" value={null} />
        {musicalStyles.map((musicalStyle) => {
          return (
            <Picker.Item key={musicalStyle.id} label={musicalStyle.name} value={musicalStyle.id} />
          );
        })}
      </Picker>
      <TextInput
        ref={emailTextInput}
        style={styles.textInput}
        onChangeText={setEmailInputValue}
        value={emailInputValue}
        placeholder="example@3it.cl"
        keyboardType="email-address"
      />
      <PrimaryButton
        wrapperStyle={styles.buttonWrapper}
        style={styles.button}
        disabled={loading}
        onPress={handleSendButtonPress}
        title="Enviar respuesta"
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
  textInput: {
    backgroundColor: '#fff',
    width: 250,
    height: 55,
    marginBottom: 10,
    paddingHorizontal: 15,
    borderRadius: 4,
    elevation: 3,
  },
  picker: {
    backgroundColor: '#fff',
    width: 250,
    height: 50,
    marginBottom: 10,
    elevation: 3,
  },
  buttonWrapper: {
    marginTop: 20,
  },
  button: {
    width: 250,
    height: 50,
  },
});

export default HomeScreen;
