import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { chooseBeasty } from '../actions/index';
import BeastItem from '../components/beast_item'

class BeastList extends Component {

  renderBeastItems(){
    return this.props.deezBeasts.map((nextBeast) => {
      return (
        <BeastItem
          key={nextBeast.name}
          callingName={nextBeast.name}
          race={nextBeast.type}
          onClick={() => this.props.chooseBeasty(nextBeast)} />
      );
    });
  }

  render(){
    return (
      <ul className="list-group col-sm-4">{this.renderBeastItems()}</ul>
    );
  }

}

//map state to props means putting things in the props object
// as if we had handed them in a element attributes
function mapStateToProps(state){
  return {
    deezBeasts: state.allBeasts
  };
}

function mapDispatchToProps(dispatch){
  return bindActionCreators({ chooseBeasty: chooseBeasty }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(BeastList);