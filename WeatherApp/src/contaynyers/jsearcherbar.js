import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import getDatWeather from '../actions/index';

class JSearcherBar extends Component {
  constructor(props){
    super(props);

    //initialize state
    this.state = {searchCityStr: ''};

    this.cuandoAporteCambiar = this.cuandoAporteCambiar.bind(this);
    this.cuandoFormularioEnviado = this.cuandoFormularioEnviado.bind(this);
  }

  cuandoAporteCambiar(event) {
    console.log(event.target.value);

    //poner al dia el estado
    this.setState({ searchCityStr: event.target.value });
  }

  cuandoFormularioEnviado(event){
    event.preventDefault();

    //consigue el tiempo
    this.props.getDatWeather(this.state.searchCityStr);
    //Nota: despues cambiando el estado, render() ejecuta  otra vez
    this.setState({ searchCityStr: ''});
  }

  render(){
    return (
      <form
        className="input-group"
        onSubmit={this.cuandoFormularioEnviado} >
        <input
          placeholder="Consigue un cinco-dia forcast de tus ciudades favoritas"
          className="form-control"
          value={this.state.searchCityStr}
          onChange={this.cuandoAporteCambiar} />
        <span className="input-group-btn">
          <button type="submit" className="btn btn-secondary">Submitski</button>
        </span>
      </form>
    );
  }
}

function mapDispatchToProps(dispatch){
  return bindActionCreators({ getDatWeather }, dispatch);
}

export default connect(null, mapDispatchToProps)(JSearcherBar);
