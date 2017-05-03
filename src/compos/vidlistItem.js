import React from 'react';

const YTVidListItem  = ({ytvideoitem, onYtVidSelect}) => {

  const imageUrlPath = ytvideoitem.snippet.thumbnails.default.url;
  const vidTitle = ytvideoitem.snippet.title;
  return (
    //whenever im clicked call that function declared up in
    // the JApp using the video "this" list item was passed
    <li onClick={() => onYtVidSelect(ytvideoitem)} className="list-group-item">
      <div className="video-list media">
        <img className="media-object" src={imageUrlPath} />
      </div>
      <div className="media-body">
        <div className="media-heading">{vidTitle}</div>
      </div>
    </li>
  );
};

export default YTVidListItem;
