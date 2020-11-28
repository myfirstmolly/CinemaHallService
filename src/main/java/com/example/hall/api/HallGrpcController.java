package com.example.hall.api;

import com.example.hall.*;
import com.example.hall.model.Hall;
import com.example.hall.service.HallsService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@GRpcService
public class HallGrpcController extends HallServiceGrpc.HallServiceImplBase {

    @Autowired
    private HallsService hallsService;

    @Override
    public void all(AllHallRequest request, StreamObserver<AllHallsResponse> responseObserver) {
        List<Hall> films = hallsService.getAll();
        List<HallResponse> convertedFilms = films.stream().
                map(Hall::toHallResponse).
                collect(Collectors.toList());
        AllHallsResponse response = AllHallsResponse.newBuilder().
                addAllHalls(convertedFilms).
                build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void add(HallRequest request, StreamObserver<HallResponse> responseObserver) {
        Hall hall = hallsService.addHall(Hall.fromHallRequest(request));
        responseObserver.onNext(hall.toHallResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void byId(HallByIdRequest request, StreamObserver<HallResponse> responseObserver) {
        Hall hall = hallsService.getById(UUID.fromString(request.getId()));
        responseObserver.onNext(hall.toHallResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(HallByIdRequest request, StreamObserver<DeleteHallResponse> responseObserver) {
        hallsService.deleteHallById(UUID.fromString(request.getId()));
        responseObserver.onNext(DeleteHallResponse.newBuilder().build());
        responseObserver.onCompleted();
    }
}
