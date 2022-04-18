package com.nemo.grpcstarterclient.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileUtils {
    public static ArrayList<ArrayList<Integer>> fileToArray(MultipartFile file) throws IOException {
        ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line = reader.readLine();
        int i;
        int j = 0;
        while (line != null) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] split = line.split(" ");
            for (String a : split) {
                list.add(Integer.valueOf(a));
            }

            listArrayList.add(list);
            j = list.size();
            if (!isPowerOfTwo(j)){
                return null;
            }
            line = reader.readLine();
        }

        i = listArrayList.size();

        if (i != j || !isPowerOfTwo(i)) {
            return null;
        }

        return listArrayList;
    }


    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;

    }

    public static int[][] listToArray(ArrayList<ArrayList<Integer>> a){
        int[][] b = new int[a.size()][a.size()];
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                b[i][j] = a.get(i).get(j);
            }
        }
        return b;
    }
}
