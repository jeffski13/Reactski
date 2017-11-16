import React, { Component } from 'react';
import BeastList from '../containers/beast_list';
import BeastCurrent from '../containers/beast_current';

export default class App extends Component {
  render() {
    return (
      <div>
        <BeastList />
        <BeastCurrent />
      </div>
    );
  }
}
