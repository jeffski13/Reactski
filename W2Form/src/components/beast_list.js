import React, { Component } from 'react';
import BeastItem from 'beast_item'

export default class BeastList extends Component {

  renderBeastListItems(){
    return this.props.beasts.map((nextBeast) => {
      return (
        <BeastItem key={nextBeast.name} callingName={nextBeast.name} race={nextBeast.type} />
      );
    });
  }

  render(){
    return (
      <ul className="list-group col-sm-4">{this.renderBeastItems}</ul>
    );
  }
}