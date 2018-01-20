import { LOGIN_ACTION } from '../actions/login';
import { LOGOUT_ACTION } from '../actions/logout';

export default function(state=false, action){
  switch(action.type){
    case LOGIN_ACTION:
      return true;
    case LOGOUT_ACTION:
      return false;
  }
  return state;
}