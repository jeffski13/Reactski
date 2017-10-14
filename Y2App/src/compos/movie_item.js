import React from 'react';

const MovieItem = (props) => {
  return (
    <li onClick={ () => props.onMovieItemSelect(props.rawMov) } className="list-group-item">
      <div className="video-list media">
        <div className="media-left">
          <img className="media-object" src={props.picUrl} />
        </div>
        <div className="media-body">
          <div className="media-heading">
          {props.title}
          </div>
        </div>
      </div>
    </li>
  );
}

export default MovieItem;