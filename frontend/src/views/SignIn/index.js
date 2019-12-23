import React, { useState, useEffect } from 'react';
import { Link as RouterLink, withRouter } from 'react-router-dom';
import PropTypes from 'prop-types';
import * as Yup from 'yup';
import { Grid, Button, IconButton, TextField, Link, Typography } from '@material-ui/core';
import ArrowBackIcon from '@material-ui/icons/ArrowBack';

import { useStyles } from './styles.js';
import { useForm } from '../../components/Hooks/useForm';

const SignIn = props => {
  const { history } = props;

  const classes = useStyles();

  const [{ values, loading }, handleChange, handleSubmit] = useForm()

  const handleBack = () => {
    history.goBack();
  };

  const handleLogin = async () => {
    
    console.log(values)
  }

  return (
    <div className={classes.root}>
      <Grid
        className={classes.grid}
        container
      >
        <Grid
          className={classes.quoteContainer}
          item
          lg={5}
        >
          <div className={classes.quote}>
            <div className={classes.quoteInner}>
              <Typography
                className={classes.quoteText}
                variant="h1"
              >
                O sucesso é a soma de pequenos esforços repetidos dia após dia.
              </Typography>
              <div className={classes.person}>
                <Typography
                  className={classes.name}
                  variant="body1"
                >
                  Robert Collier
                </Typography>
                <Typography
                  className={classes.bio}
                  variant="body2"
                >
                  Escritor
                </Typography>
              </div>
            </div>
          </div>
        </Grid>
        <Grid
          className={classes.content}
          item
          lg={7}
          xs={12}
        >
          <div className={classes.content}>
            <div className={classes.contentHeader}>
              <IconButton onClick={handleBack}>
                <ArrowBackIcon />
              </IconButton>
            </div>
            <div className={classes.contentBody}>
              <form
                className={classes.form}
                onSubmit={handleSubmit(handleLogin)}
                schema={schema}
              >
                <Typography
                  className={classes.title}
                  variant="h2"
                >
                  Entre
                </Typography>
                <Typography
                  color="textSecondary"
                  gutterBottom
                >
                  usando seu e-mail e senha
                </Typography>
                <TextField
                  className={classes.textField}
                  error={false}
                  fullWidth
                  helperText={''}
                  label="Endereço de e-mail"
                  name="email"
                  onChange={handleChange}
                  type="text"
                  value={values.email || ''}
                  variant="outlined"
                />
                <TextField
                  className={classes.textField}
                  error={false}
                  fullWidth
                  helperText={''}
                  label="Senha"
                  name="password"
                  onChange={handleChange}
                  type="password"
                  value={values.password || ''}
                  variant="outlined"
                />
                <Button
                  className={classes.signInButton}
                  color="primary"
                  fullWidth
                  disabled={loading}
                  size="large"
                  type="submit"
                  variant="contained"
                >
                  Confirmar
                </Button>
              </form>
            </div>
          </div>
        </Grid>
      </Grid>
    </div>
  );
};

const schema = Yup.object().shape({
  email: Yup.string()
    .email('Digite um e-mail válido')
    .required('Campo obrigatório'),
  password: Yup.string()
    .required('Campo obrigatório'),
});

export default withRouter(SignIn);
