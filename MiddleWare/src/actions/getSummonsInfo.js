import axios from  'axios';

export const GET_SUMMON_INFO_ACTION = 'GET_SUMMON_INFO_ACTION';

export default function getSummonsInfo(){
  const request = axios.get('https://jsonplaceholder.typicode.com/users');
  return {
    type: GET_SUMMON_INFO_ACTION,
    payload: request
  };
}