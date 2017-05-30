import React from 'react';
import { Component } from 'react';
import NovelsListContainer from '../containhers/novels_list_container';
import NovelDetailContainer from '../containhers/novel_details_container';

export default class NovelsApp extends Component{

  render(){
    return (
      <div>
        <div>Novels, An App Component</div>
        <NovelsListContainer />
        <NovelDetailContainer />
      </div>
    );
  }

}
