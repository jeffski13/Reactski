import axios from 'axios';

export const GET_BLOGS = 'get_blogs_action';
export const GET_ONE_BLOG = 'get_one_blog_action';
export const CREATE_BLOGS = 'create_blogs_action';
const BLOG_URL_ROOT = 'http://localhost:3000';

export function getDemBlogs(){
  const request = axios.get(`${BLOG_URL_ROOT}/blogs`);
  return{
    type: GET_BLOGS,
    payload: request
  };
}

export function createBlog(values, onCompleteCallback) {
  //make call and then hit callback
  const axyReq = axios.post(`${BLOG_URL_ROOT}/addblog`, values)
    .then(() => onCompleteCallback());

  return {
    type: CREATE_BLOGS,
    payload: axyReq
  }
}

export function getOneBlog(id) {
  const requ = axios.get(`${BLOG_URL_ROOT}/blog/${id}`);

  return {
    type: GET_ONE_BLOG,
    payload: requ
  };
}
