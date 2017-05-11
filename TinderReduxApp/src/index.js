//using es6 modules
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import NovelsApp from './compos/novelsapp';
import reducers from './reduceHers/index';
import {Provider} from 'react-redux';
import {createStore, applyMiddleware } from 'redux';

const createStoreWithMiddleware = applyMiddleware()(createStore);

//put an instance of the JApp component into page (in DOM)
ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <NovelsApp />
  </Provider>
  ,  document.querySelector('.jContainHer'));
