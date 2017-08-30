import { combineReducers } from 'redux';
import BlogsReducer from './blog_reducer';

const rootReducer = combineReducers({
  blogs:BlogsReducer
});

export default rootReducer;
