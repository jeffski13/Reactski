import React, { Component } from 'react';

class TheGoogs extends Component {
  //
  componentDidMount(){
    //this.refs.map is the html element that google will embed its map into
    new google.maps.Map(this.refs.map, {
      zoom: 10,
      center: {
        lat: this.props.laty,
        lng: this.props.lony
      }
    });
  }

  render(){
    //can get reference to div element with this.refs.map
    // <div>
    //   <div>{this.props.cityName}</div>
    //   <div ref="map" />;
    // </div>
    return (
      <div>
        <div>{this.props.cityName}</div>
        <div ref="map" />
      </div>
    );

  }
}

export default TheGoogs;
