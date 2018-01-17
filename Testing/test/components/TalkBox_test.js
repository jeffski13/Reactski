import {renderComponent, expect} from '../test_helper';

import TalkBox from '../../src/components/TalkBox';

describe('Talk Box Testes', ()=>{

  let composki;

  beforeEach(()=>{
    composki = renderComponent(TalkBox);
  });

  it('has correct css class', ()=>{
    expect(composki).to.have.class('talkBoxClass');
  });

  it('has a text area markup tag', ()=>{
    expect(composki.find('textarea')).to.exist;
  });

  it('has a clickable inputty thing', ()=>{
    expect(composki.find('button')).to.exist;
  });
});