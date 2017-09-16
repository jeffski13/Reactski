import React, { Component } from 'react';
import { connect } from 'react-redux';
import { getOneBlog } from '../actions';
import { Link } from 'react-router-dom';
class BlogDetail extends Component {
  //called at the start
  componentDidMount(){
    if(!this.props.theOneBlog){
      //gets the id from our url (/blogs/:blogId)
      const id =  this.props.match.params.blogId;
      this.props.getOneBlog(id);
    }
  }

  render(){
    const { theOneBlog } = this.props;

    if(!theOneBlog){
      return (
        <div>LOADING...</div>
      );
    }

    return (
      <div>
        <h2>Blog Details</h2>
        <div><strong>Title: </strong>{theOneBlog.title}</div>
        <div><strong>Categories: </strong>{theOneBlog.categories}</div>
        <div><strong>Content : </strong>{theOneBlog.content}</div>

        <Link className="btn btn-primary" to="/">Blogs Home</Link>
      </div>
    );
  }

}

//ownProps is the props object for this BlogDetail component
function mapStateToProps({ blogs }, ownProps){
  return { theOneBlog: blogs[ownProps.match.params.blogId] };
}

export default connect(mapStateToProps, { getOneBlog })(BlogDetail);
