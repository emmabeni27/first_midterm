package algorithms.stack;

public class Balance extends ArrayStack<Object> {
    private final String toCheck;
    private int length;

    public Balance(String toCheck) {
        this.toCheck = toCheck;
        this.length=toCheck.length();
    }

    ArrayStack<Object> toCheckArray = new ArrayStack<>(length);

    public void add() { //hago método pq no es psvm
        for (int i = 0; i < length; i++) {
            if (toCheck.charAt(i) == ('(') || toCheck.charAt(i) == ('{') || toCheck.charAt(i) == ('[')) {
                toCheckArray.push(toCheck.charAt(i));
            }
        }
    }

    public String remove() {
        for (int i = 0; i < length; i++) {
            if (toCheck.charAt(i) == ')' || toCheck.charAt(i) == '}' || toCheck.charAt(i) == ']') {
                if(toCheckArray.isEmpty()){
                    return "It is not balanced"; //por si encuentra uno que cierra sólo. Stack vacío -nada abre- pero encuentro uno que cierra
                }
                char toDelete = (char) toCheckArray.pop(); //debo castearlo para poder compararlo en la línea 25
                if ((toCheck.charAt(i) == ')' && toDelete != '(') || (toCheck.charAt(i) == '}' && toDelete != '{') || (toCheck.charAt(i) == ']' && toDelete != '[')) {
                    return ("It is not balanced");
                }

            }
        }
        if (toCheckArray.isEmpty()) {

            return ("It is balanced");
        }
        else{
            return("It is not balanced"); //(()
        }
    }
}
