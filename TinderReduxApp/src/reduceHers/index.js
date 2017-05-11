import { combineReducers } from 'redux';
import ReduceHerNovelsList from './reduceher_novelsList'

const rootReduxer = combineReducers({
  //mapping of state here
  rootReduxBooks:  ReduceHerNovelsList
});

export default rootReduxer;