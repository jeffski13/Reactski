import { BEASTY_CHOSEN } from './action-constants';

export function chooseBeasty(beasty){
  console.log('chooseBeasty: selected beast by the name of ', beasty.name);
  return{
    type: BEASTY_CHOSEN,
    payload: beasty
  }

}