import {expect} from '../test_helper';
import saveWords, {SAVE_WORDS_ACTION} from '../../src/actions/saveWords';

describe('save words action', ()=>{
  it('has expected save word action type', ()=>{
    const saveWordsAction = saveWords();
    expect(saveWordsAction.type).to.equal(SAVE_WORDS_ACTION);
  });

  it('has expected words payload', ()=>{
    const saveWordsAction = saveWords('the written words');
    expect(saveWordsAction.payload).to.equal('the written words');
  });
});