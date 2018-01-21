import React, {Component} from 'react';
import {connect} from 'react-redux';

export default function(ComposedComponent){

  class requireGuildMembership extends Component{

    static contextTypes = {
      router: React.PropTypes.object
    }

    //runs before first render
    componentWillMount(){
      if(!this.props.isGuildMember){
        this.context.router.push('/accessDenied');
      }
    }

    //called when props are rehanded to component
    componentWillUpdate(updatedProps){
      if(!updatedProps.isGuildMember){
        this.context.router.push('/');
      }
    }

    render(){
      return(
        <ComposedComponent {...this.props} />
      );
    }

  }

  function mapStateToProps(state){
    return{isGuildMember: state.authStatus}
  }
  return connect(mapStateToProps)(requireGuildMembership);

}

/* [for Reference: Lecture 41: HOC Scaffold Code,
 * https://www.udemy.com/react-redux-tutorial/learn/v4/t/lecture/4700804?start=0]
 *how to use higher order component:
 *keep in mind this is meant to be used in App or something.
 *You wrap the simple component (TreasureRoom) with Security and
 * immidiately use the wrapped component in App's render method

//in, for example, App.js
import RequireGuildMembership from './RequireGuildMembership';
import TreasureRoom from './TreasureRoom';

const SecureTreasureRoom=RequireGuildMembership(TreasureRoom);
//render method
//we can pass in props just like we do in <TreasureRoom />
<SecureTreasureRoom propName={this.variableName} />
*/