import { combineReducers } from 'redux';
import summonsInfoReducer from './TheSummons';

const rootReducer = combineReducers({
  summonsInfo: summonsInfoReducer
});

export default rootReducer;
