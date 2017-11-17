import { BEASTY_CHOSEN } from '../actions/action-constants';
import { INIT_BEAST_LIST }  from  './reducer-constants';

export default function(state, action){
  //initial case
  if(state === undefined){
    state = null;
  }

  switch(action.type){
    case BEASTY_CHOSEN:
      return action.payload;
  }

  return state;
}