import React from 'react';
import {Component} from 'react';
import NovelsListContainer from '../containhers/novels-list-container';

export default class NovelsApp extends Component{

  render(){
    return (
      <div>
        <div>Novels, An App Component</div>
        <NovelsListContainer />
      </div>
    );
  }

}
