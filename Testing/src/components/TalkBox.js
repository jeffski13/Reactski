import React, {Component} from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

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

  render(){
    return(
      <div className="talkBoxClass" >
        <MuiThemeProvider>
          <div>
            <TextField
               floatingLabelText="Talk go heres"
               onChange={this.handleWordsChanged.bind(this)}
               value={this.state.words}
                />
            <br />
            <RaisedButton
              label="Press to Leave Talks"
              primary={true} />
          </div>
        </MuiThemeProvider>
      </div>
    );
  }
}

export default TalkBox;
