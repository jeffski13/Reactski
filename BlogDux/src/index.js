import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { BrowserRouter, Route } from 'react-router-dom';

import App from './components/app';
import reducers from './reducers';

const createStoreWithMiddleware = applyMiddleware()(createStore);

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
        <Route path="/yolo" component={Yolo} />
        <Route path="/huggy" component={Huggy} />
      </div>
    </BrowserRouter>
  </Provider>
  , document.querySelector('.container'));
