export const LOGOUT_ACTION = 'LOGOUT_ACTION';

export default function logout(){
  return{
    type: LOGOUT_ACTION,
    payload: {}
  }
}