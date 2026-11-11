import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Menu from './Menu';
import Home from './Home';
import Destinations from './Destinations';
import Destination from './Destination';
import About from './About';
import PageNotFound from './PageNotFound';

export default function App() {
  return (
    <div>

      <Menu/>

      <Switch>

        <Route exact path="/travellers-handbook-ui" >
          <Home />
        </Route>
        
        <Route path="/travellers-handbook-ui/destinations">
          <Destinations />
        </Route>

        <Route path="/travellers-handbook-ui/destination/:id">   {/* Parameterized route */ }
          <Destination />
        </Route>

        <Route path="/travellers-handbook-ui/about">
          <About />
        </Route>

        <Route path="*" >
          <PageNotFound />
        </Route>
        
      </Switch>
    </div>  
  );
}