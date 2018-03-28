import React from 'react';

export default class RefPractice extends React.Component{
  render(){
    return(
      <div>
        {/*create property for this class that
        is a reference to thine own anchor*/}
        <a href="#" ref={(aRefParam)=>{
          this.refPracticeAnchorHtml = aRefParam;
        }}>
          Fosucable Anchor (in RefPractice)
        </a>
      </div>
    )
  }
}