import {GET_SUMMON_INFO_ACTION} from '../actions/getSummonsInfo';

export default function(state=[], action){
  switch(action.type){
    case GET_SUMMON_INFO_ACTION:
      return action.payload;
  }
  return state;
}