import React, {Component} from 'react';
import { connect } from 'react-redux';

class BeastCurrent extends Component{

  render(){

    let selectedBeast =  'NA';
    if(this.props.disBeast !== null){
      selectedBeast = this.props.disBeast.name;
    }

    return (
      <div>CurrentBeast: {selectedBeast}</div>
    );
  }
}

function mapStateToProps(state){
  return {
    disBeast: state.currentBeast
  };
}

export default connect(mapStateToProps)(BeastCurrent);