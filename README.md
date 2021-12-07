# GRPC
Google Remote Procedure Call 
it is an open-source RPC (Remote Procedure Call) framework that uses RPC to communicate
gRPC uses protobuf instead of JSON or XML messaging format.  and is built on HTTP 2 to overcome  HTTP/1.1 limitations
gRPC services and messages between clients and servers are defined in proto files.
 
Protobuf scalar types. For more please check google's language guide  [language-guide](https://developers.google.com/protocol-buffers/docs/proto#scalar) 

![scalar types](https://github.com/okansungur/GRPC/blob/main/datatypes.png)


It has Interoperability and streaming proto file into the memory at runtime and uses the in-memory schema to serialize/deserialize the binary message. After code generation, each message is exchanged between the client and remote service.
This results in slower implementation than rest but increases message transmission speed by ten times. gRPC is therefore used for systems that need to communicate often with other parts of the network.
 Apart from pros it has a Non-human Readable Format and limited browser support.It is not a replacement of rest api.
 It is another alternative  for large scale microservice connections and communications. As there are lots of microservices  communicating  each other. It is a good way of handling with the requests in a short time when compared with the rest api.


The output of our sample grpc application is :
<p align="center">
  <img src="https://github.com/okansungur/GRPC/blob/main/clientresponse.png" />
</p>
