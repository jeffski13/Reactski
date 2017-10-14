import React from 'react';
import MovieItem from './movie_item';

const MovieList = (props) => {

  const movItemArr = props.movs.map(function(nextMov){
    return (
      <MovieItem
        rawMov={nextMov}
        title={nextMov.snippet.title}
        key={nextMov.id.videoId}
        picUrl={nextMov.snippet.thumbnails.default.url}
        onMovieItemSelect={props.onMovieSelect}
         />
   );
  });

  // loop over movs arr and generate list items
  return (
    <div>
      <div>MovieList component</div>
      <div>number of vids: {props.movs.length}</div>
      <ul className="col-md-4 list-group" >
        { movItemArr }
      </ul>
    </div>
  );
}

export default MovieList;