import { combineReducers } from 'redux';
import wordsReducer from './words';

const rootReducer = combineReducers({
  wordsSaid: wordsReducer
});

export default rootReducer;
