import React from 'react';
import {Sparklines, SparklinesLine } from 'react-sparklines';

export default (props) => {
  return(
    <div>
      <Sparklines  height={120} width={150} data={props.chartData}>
        <SparklinesLine color={props.color} />
      </Sparklines>
    </div>
  );
}
