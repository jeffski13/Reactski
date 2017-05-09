import React, { Component } from 'react';
//Container (SmartComponent): a react component that has access to the redux state
export default class NovelsList extends Component {

  //note: key below should be unique (we are assuming the title will be unique)
  renderNovelsList(){
    return this.props.novels.map((novel) => {
      return (
        <li key={novel.novelName} className="list-group-item">{novel.novelName} />
      );
    });
  }

  render(){
    return (
      <ol className="list-group col-sm-4">
        {this.renderNovelsList()}
      </ol>
    );
  }

}