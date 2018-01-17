import React, {Component} from 'react';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';

class TalkBox extends Component{
  render(){
    return(
      <div className="talkBoxClass" >
        <TextField
           floatingLabelText="Talk go heres"
         />
        <br />
        <RaisedButton
          label="Press to Leave Talks"
          primary={true} />
      </div>
    );
  }
}

export default TalkBox;