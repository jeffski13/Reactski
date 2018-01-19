import React, {Component} from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

import saveWords from '../actions/saveWords';

class TalkBox extends Component{

  constructor(props){
    super(props);
    this.state={
      words: ''
    };
  }

  handleWordsChanged(event){
    this.setState({words: event.target.value});
  }

  handleSubmittal(event){
    event.preventDefault();
    this.props.saveWords(this.state.words);
    this.setState({words: ''});
  }

  render(){
    return(
      <form className="talkBoxClass"
        onSubmit={this.handleSubmittal.bind(this)} >
        <MuiThemeProvider>
          <div>
            <TextField
               floatingLabelText="Talk go heres"
               onChange={this.handleWordsChanged.bind(this)}
               value={this.state.words} />
            <br />
            <RaisedButton
              onClick={this.handleSubmittal.bind(this)}
              label="Press to Leave Talks"
              primary={true} />
          </div>
        </MuiThemeProvider>
      </form>
    );
  }
}

function mapDispatchToProps(dispatch){
  return bindActionCreators({ saveWords }, dispatch);
}

export default connect(null, mapDispatchToProps)(TalkBox);