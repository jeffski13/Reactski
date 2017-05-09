import React, { Component } from 'react';
import { connect } from 'react-redux';

//Container (SmartComponent): a react component that has access to the redux state
class NovelsListContainer extends Component {

  //note: key below should be unique (we are assuming the title will be unique)
  renderNovelsList(){
    return this.props.novelsProps.map((indiNovel) => {
      return (
          <li key={indiNovel.novelName} className="list-group-item">{indiNovel.novelName}</li>
      );
    });
  }

  render(){
    return (
      <ul className="list-group col-sm-4">
        {this.renderNovelsList()}
      </ul>
    )
  }

}

//vars returned will be props in NovelsList class.
//Also we can grab stuff from the state here
function mapStateToProps(state) {
  return {
    novelsProps: state.rootReduxBooks
  };
}

//connect method takes function and component and makes a container
export default connect(mapStateToProps)(NovelsListContainer);
