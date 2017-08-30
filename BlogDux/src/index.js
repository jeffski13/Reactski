import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { BrowserRouter, Route } from 'react-router-dom';

import BlogIndex from './components/blog_index';
import reducers from './reducers';

import promise from 'redux-promise';

const createStoreWithMiddleware = applyMiddleware(promise)(createStore);

//two components for testing
class Yolo extends React.Component {
  render(){
    return <div>Howdy There</div>
  }
}

class Huggy extends React.Component {
  render(){
    return <div>HuggyHug</div>
  }
}

ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <BrowserRouter>
      <div>
        <Route path="/" component={BlogIndex} />
      </div>
    </BrowserRouter>
  </Provider>
  , document.querySelector('.container'));
