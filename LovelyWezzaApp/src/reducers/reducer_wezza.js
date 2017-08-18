import { FETCH_ZE_LOVELY_WEZZA } from '../actions/index';

export default function(state = [], action){
  console.log("WeatherReduxer: ", action.payload);
  switch (action.type){
    case FETCH_ZE_LOVELY_WEZZA:
      return [ action.payload.data, ...state ];
  }
  return state;
}
