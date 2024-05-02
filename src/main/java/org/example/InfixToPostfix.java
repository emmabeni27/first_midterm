package org.example;

import java.util.Stack;

/*
 Write a filter InfixToPostfix that converts an arithmetic expression from infix to postfix.
*/
public class InfixToPostfix {


    public Stack inttoPost(String calculus){
        int length=calculus.length();
        Stack<Object> myStack =new Stack<>(); //no me deja usar ArrayStack
    for(char number:calculus.toCharArray()){
        if(checkChar(number)){
            myStack.push(number);
        }
    }
    return myStack;
    }

    private boolean checkChar(char c){
       if(c=='(' || c==')' || c=='{' || c=='}' || c=='[' || c==']'){ //dejando de lado la posibilidad de recibir letras
           return false;
       }
       else{
           return true;
       }
    }
}
