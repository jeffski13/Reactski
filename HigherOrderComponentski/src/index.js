import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import { Router, Route, browserHistory } from 'react-router';

import App from './components/App';
import MainBase from './components/MainBase';
import TreasureRoom from './components/TreasureRoom';
import reducers from './reducers';

const createStoreWithMiddleware = applyMiddleware()(createStore);

ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <MuiThemeProvider>
      <Router history={browserHistory}>
        <Route path="/" component={App} >
          <Route path="homeBase" component={MainBase} />
          <Route path="treasureVault" component={TreasureRoom} />
        </Route>
      </Router>
    </MuiThemeProvider>
  </Provider>
  , document.querySelector('.container'));
