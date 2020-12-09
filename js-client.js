var UserAPIs = require('./gen-nodejs/UserAPIs');
var ttypes = require('./gen-nodejs/UserAPIs_types');
var thrift = require('thrift');

var transport = thrift.TBufferedTransport;
var protocol = thrift.TBinaryProtocol;

var connection = thrift.createConnection("localhost", 9090, {
  transport: transport,
  protocol: protocol
});

connection.on('error', function (err) {
  console.log(err);
});

var client = thrift.createClient(UserAPIs, connection);


client.ping(function (err, response) {
  console.log('response from server: ', response);
});
