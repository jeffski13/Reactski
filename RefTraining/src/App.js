import React, { Component } from 'react';
import './App.css';
import RefPractice from './RefPractice';
import RefPracticeBetter from './RefPracticeBetter';

class App extends Component {

  constructor(props){
    super(props);

    this.buttonClicked = this.buttonClicked.bind(this);
    this.butterButtonClicked = this.butterButtonClicked.bind(this);
  }

  buttonClicked(){
    console.log('jeffski: printing instance with property refPracticeAnchorHtml ', this.refPracticeInstance);
    this.refPracticeInstance.refPracticeAnchorHtml.focus();
  }

  butterButtonClicked(){
    console.log('jeffski: printing anchor ref from RefPracticeBetter Component', this.refPracticeBetterAnchorHtml);
    this.refPracticeBetterAnchorHtml.focus();
  }

  render() {
    return (
      <div className="App">
        <RefPractice ref={ (refParam)=>{
            console.log('parameter of ref method', refParam);
            //note that refPracticeInstance.refPracticeAnchorHtml
            // is a thing
            // We define the refPracticeAnchorHtml class property inspect in
            // the RefPractice component
            this.refPracticeInstance = refParam;
          }} />

        <button onClick={this.buttonClicked}>better button</button>

        <RefPracticeBetter
            getAnchorRef={(anchorRefParameter)=>{
            //create a class property for ourselves called refPracticeBetterAnchorHtml
            //We can access this property after the RefPracticeBetter renders
            this.refPracticeBetterAnchorHtml = anchorRefParameter;
          }} />
        <button onClick={this.butterButtonClicked}>better button</button>
      </div>
    );
  }
}

export default App;
