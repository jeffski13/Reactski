//using es6 modules
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import JBarSearch from './compos/jBarSearch';
import YTSearch from 'youtube-api-search';
import YtVidList from './compos/vidlist';
import YTVidDetail from './compos/vidDets';

//creating new component (like a class), component should produce HTML
//const -es2016 syntax
//NOTE: it would SEEM (apparently) that you have to start components with a capitol letter
class JApp extends Component{

  constructor(props){
    super(props);

    //this.state = {}; instantiates to empty object
    //NOTE: in class props are available everywhere all the time.
    this.state = {
      jAppVids: [],
      jAppCurrentVid: null
     }; //set up video arr property

     //call initial search
     this.ytVideoSearch('remind me of the babe');
  }

  render(){
    return (
      //HTML stuff is JSX, then compiled by webpack and babel
      <div>
        {/*pass search callback down into searchbar*/}
        <JBarSearch onJSearchStrChanged={searchStr => this.ytVideoSearch(searchStr)} />
        <YTVidDetail ytVidDetail={this.state.jAppCurrentVid} />
        {/* pass videos (from search above) to YtVidList
          also defining function to update selected video by passing property down to vidList*/}
        <YtVidList
          onYtVidSelect = {
            selectedVideo => this.setState({ jAppCurrentVid : selectedVideo })
          }
          ytvidArr={this.state.jAppVids} />
      </div>
    );
  }

  ytVideoSearch(queryStr){
    //passing configuration option and callback
    YTSearch({key: YT_KEY, term: queryStr}, (searchVidsResp) => {
        //at this point list of videos is in parameter
        this.setState({ jAppVids : searchVidsResp }); //assign to state property (prop)
        this.setState({ jAppCurrentVid : searchVidsResp[0]});
      }
    );
  }
}

//new es6 syntax which makes a custom tag ("JeffApp") with html inside
const JeffApp = () => {
  return <div>YOLO32</div>;
}

//key from console.developers.google.com
const YT_KEY = 'AIzaSyBXOl1o6smPI9FA7pUas7-6Mc5GVAXI2DM';



//put an instance of the JApp component into page (in DOM)
ReactDOM.render(<JApp />,  document.querySelector('.jContainHer'));
