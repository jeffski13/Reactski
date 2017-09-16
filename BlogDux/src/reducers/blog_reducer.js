import { GET_BLOGS, GET_ONE_BLOG } from '../actions';
import _ from 'lodash';

export default function(state = {}, action){
  switch (action.type) {
    case GET_BLOGS:
      console.log("blogs reducer, Getblogs Actions: ", action.payload.data);
      return _.mapKeys(action.payload.data, '_id');
    case GET_ONE_BLOG:
      //here we are doing 'key interpolation', with key being what in the square brackets and the value being the data
      return {...state, [action.payload.data._id]: action.payload.data};
    default:
      return state;
  }
}
