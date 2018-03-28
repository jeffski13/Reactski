import React from 'react';
import PropTypes from 'prop-types';

class RefPracticeBetter extends React.Component{
  render(){
    return(
      <div>
        {/*set the ref equal to what the parent gave you
        The parent gave you a method that will create a property for
        the parent with a reference to the HTML anchor tag
        */}
        <a href="#" ref={this.props.getAnchorRef} >
          Fosucable Anchor (in RefPracticeBetter)
        </a>
      </div>
    )
  }
}

RefPracticeBetter.propTypes = {
  getAnchorRef: PropTypes.func
}

export default RefPracticeBetter;
