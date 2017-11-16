import { BEASTY_CHOSEN } from '../actions/action-constants';

export default function(state = null, action){
  switch(action.type){
    case BEASTY_CHOSEN:
      return action.payload;
  }

  return state;
}