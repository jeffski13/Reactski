import { combineReducers } from 'redux';
import BeastReducer from './beasts';
import CurrentBeastReducer from './current_beast'

const rootReducer = combineReducers({
  allBeasts: BeastReducer,
  currentBeast: CurrentBeastReducer
});

export default rootReducer;
