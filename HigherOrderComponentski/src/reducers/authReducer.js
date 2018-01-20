import { LOGIN_ACTION } from '../actions/login';
import { LOGOUT_ACTION } from '../actions/logout';

export default function(state={loggedIn: false}, action){
  switch(action.type){
    case LOGIN_ACTION:
      return {loggedIn: true};
    case LOGOUT_ACTION:
      return {loggedIn: false};
  }
  return state;
}