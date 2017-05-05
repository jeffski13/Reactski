//import react and part of it called "Component"
//so now instead of extend React.Component, we can just write extend Component
import React, { Component } from 'react';

//this is a class (a little more than a functional component)
class JBarSearch extends Component { //actually extending React.Component, but we imported it

  //called every time this new component is drawn on DOM
  constructor(props){
    super(props);
    //wtf? idk, react stuff
    this.state = {  jbarSearchStr: 'jeff initialized it.'}; //like a search term?
  }

  //runs every time STATE changes
  render(){

    return (
      <div className="jsearch-bar" >
        <input
          //we have this line which causes it to rerender, but with updated state
          value={this.state.jbarSearchStr}
          //now event
          onChange={ event => this.onJBarSearchInputChanged(event.target.value) } />
          {/*proof of state update from textbox*/}
        <br />Value of inputses: {this.state.jbarSearchStr}
      </div>
    );
  }

  onJBarSearchInputChanged(searchStr){
    //set state with term
    this.setState( { jbarSearchStr:searchStr });
    this.props.onJSearchStrChanged(searchStr);
  }
}

//allows other files to use JSearchBare (with import JSearchBare from '.../jBarSearch';)
export default JBarSearch;
