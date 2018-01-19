import {expect} from '../test_helper';
import wordsReducer from '../../src/reducers/words';
import { SAVE_WORDS_ACTION } from '../../src/actions/saveWords';

describe('words reducer', ()=>{
  it('handles action with unknown type', ()=>{
    //expect nothing if not saving words type
    //call with no initial state and no action
    expect(wordsReducer(undefined, {})).to.eql([]);
  });

  it('handles actions for saving words', ()=>{
    const mockSaveWordsAction = {
      type: SAVE_WORDS_ACTION,
      payload: 'random words words words'
    }

    expect(wordsReducer([], mockSaveWordsAction)).to.eql(['random words words words']);
  });

});