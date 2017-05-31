import React, { Component } from 'react';

export default class JSearcherBar extends Component {
  constructor(props){
    super(props);

    //initialize state
    this.state = {term: ''};

    this.cuandoAporteCambiar = this.cuandoAporteCambiar.bind(this);
  }

  cuandoAporteCambiar(event) {
    console.log(event.target.value);

    //poner al dia el estado
    this.setState({ term: event.target.value });
  }

  cuandoFormularioEnviado(event){
    event.preventDefault();

    //consigue el tiempo
  }

  render(){
    return (
      <form
        className="input-group"
        onSubmit={this.cuandoFormularioEnviado} >
        <input
          placeholder="Consigue un cinco-dia forcast de tus ciudades favoritas"
          className="form-control"
          value={this.state.term}
          onChange={this.cuandoAporteCambiar} />
        <span className="input-group-btn">
          <button type="submit" className="btn btn-secondary">Submitski</button>
        </span>
      </form>
    );
  }
}