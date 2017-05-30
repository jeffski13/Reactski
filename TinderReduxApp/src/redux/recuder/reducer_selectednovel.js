//if first param is undefined, we will set it to null
export default function(localReducerState = null, action) {
  //filter by action
  if(action.type === 'NOVEL_ACTION_TYPE'){
    return action.payload;
  }

  //note that above we made the undefined state null.
  // (this will hit when we first boot up)
  return localReducerState;
}