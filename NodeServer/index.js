var express = require('express')
var app = express()

app.get('/', function (req, res) {
  res.send('expressing my view of the Hello World!')
})

app.listen(11888, function () {
  console.log('Example app listening on port 11888!')
})
