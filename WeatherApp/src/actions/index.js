import ajaxios from 'axios';
const WEZZA_API_KEY='d1348b43416b2b69803e84401416391b';
const WEZZA_URL=`http://api.openweathermap.org/data/2.5/forecast?appid=${WEZZA_API_KEY}`;

export const GET_ZE_WEZZHA =  'GET_ZE_WEZZHA';

//crea una funcion nueva (accion)
export function getDatWeather(shity){

  //nota: la llave de pais (USA) no cambia
  const url = `${WEZZA_URL}&q=${shity},us`;

  //Nota: Necesitas un tipo de accion
  //La Carga Util no es necesario
  return {
    type: GET_ZE_WEZZHA,
    payload: request
  };
}
