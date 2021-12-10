# GRPC
Google Remote Procedure Call 
it is an open-source RPC (Remote Procedure Call) framework that uses RPC to communicate
gRPC uses protobuf instead of JSON or XML messaging format.  and is built on HTTP 2 to overcome  HTTP/1.1 limitations
gRPC services and messages between clients and servers are defined in proto files. Proto files  are not owned by any projects, 
They are seperate files, but projects use them as a contract. In a way similar to the interfaces we use in RMI or EJB.
 
Protobuf scalar types. For more please check google's language guide  [language-guide](https://developers.google.com/protocol-buffers/docs/proto#scalar) 

![scalar types](https://github.com/okansungur/GRPC/blob/main/datatypes.png)


It has Interoperability and streaming proto file into the memory at runtime and uses the in-memory schema to serialize/deserialize the binary message. After code generation, each message is exchanged between the client and remote service.
This results in slower implementation than rest but increases message transmission speed. When we look at the microservice architecture the difference is in terms of milliseconds.
But when we take into account hundreds of requests it will be more meaningful as it will increase the performance of our microservices.

Apart from pros it has a Non-human Readable Format and limited browser support.It is not a replacement of rest api.
It is another alternative  for large scale microservice connections and communications. As there are lots of microservices  communicating  each other. It is a good way of handling with the requests in a short time when compared with the rest api.



syntax = "proto3";

package  com.example;
option java_package = "com.example.gserver";
option java_multiple_files = true;
option java_generic_services = true;

message Student {
  int64 id = 1;
  string firstName = 2;
  string lastName = 3;
  message Address {
    string houseNo = 1;
    string street = 2;
    string city = 3;
    string country = 4;
  }
  Address address = 4;
}

message StudentList {
  repeated  Student students = 1;
}

message StudentId {
  int64 id = 1;
}

message Empty {}

message Response {
  int64 code = 1;
  string message = 2;
}

service StudentService {
  rpc Create(Student) returns (Response);
  rpc List(Empty) returns (StudentList);
  rpc Update(Student) returns (Response);
  rpc Delete(StudentId) returns (Response);
}





The output of our sample grpc application is :
<p align="center">
  <img src="https://github.com/okansungur/GRPC/blob/main/clientresponse.png" />
</p>
