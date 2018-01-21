import {GET_SUMMON_INFO_ACTION} from '../actions/getSummonsInfo';

export default function(state=[], action){
  console.log('jeffski reducing: ', action);
  switch(action.type){
    case GET_SUMMON_INFO_ACTION:
      console.log('jeffski reducer found summons info');
      return action.payload.data;
  }
  return state;
}