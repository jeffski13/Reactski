import React, { Component } from 'react';

import NavigationBar from './NavigationBar';
import MainBase from './MainBase';

export default class App extends Component {
  render() {
    console.log(this.props.children);
    return (
      <div>
        <NavigationBar />
        {this.props.children}
      </div>
    );
  }
}