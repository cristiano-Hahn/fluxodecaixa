import React from 'react';
import { Switch, Redirect } from 'react-router-dom';
import RouteWithLayout from './components/RouteWithLayout'
import MinimalLayout from './layouts/Minimal'
import MainLayout from './layouts/Main'

import NotFound from './views/NotFound';

const Routes = () => {
  return (
    <Switch>
      <RouteWithLayout
        layout={MinimalLayout}
        component={NotFound}
        exact
        path="/notfound"
      />
      <RouteWithLayout
        layout={MainLayout}
        component={NotFound}
        exact
        path="/notfounds"
      />
      <Redirect
        to="/notfound"
      />
    </Switch>
  );
};

export default Routes;
