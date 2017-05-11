import { combineReducers } from 'redux';
import ReduceHerNovelsList from './reduceher_novelsList_reducer';
import ReducerJeffski from './reduceher_jeffski_str';

const rootReduxer = combineReducers({
  //mapping of state here with novels list
  reduxStateNovels:  ReduceHerNovelsList,
  reduxStateJeffski: ReducerJeffski

  //now a global variable called "rootReduxBooks" exists
});

export default rootReduxer;
