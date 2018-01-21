import React, {Component} from 'react';

import SummonInfoCard from './SummonInfoCard';

class CardTable extends Component{

  constructor(props){
    super(props);
  }

  renderSummonCard(summonInfoItem){
    return(
      <SummonInfoCard
        name={summonInfoItem.name}
        title={summonInfoItem.title}
        description={summonInfoItem.description}
        imgName={summonInfoItem.imgName}
        />
    );
  }

  render(){
    return(
      <div className="summonCardList">
        {this.props.summonsInfo.map(this.renderSummonCard)}
      </div>
    );
  }
}


export default CardTable;