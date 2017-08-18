import React, { Component } from 'react';
import JSearchBar from '../containers/j_search_bar';
import WeatherGrid from '../containers/weather_grid';

export default class App extends Component {
  render() {
    return (
      <div>
        <div>React simple starter</div>
        <JSearchBar />
        <WeatherGrid />
      </div>
    );
  }
}
