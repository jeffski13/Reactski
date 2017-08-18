import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { fetchWezza } from '../actions/index';

//search bar component,
//where user can enter city name and hooks into call for weather info
class JSearchBar extends Component {

  constructor(props){
    super(props);
    //empty initial state for whats in the search bar
    this.state = { jSearchTerm: '' };

    //NOTE: methods below are callback functions, which means "this" is a mystery context
    //and the trigger man is amongst you!
    //lines below allow us to use 'this' as if we are in this class
    this.onJSearchBoxChange = this.onJSearchBoxChange.bind(this);
    this.onJSearchFormSubmit = this.onJSearchFormSubmit.bind(this);
  }

  onJSearchBoxChange(event){
    this.setState({ jSearchTerm : event.target.value });
  }

  onJSearchFormSubmit(event){
    event.preventDefault();

    //get ze wezza!
    //NOTE: we have this information at this point in the react state
    this.props.fetchWezza(this.state.jSearchTerm);

    //clear out state
    this.setState({ jSearchTerm: '' });

    //NOTE: add in disabling search bar when submitting?
    //and put loading into search bar? on timer...
    //with dot dot dot...   so much cool stuff we can do
  }

  render(){
    return (
      <form className="input-group" onSubmit={this.onJSearchFormSubmit}>
        <input className="form-control"
            placeholder="Enter City Here"
            value={this.state.jSearchTerm}
            onChange={this.onJSearchBoxChange}
          />
        <span className="input-group-btn">
          <button type="submit" className="btn btn-secondary">Submits</button>
        </span>
      </form>
    );
  }
}

function mapDispatchToProps(dispatch){
  return bindActionCreators({ fetchWezza }, dispatch);
}

//passing in null because we arent interested in the redux state?
//...then why set this ish up? because, we can call this.props.fetchWezza, which is part of redux
export default connect(null, mapDispatchToProps)(JSearchBar);
