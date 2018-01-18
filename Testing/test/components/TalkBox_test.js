import {renderComponent, expect} from '../test_helper';

import TalkBox from '../../src/components/TalkBox';

describe('Talk Box Testes', ()=>{

  let talkBoxComponent;

  beforeEach(()=>{
    talkBoxComponent = renderComponent(TalkBox);
  });

  it('has correct css class', ()=>{
    expect(talkBoxComponent).to.have.class('talkBoxClass');
  });

  it('has a text area markup tag', ()=>{
    expect(talkBoxComponent.find('input')).to.exist;
  });

  it('has a clickable inputty thing', ()=>{
    expect(talkBoxComponent.find('button')).to.exist;
  });

  describe('what happens when words are entered', ()=>{
    beforeEach(()=>{
      talkBoxComponent.find('input').simulate('change', 'test data words');
    });

    it('has words that were worded', ()=>{
      expect(talkBoxComponent.find('input')).to.have.value('test data words');
    });

    it('clears input when button pressed', ()=>{

    });
  });
});
