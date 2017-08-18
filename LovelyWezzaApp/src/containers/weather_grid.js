import React, { Component } from 'react';
import { connect } from 'react-redux';
import WeatherChart from '../components/weather_chart';
import TheGoogs from '../components/the_googs'

class WeatherGrid extends Component {

  //throw all the weather info in here and we will parse it into charts
  renderZeWeather(cityStuff){

    const tempData = cityStuff.list.map(weather => weather.main.temp);
    const preshData = cityStuff.list.map(weather => weather.main.pressure);
    const humData = cityStuff.list.map(weather => weather.main.humidity);

    return(
      <tr key={cityStuff.city.name}>
        <td><TheGoogs
          laty={cityStuff.city.coord.lat}
          lony={cityStuff.city.coord.lon}
          cityName={cityStuff.city.name} />
        </td>
        <td>
          <WeatherChart chartData={tempData} color="green" units="k" />
        </td>
        <td>
          <WeatherChart chartData={preshData} color="red" units="hPa" />
        </td>
        <td>
          <WeatherChart chartData={humData} color="grey" units="%" />
        </td>
      </tr>
    );
  }

  render(){
    return (
      <table className="table table-hover">
        <thead>
          <tr>
            <th>City</th>
            <th>Temp</th>
            <th>Presh</th>
            <th>Hum</th>
          </tr>
        </thead>
        <tbody>
          {this.props.wezzaState.map(this.renderZeWeather)}
        </tbody>
      </table>
    );
  }
}

function mapStateToProps({ wezzaState }) {
   return { wezzaState };
}

export default connect(mapStateToProps)(WeatherGrid);
