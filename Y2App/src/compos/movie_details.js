import React from 'react';

const MovieDetail = (props) => {


  const movieUrl = `https://www.youtube.com/embed/${props.movieId}`;

  return (
    <div className="video-detail col-md-8">
      <div className="embed-responsive embed-responsive-16by9">
        <iframe className="embed-responsive-item" src={movieUrl}></iframe>
      </div>
      <div className="details">
        <div>{props.title}</div>
        <div>{props.desc}</div>
      </div>

    </div>

  );
}

export default MovieDetail;