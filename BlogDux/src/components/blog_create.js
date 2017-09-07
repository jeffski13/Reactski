import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';

class BlogCreate extends Component {

  renderField(field){
    return (
      <div className="form-group" >
        <input
          type="text"
          className="form-control"
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
            component={this.renderField} />
          <Field
            name="categories"
            component={this.renderField} />
          </form
        </form>
      </div>

    );
  }
}

export default reduxForm({
  form: 'BlogNewForm'
})(BlogCreate);
