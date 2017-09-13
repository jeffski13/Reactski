import axios from 'axios';

export const GET_BLOGS = 'get_blogs_action';
export const CREATE_BLOGS = 'create_blogs_action';
const BLOG_URL_ROOT = 'http://localhost:3000';

export function getDemBlogs(){
  const request = axios.get(`${BLOG_URL_ROOT}/blogs`);
  return{
    type: GET_BLOGS,
    payload: request

  };
}

export function createBlog(values) {
  const axyReq = axios.post(`${BLOG_URL_ROOT}/addblog`, values);

  return {
    type: CREATE_BLOGS,
    payload: axyReq
  }
}