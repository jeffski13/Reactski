import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { createBlog } from '../actions'

class BlogCreate extends Component {

  //tells what Field element will look like
  renderField(field){
    const { meta : { touched, error } } = field;
    const className = `form-group ${touched && error ? 'has-danger' : ''}`

    return (
      <div className={className} >
        <label>{field.fieldLabel}</label>
        <input
          type="text"
          className="form-control"
          {...field.input} />
        <div className="text-help" >
          {touched ? error : ''}
        </div>
      </div>
    );
    //{...field.input} magically hooks in reduxForm
    // not so much magic: all parts of field.input properties are now
    // attributes of the input element
  }

  onSubmit(values){
    console.log("onsubmission values:", values);
    this.props.createBlog(values);
  }

  //Field tag takes care of all of the redux state stuff and callbacks
  //NOTE: field element has no concept of HOW it should look

  //component attribute says what field will look like
  //  aka, function that returns jsx
  render (){

    //redux form magic kind of?
    //when we hit submit, it validates, and then hands the onSubmission call to handleSubmission
    const { handleSubmit } = this.props;

    return (
      <div>
        <div>Zees iss new blog</div>
        <form onSubmit={handleSubmit(this.onSubmit.bind(this))} >
          <Field
            name="title"
            fieldLabel="Blog Title"
            component={this.renderField} />
            <Field
              name="categories"
              fieldLabel="Scategories"
              component={this.renderField} />
            <Field
              name="content"
              fieldLabel="Ze Content"
              component={this.renderField} />
            <button type="submit" className="btn btn-primary">Submission</button>
            <Link to="/" className="btn btn-danger">See ya!</Link>
        </form>
      </div>

    );
  }
}

function validateIt(values){
  const errs = {};

  //validateIt!
  if(!values.blogTitle){
    //NOTE: errs property must have the same name as the "name"
    // attribute for the Field
    errs.blogTitle="Please sir, I want a title";
  }
  if(!values.categories){
    errs.categories="Please sir, I want some cats";
  }
  if(!values.content){
    errs.content="Please sir, I want some content";
  }

  //if errs is empty, form is cool
  // but if errs has stuff, form is considered invalid, and we are not amused
  return errs;
}

export default reduxForm({
  validate: validateIt,
  form: 'BlogNewForm'
})(
  connect(null, {createBlog})(BlogCreate)
);
