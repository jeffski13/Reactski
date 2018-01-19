export const SAVE_WORDS_ACTION = 'SAVE_WORDS_ACTION';

export default function saveWords(wordsTheyDunSaid){
  return {
    type: SAVE_WORDS_ACTION,
    payload: wordsTheyDunSaid
  };
}