import React, {Component} from 'react';
import { connect } from 'react-redux';

class BeastCurrent extends Component{

  render(){
    //if there is no selection, prompt user to make one
    if(!this.props.disBeast){
        return (
          <div>Please click a Beast!</div>
        );
    }

    //display info on selected beast
    return (
      <div>
        <h3><strong>Current Beast:</strong> {this.props.disBeast.name}</h3>
        <div><strong>Race:</strong> {this.props.disBeast.type}</div>
        <div><strong>Details:</strong> {this.props.disBeast.origin}</div>
      </div>
    );
  }
}

function mapStateToProps(state){
  return {
    disBeast: state.currentBeast
  };
}

export default connect(mapStateToProps)(BeastCurrent);