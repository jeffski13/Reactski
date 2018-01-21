export default function({dispatch}){
  return next => action => {
    console.log('Promise Helper Middleware: ', action.type);
    if(!action.payload || !action.payload.then){
      //if no promise, send it fourth
      //send action to next middleware (or to reducers if at the end)
      return next(action);
    }

    console.log('Promise Helper Middleware: found promise');
    //wait for promise to resolve
    action.payload.then(function(response){
      //create new action with payload of response and send through middlewares
      //NOTE: everything is the same for the action except the response
      const actionWithResponseData = {...action, payload: response};
      //run action through everything
      dispatch(actionWithResponseData);
    });
  }
}