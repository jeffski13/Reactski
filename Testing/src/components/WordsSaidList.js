import React, { Component } from 'react';
import {List, ListItem} from 'material-ui/List';
import Subheader from 'material-ui/Subheader';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import { connect } from 'react-redux';

class WordsSaidList extends Component{

  render(){
    return(
      <div className="wordsSaidList" >
        <MuiThemeProvider>
          <List>
            <Subheader>The Words of the Past</Subheader>
            {this.props.prevWordsSaid.map(this.renderWordsSaidListItem)}
          </List>
        </MuiThemeProvider>
      </div>
    );
  }

  renderWordsSaidListItem(wordsSaidText){
    return(
      <ListItem className="wordsSaidListItem"
        primaryText={wordsSaidText}
        secondaryText="2 text"
      />
    );
  }

}

function mapStateToProps(state){
  return {prevWordsSaid: state.wordsSaid};
}

export default connect(mapStateToProps)(WordsSaidList);