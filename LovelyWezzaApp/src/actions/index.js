import axios from 'axios';

const WEZZA_API_KEU =  'd1348b43416b2b69803e84401416391b';
const WEZZA_URL = `http://api.openweathermap.org/data/2.5/forecast?appid=${WEZZA_API_KEU}`;

export const FETCH_ZE_LOVELY_WEZZA = 'LOVELY_WEZZA_WE_ARE_HAVING_HERE';

//make request for weather and return weather information in action payload
export function fetchWezza(cityStreets){
  const wezzaUrl = `${WEZZA_URL}&q=${cityStreets},us`;
  const wezzaRequest = axios.get(wezzaUrl);

  console.log('Requestski from action file: ', wezzaRequest);

  //NOTE: the payload contains the promise from the weather api call (not technically the data?)
  return{
    type: FETCH_ZE_LOVELY_WEZZA,
    payload: wezzaRequest
  }
}
