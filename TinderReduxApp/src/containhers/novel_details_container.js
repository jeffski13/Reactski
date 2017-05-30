import React, { Component } from 'react';
import { connect } from 'react-redux';

class NovelDetailContainer extends Component {

  render(){
    if(!this.props.novelProp){
      //show selection prompt message if nothing has been selected
      return (
        <div><strong>No novelski currently selected.</strong></div>
      );
    }

    return (
      <div>
        <div>
          <h3>Title: </h3>
          <div>{this.props.novelProp.novelName}</div>
        </div>
      </div>
    );
  }
}

function mapStateToProps(state){
  return {
    //NOTE: look inside the root reducer (we called "rootReduxer")
    // to get a list of state vars to choose from
    novelProp: state.reduxStateSelectedNovel
  };
}

//now a container due to this connection with redux
export default connect(mapStateToProps)(NovelDetailContainer);