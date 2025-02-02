import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/styles';

import TopBar from './TopBar';

const useStyles = makeStyles(() => ({
  root: {
    paddingTop: 64,
    height: '100%'
  },
  content: {
    height: '100%'
  }
}));

export default function Minimal(props) {
  
  const { children } = props;

  const classes = useStyles();

  return (
    <div className={classes.root}>
      <TopBar />
      <main className={classes.content}>
        {children}
      </main>
    </div>
  );
};

Minimal.propTypes = {
  children: PropTypes.node,
  className: PropTypes.string
};

