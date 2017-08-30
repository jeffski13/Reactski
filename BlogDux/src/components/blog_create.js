import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';

class BlogCreate extends Component {
  renderTitleField(field){
    return (
      <div>
        <input
          type="text"
          {...field.input} />
      </div>
    );
  }

  render (){
    return (
      <div>
        <div>Zees iss new blog</div>
        <form>
          <Field
            name="title"
            component={this.renderTitleField} />
        </form>
      </div>

    );
  }
}

export default reduxForm({
  form: 'BlogNewForm'
})(BlogCreate);
