import React from 'react';
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';

export default () => {
  return(
    <div>
      <div>Secret Treasure Vault</div>
      <div>* * * Guild Members Only * * *</div>
      <br />
      <Card className="treasureCard" >
        <CardHeader
          title="Hoard Guardian"
          subtitle="Black Doves Watch"
          avatar="img/laughingCoffin.png"
        />
        <CardMedia
          overlay={<CardTitle title="Treasure of the Black Doves Guild" />}
        >
          <img src="img/hoard.jpg" alt="" />
        </CardMedia>
        <CardTitle title="" />
        <CardText>
          This treasure has been guarded for centuries by the heroes and villians of the
          Black Doves Guild. Treasures herein are split amongst each member of the Guild
          with graduated portions given to the highest ranking individuals of the guild.
        </CardText>
      </Card>
    </div>
  );
}