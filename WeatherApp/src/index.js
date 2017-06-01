import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import JApp from './components/app';
import reducers from './reducers';
import ReduxProm from 'redux-promise';

const createStoreWithMiddleware = applyMiddleware(ReduxProm)(createStore);

ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <JApp />
  </Provider>
  , document.querySelector('.container'));
