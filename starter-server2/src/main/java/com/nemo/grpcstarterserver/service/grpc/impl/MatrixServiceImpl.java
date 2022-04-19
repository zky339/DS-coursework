package com.nemo.grpcstarterserver.service.grpc.impl;


import com.nemo.grpcstarterserver.MatrixRequest;
import com.nemo.grpcstarterserver.MatrixResponse;
import com.nemo.grpcstarterserver.MatrixServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class MatrixServiceImpl extends MatrixServiceGrpc.MatrixServiceImplBase {
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void multiplyBlock(MatrixRequest request, StreamObserver<MatrixResponse> responseObserver) {
        int C00=request.getA00()*request.getB00()+request.getA01()*request.getB10();
        int C01=request.getA00()*request.getB01()+request.getA01()*request.getB11();
        int C10=request.getA10()*request.getB00()+request.getA11()*request.getB10();
        int C11=request.getA10()*request.getB01()+request.getA11()*request.getB11();

        MatrixResponse response = MatrixResponse.newBuilder().setC00(C00).setC01(C01).setC10(C10).setC11(C11).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void addBlock(MatrixRequest request, StreamObserver<MatrixResponse> responseObserver) {

        int C00=request.getA00()+request.getB00();
        int C01=request.getA01()+request.getB01();
        int C10=request.getA10()+request.getB10();
        int C11=request.getA11()+request.getB11();

        MatrixResponse response = MatrixResponse.newBuilder().setC00(C00).setC01(C01).setC10(C10).setC11(C11).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
