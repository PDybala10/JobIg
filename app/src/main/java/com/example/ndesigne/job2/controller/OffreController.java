package com.example.ndesigne.job2.controller;

public class OffreController {


  public static  String cleanString(String chaine){
        String s="";
        int j = 0;
        char arr[]=chaine.toCharArray();
        for(int i=0;i<arr.length;i++){

            if (arr[i] == '<') {
                j = 1;
            }

            if(j == 0) {
                s = s + arr[i];
            }
            if (arr[i] == '>'){
                j = 0;
            }
        }
        return s;
    }

}
