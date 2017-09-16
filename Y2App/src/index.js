//a component or view.
//you can nest components one inside the other
import React from 'react';
import ReactDOM from 'react-dom';
import Searchy from './compos/searchy'
import { YT_API_KEY } from './consts'

//component, just some javascript thats going to make HTML
const Y2App = () => {
  return(
    <div>
      <h1>Youtube App</h1>
      <Searchy />
    </div>
  );
}

//take component and put on page (on DOM)
//note: this needs an INSTANCE of a component, hence the tag around Y2App
ReactDOM.render(<Y2App />, document.querySelector('.container'));