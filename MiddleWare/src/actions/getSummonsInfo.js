export const GET_SUMMON_INFO_ACTION = 'GET_SUMMON_INFO_ACTION';

export default function getSummonsInfo(){

  console.log('jeffski, getting info');

  const summonInfo=[
    {
      name:'Azog',
      title: 'The Defiler',
      description: 'Wrecker of Kingdoms. Hunter of dwarfs.',
      imgName: 'img/azog.jpg'
    },
    {
      name:'Dalek',
      title: 'The Conquerer',
      description: 'EXTERMINATE!',
      imgName: 'img/dalek.png'
    },
    {
      name:'Azog',
      title: 'The Defiler',
      description: 'Wrecker of Kingdoms. Hunter of dwarfs.',
      imgName: 'img/azog.jpg'
    },
    {
      name:'Dalek',
      title: 'The Conquerer',
      description: 'EXTERMINATE!',
      imgName: 'img/dalek.png'
    },
    {
      name:'Azog',
      title: 'The Defiler',
      description: 'Wrecker of Kingdoms. Hunter of dwarfs.',
      imgName: 'img/azog.jpg'
    },
    {
      name:'Dalek',
      title: 'The Conquerer',
      description: 'EXTERMINATE!',
      imgName: 'img/dalek.png'
    }

  ];

  return {
    type: GET_SUMMON_INFO_ACTION,
    payload: summonInfo
  };
}