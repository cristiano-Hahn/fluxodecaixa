import React from 'react';
import { Switch, Redirect } from 'react-router-dom';

const Routes = () => {
  return (
    <Switch>
      <Redirect to="/notfound" />
    </Switch>
  );
};

export default Routes;
