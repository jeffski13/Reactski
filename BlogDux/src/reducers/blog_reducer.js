import { GET_BLOGS } from '../actions';
import _ from 'lodash';

export default function(state = {}, action){
  switch (action.type) {
    case GET_BLOGS:
    console.log("blogs reducer, Getblogs Actions: ", action.payload.data);
      return _.mapKeys(action.payload.data, '_id');

    default:
      return state;
  }
}
