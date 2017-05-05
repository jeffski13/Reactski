import React from 'react';
import YTVidListItem from './vidlistItem';

const YtVidList = (props) => {

  //we define the variable up here that will return an html tag/jsx
  //then below we insert it into jsx with {<varname>} or in this case {ytVidListArrConst}
  const ytVidListArrConst = props.ytvidArr.map(
    (ytvideoitem) => {
      //pass the vid select down to vid item as prop
      return (
        <YTVidListItem
          onYtVidSelect = {props.onYtVidSelect}
          key={ytvideoitem.etag}
          ytvideoitem={ytvideoitem} />
      );
    }
  );

  return (
    <ul className="col-md-4 list-group" >
      {ytVidListArrConst}
    </ul>
  );
}

export default YtVidList;
