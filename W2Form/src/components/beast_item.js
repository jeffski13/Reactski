import React from 'react';

const BeastItem = (props) => {
  return (
    <li className="list-group-item">
      <div>{props.callingName} the {props.type}</div>
    </li>
  );
}

export default BeastItem;