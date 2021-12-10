package com.example.gserver.services;


import com.example.gserver.*;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StudentService extends StudentServiceGrpc.StudentServiceImplBase{

    private static final ConcurrentMap<String, Student> entities;
    private static long counter = 2;

    static {
        Student.Address address = Student.Address.newBuilder().setHouseNo("484")
                .setStreet("Bagdat")
                .setCity("Istanbul")
                .setCountry("TR").build();

        Student student= Student.newBuilder().setId(1L).setFirstName("Hakan").setLastName("Sng").setAddress(address).build();


        entities = new ConcurrentHashMap<String, Student>();
        entities.put("1",student);


    }

    @Override
    public void create(Student request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
        request.toBuilder().setId(counter);
        entities.put(String.valueOf(counter), request);
        counter = counter + 1;
        responseObserver
                .onNext(Response
                        .newBuilder()
                        .setCode(201)
                        .setMessage("created successfully")
                        .build());
        responseObserver.onCompleted();
    }


    @Override
    public void list(Empty empty,
                    StreamObserver<StudentList> responseObserver) {
        responseObserver.onNext(StudentList.newBuilder().addAllStudents(entities.values()).build());
        responseObserver.onCompleted();
    }


    @Override
    public void update(Student student,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
        String id = String.valueOf(student.getId());
        if (entities.keySet().contains(id)) {
            entities.put(id, student);
            responseObserver
                    .onNext(Response
                            .newBuilder()
                            .setCode(200)
                            .setMessage("updated successfully")
                            .build());
        } else {
            responseObserver
                    .onNext(Response
                            .newBuilder()
                            .setCode(404)
                            .setMessage("not-available")
                            .build());
        }

        responseObserver.onCompleted();
    }


    @Override
    public void delete(StudentId studentid,
                       StreamObserver<Response> responseObserver) {
        String id = String.valueOf(studentid.getId());
        if (entities.keySet().contains(id)) {
            entities.remove(id);
            responseObserver
                    .onNext(Response
                            .newBuilder()
                            .setCode(200)
                            .setMessage("deleted successfully")
                            .build());
        } else {
            responseObserver
                    .onNext(Response
                            .newBuilder()
                            .setCode(404)
                            .setMessage("not-available")
                            .build());
        }
        responseObserver.onCompleted();
    }


}

