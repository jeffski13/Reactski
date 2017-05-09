//using es6 modules
import React, { Component } from 'react';
import ReactDOM from 'react-dom';

class JApp extends Component{

  constructor(props){
    super(props);
  }

  render(){
    return (
      <div>
        WordUp
      </div>
    );
  }
}

//new es6 syntax which makes a custom tag ("JeffApp") with html inside
const JeffApp = () => {
  return <div>YOLO32</div>;
}

//put an instance of the JApp component into page (in DOM)
ReactDOM.render(<JApp />,  document.querySelector('.jContainHer'));
