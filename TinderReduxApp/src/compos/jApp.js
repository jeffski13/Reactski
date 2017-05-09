import React from 'react';
import {Component} from 'react';
import NovelsList from '../containHers/novels-list';

export default class NovelsApp extends Component{

  render(){
    return (
      <div>
        Novels App Compy
        <NovelsList />
      </div>
    );
  }

}