//a component or view.
//you can nest components one inside the other
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import YTSearch from 'youtube-api-search';
import ReactLoading from 'react-loading';
import _ from 'lodash';

import Searchy from './compos/searchy'
import MovieList from './compos/movie_list'
import MovieDetail from './compos/movie_details'
import { YT_API_KEY } from './consts'


//component, just some javascript thats going to make HTML
class Y2App extends Component {
  constructor(props){
    super(props);
    //init state
    this.state = {
      ytmovs: [],
      currentmov : null
    };

    this.movieSearch('star chores');
  }

  movieSearch(searchStr){
    //make init search for vids
    YTSearch({key: YT_API_KEY, term: searchStr}, (videeData) => {
      console.log(videeData);
      //delay to show off our cool loading spinner
      setTimeout(() => {
        this.setState({
          ytmovs: videeData,
          currentmov: videeData[0]
        }); }, 2500);
    });
  }

  render(){
    //returns new method that can only be called every so many seconds
    const movieSearchSlow = _.debounce((searchStr) => { this.movieSearch(searchStr) }, 200);

    //if we have movies, show them
    if(this.state.ytmovs.length > 0){
      return(
        <div>
          <h1>Youtube App</h1>
          <Searchy
            searchesAChangin={movieSearchSlow}
            />
          <MovieDetail
            movieId={this.state.currentmov.id.videoId}
            title={this.state.currentmov.snippet.title}
            desc={this.state.currentmov.snippet.description}
            />
          <MovieList
            movs={this.state.ytmovs}
            onMovieSelect={
              selectedMovie => {
                this.setState({currentmov: selectedMovie})
              }
            }
             />
        </div>
      );
    }
    //default for loading
    else{
      return(
        <div>
          <h1>Youtube App</h1>
          <ReactLoading type="spinningBubbles" color="#31a" />
        </div>
      );
    }
  }
}

//take component and put on page (on DOM)
//note: this needs an INSTANCE of a component, hence the tag around Y2App
ReactDOM.render(<Y2App />, document.querySelector('.container'));