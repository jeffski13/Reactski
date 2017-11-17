import React from 'react';

const BeastItem = (props) => {
  return (
    <li
      key={props.key}
      className="list-group-item"
      onClick={props.onClick}
      >
      <div>{props.callingName} the {props.race}</div>
    </li>
  );
}

export default BeastItem;