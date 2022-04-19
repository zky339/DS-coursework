package com.nemo.grpcstarterclient.controller;


import com.nemo.grpcstarterclient.service.FileUtils;
import com.nemo.grpcstarterserver.MatrixRequest;
import com.nemo.grpcstarterserver.MatrixResponse;
import com.nemo.grpcstarterserver.MatrixServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Nemo
 * @version 1.0
 * @date 2020/4/15
 */
@RestController
@RequestMapping("")
public class MatrixController {
    static Long footprint = 2L;


    @GrpcClient("server-service")
    private MatrixServiceGrpc.MatrixServiceBlockingStub stub;
    @GrpcClient("server-service1")
    private MatrixServiceGrpc.MatrixServiceBlockingStub stub1;

//    private MatrixServiceGrpc.MatrixServiceBlockingStub stub2;
//
//    private MatrixServiceGrpc.MatrixServiceBlockingStub stub3;
//
//    private MatrixServiceGrpc.MatrixServiceBlockingStub stub4;
//
//    private MatrixServiceGrpc.MatrixServiceBlockingStub stub5;
//
//    private MatrixServiceGrpc.MatrixServiceBlockingStub stub6;
//
//    private MatrixServiceGrpc.MatrixServiceBlockingStub stub7;



    @PostMapping("/multiple")
    public Object addM(@RequestParam("file")MultipartFile[] files,@RequestParam("deadline")int deadline) throws IOException {
        ArrayList<ArrayList<Integer>> a = FileUtils.fileToArray(files[0]);
        ArrayList<ArrayList<Integer>> b = FileUtils.fileToArray(files[1]);
        if (a == null || b == null || a.size() != b.size()){
            return "ERROR";
        }

        int[][] c = FileUtils.listToArray(a);
        int[][] d = FileUtils.listToArray(b);

        int flag = 0;
        int len = a.size();
        int numberBlock = 1;
        for (int i = 0; i < a.size(); i++) {
            if ((len = len/2) > 0){
                flag += 1;
            }else {
                break;
            }
        }

        for (int i = 0; i < flag; i++) {
            numberBlock = numberBlock * 8;
        }

        int numberServer = Math.toIntExact((footprint * numberBlock) / deadline);



        return grpcMatrixMultiply(c,d,stub);
    }


    public int[][] addMatrix(int[][] a, int[][] b){
        MatrixRequest request = MatrixRequest.newBuilder()
                .setA00(a[0][0])
                .setA01(a[0][1])
                .setA10(a[1][0])
                .setA11(a[1][1])
                .setB00(b[0][0])
                .setB01(b[0][1])
                .setB10(b[1][0])
                .setB11(b[1][1]).build();

        MatrixResponse A3M1 = stub1.addBlock(request);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(A3M1.getC00());
        list1.add(A3M1.getC01());
        list2.add(A3M1.getC10());
        list2.add(A3M1.getC11());

        arrayLists.add(list1);
        arrayLists.add(list2);
        int[][] ints = FileUtils.listToArray(arrayLists);

        return ints;
    }

    public int[][] addM(int[][] a, int[][] b){
        int[][] c = new int[a.length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    public int[][] multipleMatrix(int[][] a, int[][] b ,MatrixServiceGrpc.MatrixServiceBlockingStub canStub){
        Long time1 = System.currentTimeMillis();
        MatrixRequest request = MatrixRequest.newBuilder()
                .setA00(a[0][0])
                .setA01(a[0][1])
                .setA10(a[1][0])
                .setA11(a[1][1])
                .setB00(b[0][0])
                .setB01(b[0][1])
                .setB10(b[1][0])
                .setB11(b[1][1]).build();

        MatrixResponse A3M1 = canStub.multiplyBlock(request);
        Long time2 = System.currentTimeMillis();



        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(A3M1.getC00());
        list1.add(A3M1.getC01());
        list2.add(A3M1.getC10());
        list2.add(A3M1.getC11());

        arrayLists.add(list1);
        arrayLists.add(list2);
        int[][] ints = FileUtils.listToArray(arrayLists);

        return ints;
    }

    public void copyToMatrix(int[][] a,int start1,int start2,int[][] b){
        int len = b.length;
        for (int i = start1; i < start1 + len; i++) {
            for (int j = start2; j < start2 + len; j++) {
                b[i-start1][j-start2] = a[i][j];
            }
        }
    }

    public void copyFromMatrix(int[][] a,int start1,int start2,int[][] b) {
        int len = b.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                a[start1 + i][start2 + j] = b[i][j];
            }
        }
    }

    public int[][] grpcMatrixMultiply(int[][] a ,int[][] b,MatrixServiceGrpc.MatrixServiceBlockingStub canStub){
        int len = a.length;
        int[][] c = new int[len][len];
        if (len == 2){
            return multipleMatrix(a,b,canStub);
        }else {
            int[][] A11,A12,A21,A22;
            int[][] B11,B12,B21,B22;
            int[][] C11,C12,C21,C22;

            A11 = new int[len/2][len/2];A12 = new int[len/2][len/2];A21 = new int[len/2][len/2];A22 = new int[len/2][len/2];
            copyToMatrix(a, 0, 0, A11);
            copyToMatrix(a, 0, len/2,  A12);
            copyToMatrix(a, len/2, 0,  A21);
            copyToMatrix(a, len/2, len/2, A22);

            B11 = new int[len/2][len/2];B12 = new int[len/2][len/2];B21 = new int[len/2][len/2];B22 = new int[len/2][len/2];
            copyToMatrix(b, 0, 0, B11);
            copyToMatrix(b, 0, len/2, B12);
            copyToMatrix(b, len/2, 0, B21);
            copyToMatrix(b, len/2, len/2, B22);

            C11 = new int[len/2][len/2];C12 = new int[len/2][len/2];C21 = new int[len/2][len/2];C22 = new int[len/2][len/2];
            C11 = addM(grpcMatrixMultiply(A11, B11,stub), grpcMatrixMultiply(A12, B21,stub));
            C12 = addM(grpcMatrixMultiply(A11, B12,stub), grpcMatrixMultiply(A12, B22,stub));
            C21 = addM(grpcMatrixMultiply(A21, B11,stub), grpcMatrixMultiply(A22, B21,stub));
            C22 = addM(grpcMatrixMultiply(A21, B12,stub), grpcMatrixMultiply(A22, B22,stub));
            copyFromMatrix(c, 0, 0, C11);
            copyFromMatrix(c, 0, len/2, C12);
            copyFromMatrix(c, len/2, 0, C21);
            copyFromMatrix(c, len/2, len/2, C22);

        }

        return c;
    }

}
