import React, { Component } from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import ReactLoading from 'react-loading';
import _ from 'lodash';

import SummonInfoCard from './SummonInfoCard';
import CardTable from './CardTable';
import getSummonsInfo from '../actions/getSummonsInfo';
class App extends Component {

  componentWillMount(){
    console.log('jeffski mount App');
    this.props.getSummonsInfo();
  }

  render() {
    return (
      <div>
        {this.props.summonsInfo.length === 0
          ? <ReactLoading type="cylon" color="#333" height="100px" width="100px"/>
          : <CardTable summonsInfo={this.props.summonsInfo} /> }
      </div>
    );
  }
}

function mapDispatchToProps(dispatch){
  return bindActionCreators({getSummonsInfo}, dispatch);
}

function mapStateToProps(state){
  return {summonsInfo: state.summonsInfo}
}

export default connect(mapStateToProps, mapDispatchToProps)(App);