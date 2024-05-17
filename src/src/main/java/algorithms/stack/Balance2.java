package algorithms.stack;

public class Balance2 {
    public boolean check(String message){
        int capacity=message.length();
        ArrayStack<Object> toCheckArray = new ArrayStack<>(capacity);
        for(char c:message.toCharArray()){ //lo mismo que tener array de chars
            if(c=='(' || c=='{' || c=='['){ //podría ser esto mismo en función auxiliar
                toCheckArray.push(c);
            }
            else if(c==')' || c==']' || c=='}'){

                if(toCheckArray.isEmpty() || !isMatching((char) toCheckArray.pop(), c)){
                    return false; //chequeo que no haya de cierre de más o que no haga match
                }

            }
        }
        //cuando ya recorrió TODO el string
        return toCheckArray.isEmpty(); //chequeo que no haya de apertura de más
    }
    private boolean isMatching(char open, char close){
        return (open=='('&& close==')') || (open=='{'&& close=='}') || (open=='['&& close==']');
    }
}
