import {renderReactComponent, expect} from '../test_helper';
import WordsSaidList from '../../src/components/WordsSaidList';

describe('WordsSaidList component', ()=>{
  let wordsSaidListComponent;

  beforeEach(()=>{
    const wordsSaidProps = {wordsSaid:['the first words', "the forgotten ones", 'the last words']};
    wordsSaidListComponent = renderReactComponent(WordsSaidList, null, wordsSaidProps);
  });

  it('shows items for each words said', ()=>{
    expect(wordsSaidListComponent.find('.wordsSaidListItem').length).to.equal(3);
  });

  it('shows all words said', ()=>{
    expect(wordsSaidListComponent).to.contain('the first words');
    expect(wordsSaidListComponent).to.contain('the forgotten ones');
    expect(wordsSaidListComponent).to.contain('the last words');
  });

});