package org.example;

import java.util.Stack;

public class LIFO {
    String input = "it was - the best - of times - - - it was - the - -";
    String[] words=input.split(" "); //[] porque es un arreglo, un array compuesto por strings
    Stack<String> myStack = new Stack<>();

    public LIFO(){

    }

    public void printer(){
        for(String word : words){
            if(!word.equals("-")){
                myStack.push(word);
            }
            else{
                System.out.println(myStack.pop());
            }
        }
    }

}
