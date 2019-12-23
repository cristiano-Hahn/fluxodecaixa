import React from 'react';
import clsx from 'clsx';
import { makeStyles } from '@material-ui/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles(() => ({
  root: {
    boxShadow: 'none'
  },
  title: {
    color: '#fff'
  },
}));

export default function Topbar(props) {
  const { className, ...rest } = props;

  const classes = useStyles();

  return (
    <AppBar
      {...rest}
      className={clsx(classes.root, className)}
      color="primary"
      position="fixed"
    >
      <Toolbar>
        <Typography variant="h3" component="h2" className={classes.title}>
          Fluxo de caixa
        </Typography>
      </Toolbar>
    </AppBar>
  );
};

