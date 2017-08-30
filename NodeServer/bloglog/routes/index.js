var express = require('express');
var router = express.Router();

var mongoose = require('mongoose');
var Blog = require('../models/Blog.js');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

/* GET /blog listing. */
router.get('/blogs', function(req, res, next) {
  console.log("/blogs get");
  Blog.find(function (err, blogs) {
    if (err){
      console.log("/blogs post to db failed");
      return next(err);
    }
    console.log("/blogs get in  ", blogs);
    res.status(200);
    res.json(blogs);
  });
});

/* POST /blogs */
router.post('/addblog', function(req, res, next) {
  console.log("/addblog post ", req.body);
  Blog.create(req.body, function (err, post) {
    if (err){
      console.log("/addblog post to db failed");
      return next(err);
    }
    console.log("/addblog post to db ", post);
    res.json(post);
  });
});

/* GET /blog by id. */
router.get('/blog/:id', function(req, res, next) {
  console.log("/blogs get id ", req.params.id);
  Blog.findById(req.params.id, function (err, post) {
    if (err){
      return next(err);
    }
    res.json(post);
  });
});

/* GET Userlist page. */
router.get('/bloglistjade', function(req, res) {
    var db = req.db;
    var collection = db.get('usercollection');
    collection.find({},{},function(e,docs){
        res.render('blogsview', {
            "bloglist" : docs
        });
    });
});

/* GET New User page. */
router.get('/newblogjade', function(req, res) {
    res.render('newblog', { title: 'Add New blog' });
});

/* POST to Add User Service */
router.post('/addblogjade', function(req, res) {

    // Set our internal DB variable
    var db = req.db;

    // Get our form values. These rely on the "name" attributes
    var title = req.body.title;
    var categories = req.body.categories;
    var content = req.body.content;

    // Set our collection
    var collection = db.get('usercollection');

    // Submit to the DB
    collection.insert({
        "title" : title,
        "categories" : categories,
        "content" : content
    }, function (err, doc) {
        if (err) {
            // If it failed, return error
            res.send("There was a problem adding the information to the database.");
        }
        else {
            // And forward to success page
            res.redirect("bloglist");
        }
    });
});


module.exports = router;
