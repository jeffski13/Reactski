import React from 'react';

const BeastItem = (props) => {
  return (
    <li key={props.key} className="list-group-item">
      <div>{props.callingName} the {props.race}</div>
    </li>
  );
}

export default BeastItem;