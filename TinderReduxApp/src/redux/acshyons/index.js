//action creator for select novel
export function getDatNovelAction(novel){
  console.log('thus lit hath been chosen: ', novel.novelName);

  //return an actual action
  //(action here bring an object with a type and a payload)
  return{
    type: 'NOVEL_ACTION_TYPE',
    payload: novel
  };
}