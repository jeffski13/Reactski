import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

import Appski from './components/Appski';
import reducers from './reducers';

const createStoreWithMiddleware = applyMiddleware()(createStore);

ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <MuiThemeProvider>
      <Appski />
    </MuiThemeProvider>
  </Provider>
  , document.querySelector('.container'));
