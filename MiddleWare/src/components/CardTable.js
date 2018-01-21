import React, {Component} from 'react';

import SummonInfoCard from './SummonInfoCard';

class CardTable extends Component{

  constructor(props){
    super(props);
    this.renderSummonCardsRow = this.renderSummonCardsRow.bind(this)
  }

  //reorder summonInfo data into rows.
  //really this is an array of arrays where each array is another row of items
  orderSummonInfoByRow(summonInfo){
    let rowSummonInfoArr = [summonInfo.length%3];
    let currentRow = 0;

    //cover base case for first element of array
    rowSummonInfoArr[currentRow] = [];
    rowSummonInfoArr[currentRow].push(summonInfo[0]);

    for(let i = 1; i<summonInfo.length; i++){
      if(i%3 === 0){
        currentRow++;
        rowSummonInfoArr[currentRow] = [];
      }
      rowSummonInfoArr[currentRow].push(summonInfo[i])
    }
    return rowSummonInfoArr;
  }

  renderSummonCardsRow(summonInfoRow){
    return(
      <div style={{display:'flex'}}>
        {summonInfoRow.map(this.renderSummonCard)}
      </div>
    );
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
    let infoOrderedByRow = this.orderSummonInfoByRow(this.props.summonsInfo);
    return(
      <div>
        {infoOrderedByRow.map(this.renderSummonCardsRow)}
      </div>
    );
  }
}


export default CardTable;