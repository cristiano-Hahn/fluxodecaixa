import React from 'react';
import { Switch, Redirect } from 'react-router-dom';
import RouteWithLayout from './components/RouteWithLayout'
import MinimalLayout from './layouts/Minimal'
import MainLayout from './layouts/Main'

import NotFound from './views/NotFound';
import SignIn from './views/SignIn';
import SignUp from './views/SignUp';

const Routes = () => {
  return (
    <Switch>
      <RouteWithLayout
        component={SignIn}
        exact
        layout={MinimalLayout}
        path="/sign-in"
      />
      <RouteWithLayout
        component={SignUp}
        exact
        layout={MinimalLayout}
        path="/sign-up"
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
