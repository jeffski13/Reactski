import { combineReducers } from 'redux';
import ReduceHerNovelsList from './reduceher_novelsList_reducer';
import ReducerJeffski from './reduceher_jeffski_str';
import ReducerSelectedNovel from './reducer_selectednovel';

const rootReduxer = combineReducers({
  //mapping of state here with novels list
  reduxStateNovels:  ReduceHerNovelsList,
  reduxStateJeffski: ReducerJeffski,
  reduxStateSelectedNovel: ReducerSelectedNovel

  //now a global variable called "rootReduxBooks" exists
});

export default rootReduxer;