import React, { Component } from 'react';
import { HashRouter as Router } from 'react-router-dom';
import Routes from './Routes';
import './assets/scss/index.scss';
import ThemeProvider from '@material-ui/styles/ThemeProvider';
import { SnackbarProvider } from 'notistack';
import theme from './theme';

export default class App extends Component {
  render() {
    return (
      <Router>
        <ThemeProvider theme={theme}>
          <SnackbarProvider>
            <Routes />
          </SnackbarProvider>
        </ThemeProvider>
      </Router>
    );
  }
}