import React, { Component } from 'react';
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import RaisedButton from 'material-ui/RaisedButton';

class SummonInfoCard extends Component{
  render(){

    return(
      <Card className="summonCard">
        <CardHeader
          title={this.props.name}
          subtitle={this.props.title}
          avatar={this.props.imgName}
        />
        <CardText>
          {this.props.description}
        </CardText>
        <CardActions>
          <RaisedButton label="Summmon" />
        </CardActions>
      </Card>
    );
  }
}

export default SummonInfoCard;