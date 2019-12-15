import React from 'react';

import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import ImageNotFound from './images/undraw_page_not_found_su7k.svg';

import { useStyles } from './style';

const NotFound = () => {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Grid
        container
        justify="center"
        spacing={4}
      >
        <Grid
          item
          lg={6}
          xs={12}
        >
          <div className={classes.content}>
            <Typography variant="h1">
              A página que você procura não está aqui
            </Typography>
            <Typography variant="subtitle2">
              Você tentou acessar uma rota inexistente e veio parar aqui. Seja qual for o motivo, use o navegador para voltar
            </Typography>
            <img
              alt="Under development"
              className={classes.image}
              src={ImageNotFound}
            />
          </div>
        </Grid>
      </Grid>
    </div>
  );
};

export default NotFound;
