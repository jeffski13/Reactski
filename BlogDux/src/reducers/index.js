import { combineReducers } from 'redux';
import { reducer as reduxFormReducer } from 'redux-form';
import BlogsReducer from './blog_reducer';

const rootReducer = combineReducers({
  blogs:BlogsReducer,
  form: reduxFormReducer
});

export default rootReducer;
