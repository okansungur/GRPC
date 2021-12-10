package com.example.gclient;

import com.example.gserver.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GclientApplication {


        public static void main(String[] args) throws InterruptedException {
       ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9435)
                    .usePlaintext()
                    .build();

            StudentServiceGrpc.StudentServiceBlockingStub blockingStub =
                    StudentServiceGrpc.newBlockingStub(channel);

            Response createResponse = blockingStub.create(
                    Student.newBuilder().setFirstName("Haldun").setLastName("Dormen")
                            .setAddress(Student.Address.newBuilder().setHouseNo("33").setStreet("Uray Caddesi")
                                    .setCity("Mersin")
                                    .setCountry("TR").build())
                            .build());
            System.out.println("created-successfully: \n" + createResponse);

            Response updateResponse = blockingStub.update(
                    Student.newBuilder().setId(1).setFirstName("Tevfik").setLastName("Fikret")
                            .setAddress(Student.Address.newBuilder().setHouseNo("1867").setStreet("Sermin")
                                    .setCity("Izmir")
                                    .setCountry("TR").build())
                            .build());
            System.out.println("updated-successfully : \n" + updateResponse);

                StudentList studentlist = blockingStub.list(com.example.gserver.Empty.newBuilder().build());
            System.out.println("students  are: \n" + studentlist);

            Response deleteResponse = blockingStub.delete(StudentId.newBuilder().setId(1).build());
            System.out.println("deleted-successfully : \n" + deleteResponse);

            channel.shutdown();


        }


}
