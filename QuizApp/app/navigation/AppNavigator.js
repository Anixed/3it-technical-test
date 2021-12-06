import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createDrawerNavigator } from '@react-navigation/drawer';

import SplashScreen from '../screens/SplashScreen';
import HomeScreen from '../screens/HomeScreen';
import ResultsScreen from '../screens/ResultsScreen';

const Stack = createStackNavigator();
const Drawer = createDrawerNavigator();

const MainStack = () => {
  return (
    <Drawer.Navigator
    initialRouteName='HomeDrawerItem'
    screenOptions={{
      drawerActiveTintColor: '#06bcee',
      drawerInactiveTintColor: '#273239',
      drawerLabelStyle: {
        fontWeight: '400',
        fontSize: 16,
        paddingHorizontal: 5,
      }
    }}>
      <Drawer.Screen
        name="HomeDrawerItem"
        component={HomeStack}
        options={{
          drawerLabel: 'Encuesta',
          headerTitle: 'Encuesta 3it',
        }}
      />
      <Drawer.Screen
        name="ResultsDrawerItem"
        component={ResultsScreen}
        options={{
          drawerLabel: 'Resultados',
          headerTitle: 'Resultados de encuestas',
        }}
      />
    </Drawer.Navigator>
  );
}

const HomeStack = () => {
  return (
    <Stack.Navigator
      initialRouteName="HomeStackItem"
      screenOptions={{
        presentation: 'card',
        headerShown: false,
        headerMode: 'screen',
      }}
    >
      <Stack.Screen
        name="HomeStackItem"
        component={HomeScreen}
        options={{
          headerTitleAlign: 'center',
          headerBackTitle: 'Atrás',
          headerTitle: 'Encuesta 3it',
        }}
      />
    </Stack.Navigator>
  );
}

const AppNavigator = (props) => {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Splash">
        <Stack.Screen
          name="Splash"
          component={SplashScreen}
          options={{
            headerShown: false,
          }}
        />
        <Stack.Screen
          name="MainApp"
          component={MainStack}
          options={{
            headerShown: false,
          }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default AppNavigator;
