import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import BlogIndex from './components/blog_index';
import BlogCreate from './components/blog_create';
import BlogDetail from './components/blog_detail';
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
        <Switch>
          <Route path="/blogs/create" component={BlogCreate} />
          <Route path="/blogs/:blogId" component={BlogDetail} />
          <Route path="/" component={BlogIndex} />
        </Switch>
      </div>
    </BrowserRouter>
  </Provider>
  , document.querySelector('.container'));
