//using es6 modules
import { combineReducers } from 'redux';
import ReduceHerNovelsList from './reduceHer_novelsList'

const rootReduxer = combineReducers({
  //mapping of state here
  rootReduxBooks:  ReduceHerNovelsList;
});

export default rootReduxer;
