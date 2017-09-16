import React, { Component } from 'react';
import { connect } from 'react-redux';
import { getDemBlogs } from '../actions';
import { Link } from 'react-router-dom';
import _ from 'lodash';
class BlogIndex extends Component {

  componentDidMount() {
    this.props.getDemBlogs();
  }

  renderBlogs(){
    console.log(this.props.blogs);
    return _.map(this.props.blogs, eachblog => {
      return (
        <li key={eachblog._id}>
          <Link to={`/blogs/${eachblog._id}`}>{ eachblog.title }</Link>
        </li>
      );
    });
  }

  render(){
    console.log("jeffski Blogindex: ", this.props.blogs);
    return (
      <div>
        <div className="text-xs-right">
          <Link className="btn btn-primary" to="/blogs/create" >Create Blog</Link>
        </div>
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
