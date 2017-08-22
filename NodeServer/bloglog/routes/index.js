var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

/* GET Hello World page. */
router.get('/howdyworlduri', function(req, res) {
    res.render('howdyworld', { title: 'Howdy, World!' });
});


/* GET Userlist page. */
router.get('/bloglist', function(req, res) {
    var db = req.db;
    var collection = db.get('blogscollection');
    collection.find({},{},function(e,docs){
        res.send(docs);
    });
});

/* GET Userlist page. */
router.get('/blog', function(req, res) {
    var id = req.body.id;

    var db = req.db;
    var collection = db.get('blogscollection');

    collection.find({},{},function(e,docs){
        res.send(docs);
    });
});

/* POST to Add User Service */
router.post('/addblog', function(req, res) {

    // Set our internal DB variable
    var db = req.db;

    console.log(req.body);

    // Get our form values. These rely on the "name" attributes
    var title = req.body.title;
    var categories = req.body.categories;
    var content = req.body.content;

    // Set our collection
    var collection = db.get('blogscollection');

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
            res.send("Success!");
        }
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
