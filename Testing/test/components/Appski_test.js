import { renderComponent, expect } from '../test_helper';
import Appski from '../../src/components/Appski';
//describe groups tests together in togetherness
describe('The Appski Component', () =>{

  let composki;

  beforeEach(()=>{
    composki = renderComponent(Appski);
  });


  //it tests one thing in a components
  it('show box for wordy words', ()=>{
     expect(composki.find('.talkBoxClass')).to.exist;
  });

  //expect says something is or isnt true about something

});
