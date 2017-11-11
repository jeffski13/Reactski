import React, { Component } from 'react';
import BeastItem from '../components/beast_item'
import { connect } from 'react-redux';
import { chooseBeasty } from '../actions/index';
import { bindActionCreators } from 'redux';
class BeastList extends Component {

  renderBeastItems(){
    return this.props.deezBeasts.map((nextBeast) => {
      return (
        <BeastItem
          onClick={() => this.props.chooseBeasty(nextBeast)}
          key={nextBeast.name} callingName={nextBeast.name} race={nextBeast.type} />
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
    deezBeasts: state.beasts
  };
}

function mapDispatchToProps(dispatch){
  return bindActionCreators({chooseBeasty: chooseBeasty}, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(BeastList);