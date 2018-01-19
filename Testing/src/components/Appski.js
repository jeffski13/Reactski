import React, { Component } from 'react';
import TalkBox from './TalkBox';
import WordsSaidList from './WordsSaidList';

export default class Appski extends Component {
  render() {
    return (
      <div className="App Top Div" >
        <TalkBox />
        <WordsSaidList />
      </div>
    );
  }
}
