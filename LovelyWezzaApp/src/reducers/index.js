import { combineReducers } from 'redux';
//ADD NEW REDUCERS Here
import WetherReduxer from './reducer_wezza';

const rootReducer = combineReducers({
  wezzaState: WetherReduxer
});

export default rootReducer;
