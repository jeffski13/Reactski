var mongoose = require('mongoose');
var autoIncrement = require('mongoose-auto-increment');

var BlogSchema = new mongoose.Schema({
  title: String,
  categories: String,
  content: String,
});

BlogSchema.plugin(autoIncrement.plugin, 'Blog');
module.exports = mongoose.model('Blog', BlogSchema);
