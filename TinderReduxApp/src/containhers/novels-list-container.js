import React, { Component } from 'react';
import { connect } from 'react-redux';
import { getDatNovelActions } from '../acshyons/index';
import { bindActionCreators } from 'redux';

//Container (SmartComponent): a react component that has access to the redux state
class NovelsListContainer extends Component {

  //note: key below should be unique (we are assuming the title will be unique)
  renderNovelsList(){
    return this.props.novelsProps.map((novel) => {
      return (
          <li key={novel.novelName}
            onClick={() => this.props.getDatNovel(novel)}
            className="list-group-item" >
              {novel.novelName}
          </li>
      );
    });
  }

  render(){
    console.log(this.props.jeffskiProps.jeffskiTestStr);
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
    novelsProps: state.reduxStateNovels,
    jeffskiProps: state.reduxStateJeffski
  };
}

//everything returned here will eventually be props on this container
function mapDispatchToProps(dispatcheThere){
  //if selectDatNovel gets called, send results go to all reducers.
  //now we can call this.props.selectDatNovel
  return bindActionCreators({ getDatNovel: getDatNovelActions }, dispatcheThere);
}

//connect method takes function and component and makes a container.
//makes selectDatNovel available as prop.
export default connect(mapStateToProps, mapDispatchToProps)(NovelsListContainer);
