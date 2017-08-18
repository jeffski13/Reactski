import React from 'react';
import {Sparklines, SparklinesLine, SparklinesReferenceLine } from 'react-sparklines';
import _ from 'lodash';

function avrg(numArr){
  return _.round(_.sum(numArr)/numArr.length);
}

export default (props) => {
  return(
    <div>
      <Sparklines  height={120} width={150} data={props.chartData}>
        <SparklinesLine color={props.color} />
        <SparklinesReferenceLine type="avg" />
      </Sparklines>
      <div>{avrg(props.chartData)} {props.units}</div>
    </div>
  );
}
