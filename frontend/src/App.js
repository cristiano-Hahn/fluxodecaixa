import React, { Component } from 'react';

//Components
import { HashRouter as Router } from 'react-router-dom';

//Routes
import Routes from './Routes';

//Themes
import ThemeProvider from '@material-ui/styles/ThemeProvider';
import theme from './theme';

export default class App extends Component {
  render() {
    return (
      <Router>
        <ThemeProvider theme={theme}>
          <Routes />
        </ThemeProvider>
      </Router>
    );
  }
}