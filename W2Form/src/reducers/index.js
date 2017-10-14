import { combineReducers } from 'redux';
import BeastReducer from './reducer_beasts';

const rootReducer = combineReducers({
  beasts: BeastReducer
});

export default rootReducer;
