package org.example;

public class Find{

    private int data1;
    private int data2;
    private int data3;

    public Find(int data1, int data2, int data3){
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
    }


        public String equals(){
            if (data1 == data2 && data2 == data3){
                return ("They are equal :)");
        }
            else{
                return ("They are not equal :(");


    }
    }
}