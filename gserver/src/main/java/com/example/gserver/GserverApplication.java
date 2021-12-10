package com.example.gserver;




import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import com.example.gserver.services.StudentService;
import java.util.List;


public class GserverApplication {
    static final  int portNumber=9435;
    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(portNumber)
                    .addService(new StudentService())
                    .build();
            System.out.println("gRPC server started ");
            server.start();
            System.out.println("port : " +portNumber);
            System.out.println("available-services are:   ");
            List<ServerServiceDefinition> definitions=server.getServices();

            for(int i=0;i<definitions.size();i++){
                System.out.println("service-name : " +definitions.get(0).getServiceDescriptor().getName());

            }

           server.awaitTermination();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }



}
