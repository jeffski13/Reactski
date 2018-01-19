import { SAVE_WORDS_ACTION } from '../actions/saveWords';

export default function(state=[], action){
  switch(action.type){
    case SAVE_WORDS_ACTION:
      return [...state, action.payload];
  }
  return state;
}