package algorithms.stack;

public class MainStack {
    public static void main(String[] args) {
        ArrayStack<Integer> myArray= new ArrayStack<>();
        myArray.push(4);
        myArray.pop();
        myArray.push(6);
        myArray.pop();
        myArray.push(2);
        myArray.push(3);
        myArray.push(5);
        myArray.push(7);
        myArray.push(8);
        for(int i=0; i<5; i++){
            myArray.pop();
        }
        myArray.push(0);
        myArray.push(9);
        for(int i=0; i<2; i++){
            myArray.pop();
        }
        myArray.push(1);
        myArray.pop();
    }
}
/*
a. 4 3 2 1 0 9 8 7 6 5
b. 4 6 8 7 5 3 2 9 0 1
c. 2 5 6 7 4 8 9 3 1 0
d. 4 3 2 1 0 5 6 7 8 9
e. 1 2 3 4 5 6 9 8 7 0
f. 0 4 6 5 3 8 1 7 2 9
g. 1 4 7 9 8 6 5 3 0 2
h. 2 1 4 3 6 5 8 7 9 0
 */