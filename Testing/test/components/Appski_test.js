import { renderReactComponent, expect } from '../test_helper';
import Appski from '../../src/components/Appski';
//describe groups tests together in togetherness
describe('The Appski Component', () =>{

  let composki;

  beforeEach(()=>{
    composki = renderReactComponent(Appski);
  });


  //it tests one thing in a components
  it('show box for wordy words', ()=>{
    //expect says something is or isnt true about something
     expect(composki.find('.talkBoxClass')).to.exist;
  });

  it('shows a talks list of words', ()=>{
    expect(composki.find('.wordsSaidList')).to.exist;
  });
});
