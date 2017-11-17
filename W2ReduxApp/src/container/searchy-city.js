import React, { Component } from 'react';

export default class SearchyCity extends Component{
  constructor(props){
    super(props);
    this.state = {theShity: ''};
    
    this.onSearchyBoxChanged = this.onSearchyBoxChanged.bind(this);
  }
  
  onSearchyBoxChanged(event){
    this.setState({theShity: event.target.value});
  }
  
  onFormSubmit(event){
    event.preventDefault();
  }
  
  render(){
    return (
      <form onSubmit={this.onFormSubmit}lassName="input-group">
        <input 
          placeholder="enter ze city for ze wezza"
          className="form-control"
          value={this.state.theShity}
          onChange={this.onSearchyBoxChanged}
          />
        <span className="input-group-button">
          <button type="submit" className="btn btn-secondary" >Enter</button>
        </span>
      </form>
    );
  }
}