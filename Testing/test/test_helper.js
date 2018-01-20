import jsdom from 'jsdom';
import jqueryImport from 'jquery';
import TestUtils from 'react-addons-test-utils';
import ReactDOM from 'react-dom';
import chai, { expect } from 'chai';
import React from 'react'; //needs to be imported any time we use jsx
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import chaiJquery from 'chai-jquery';

import reducers from '../src/reducers';

//set up testing environment to run as if its a browser
global.document = jsdom.jsdom('<!doctype html><html><body></body></html>');
global.window = global.document.defaultView;
//assign jquery $ var to a custom window endpoint (our fake browser)
const $ = jqueryImport(global.window);

//render react component method
 function renderReactComponent(ComponentClass, props, state){
   const componentInst = TestUtils.renderIntoDocument(
      <Provider store={createStore(reducers, state)}>
        <ComponentClass {...props} />
      </Provider>
    );

   //produce the html
   //wrap as jquery element ($) to give access to chai jquery matchers
   return $(ReactDOM.findDOMNode(componentInst));
 }

//simulate events method
//can call with: $('div').simulate('')
$.fn.simulate = function(eventName, value){
  if(value){
    //val sets value of html element (the element here is this)
    this.val(value);
  }

  //0 index because it could be an array
  TestUtils.Simulate[eventName](this[0]);
}

//chai jquery setup
chaiJquery(chai, chai.util, $);

export { renderReactComponent, expect };