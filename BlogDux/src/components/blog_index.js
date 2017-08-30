import React, { Component } from 'react';
import { connect } from 'react-redux';
import { getDemBlogs } from '../actions';
import _ from 'lodash';
class BlogIndex extends Component {

  componentDidMount() {
    this.props.getDemBlogs();
  }

  renderBlogs(){
    _.map(this.props.blogs, blog => {
      return (
        <li key={blog._id}>{ blog.title }</li>
      );
    });
  }

  render(){
    console.log("jeffski Blogindex: ", this.props.blogs);
    return (
      <div>
        <h2>Blog it up</h2>
        <ul>
            {this.renderBlogs()}
        </ul>
    </div>
    );
  }
}

function mapStateToProps(state) {
  return {blogs: state.blogs};
}

export default connect(mapStateToProps, { getDemBlogs })(BlogIndex);
