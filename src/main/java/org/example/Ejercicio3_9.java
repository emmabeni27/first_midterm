package org.example;

import org.junit.Test;

import java.util.Stack;

public class Ejercicio3_9 {
    @Test
    public void Ejercicio3_9(){
        String input ="1+2)*3-4)*5-6)))";
        String result ="";
        String a="";
        String b="";
        String c="";

        Stack<String> stackNumber =new Stack<>();
        Stack<Character> stackSymbol = new Stack<>();

        for (int i=0; i<input.length(); i++){
            switch(input.charAt(i)){
                case '+':
                case '-':
                case '*':
                case '/':
            stackSymbol.push(input.charAt(i));
            break;
                case ')':
                    a=stackNumber.pop();
                    b=stackSymbol.pop().toString();
                    c=stackNumber.pop();
                    stackNumber.push("("+c+b+a+")");
                    break;
                default:
                    stackNumber.push(input.charAt(i)+"");
                    break;
            }
        }
        System.out.println(stackNumber.pop());
    }
}
