package algorithms.stack;

import org.jetbrains.annotations.NotNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E>, Iterable<E> { //diamanates para definir clase / iterador también lleva E, mismo elemento del stack

    private static final int DEFAULT_SIZE =20;
    private int currentCapacity; //inicializar antes
    private int size = 0; //lo inicializo a cero, cantidad guardada al momento
    //array tipo e
    private E[] arraystack; //necesito poder acceder a la referenia desde toda la clase
    private int modifications=0;

    public ArrayStack(){
        arraystack=(E[]) new Object[DEFAULT_SIZE]; //defino capacidad de arrst al que puede acceder toda la clase
        //es lo mismo que this(DEFAULT_CAPACITY)
        currentCapacity= DEFAULT_SIZE;
    }
    public ArrayStack(int initialSize){
        arraystack=(E[]) new Object[initialSize];
        currentCapacity=initialSize;
    }
    private void resize(int newCapacity){
        E[] newarraystack = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {//agregar string al stack//tengo que recorrer el array que ya tengo e ir copiando el contenido en el nuevo array
            newarraystack[i] = arraystack[i]; //asigno los nuevos elementos
        }
        arraystack = newarraystack;//ahora la piso
    }
    @Override //si lo desmarco me dice que en realidad no está haciendo un override pq no está el método en la interfaz
    public void push(@NotNull E element) { //not null para indicar que el método no puede devolver null!

        if (size<currentCapacity){
            arraystack[size] = element;// no casteo pq ya es genérico. última posición--> cantidad de lementos que hay
            size++;
        }
        else{
            resize(currentCapacity*=2); //implementar metodo resize y acá lo llamo
            //con *= paso el 40 y asigno el nuevo valor a current capacity
            arraystack[size] = element;
            size++;
        }
        modifications+=1;

    }
// arreglon del nuevo tamaño, copiar elementos y pisarlos

    @Override //para override no debe recibir parámetros
    public E pop() {

        if (size>0){
            E toDelete=this.arraystack[size-1];// la posición es el tamaño -1 (n-1)
            this.arraystack[size-1]=null;
            size--;
            if(size<=currentCapacity/4){
                resize(currentCapacity/=2);
            }
            modifications+=1;
            System.out.println(toDelete);
            return toDelete;
        }
        else {
            throw new NoSuchElementException("Failure: empty stack");
        }

    }


    @Override
    public boolean isEmpty() {
        return size==0; // cubre las dos posibilidades
    }

    @Override
    public int size() {
        return size; //getter porque es privado, sin this porque pertenece a la clase
    }
    //paréntesis porque estoy instanciando un nuevo iterador, estoy llemando a constructor de clase iterator pero sin pasar parámetros

    public int getCurrentCapacity() {
        return currentCapacity; //getter porque es privado, sin this porque pertenece a la clase
    }
    @Override
    public Iterator<E> iterator() { //devuelve instancia de operator de elemento genérico /este es el método que tengo que reimplementar de Iterable
        return new ArrayStackIterator(modifications); //devuelvo instancia del iterador de mi arraystack
    }
    private class ArrayStackIterator implements Iterator<E>{//hago subclase para implementar los métodos de la clase abstracta iterator
        int currentPosicion = size-1;
        private final int currentModifications;
        //no es necesario un constructor porque usa el de Java (del que hereda)

        public ArrayStackIterator(int modifications) {
            currentModifications = modifications;
        }
        @Override
        public boolean hasNext() { //distinto no pq puedo pasarme
               return currentPosicion >= 0; //no puede haber null intermedio pq es stack, cuidado con lista!!
        }
        @Override
        public E next() {
            if (currentModifications != modifications) throw new ConcurrentModificationException("Modified queue");
            if(hasNext()){
                E currentInformation=arraystack[currentPosicion];
                currentPosicion--;
                return currentInformation;
            }
            else{
                throw new NoSuchElementException("Failure: empty stack");
            }
        }


    }
    public Iterator<E> reversed(){

        return new ArrayStackIteratorR(modifications);
    }
    public class ArrayStackIteratorR implements Iterator<E>{

        int currentPosition=0;
        final int currentModifications;
        public ArrayStackIteratorR(int modifications) {
            currentModifications = modifications;
        }


        @Override
        public boolean hasNext() {
            return arraystack[currentPosition]!=null;
        }

        @Override
        public E next() {
            if(hasNext()){
                E currentInformation=arraystack[currentPosition];
                currentPosition++;
                return currentInformation;
            }
            else{
                throw new NoSuchElementException("Failure: empty stack");
            }
        }
    }
}
//´la clase arraystack implementa las interfaces stack y iterable. Esto quiere decir que hay que overridear los métodos de cada contrato
// Luego de overridear los mpetodos push pop size e isempty de la interfaz stack, hayq ue overridear el método iterator
// de la interfaz iterable. Este método devuelve una instancia de Iterator, que es una clase abstracta, lógicamente porque una lista
//no se itera de la misma forma que un array, por ejemplo. Entonces, hay que crear una clase propia de arraystackque extienda de la clase abstracta Iterator.
// esto quiere decir que hay que overridearsus método: has next y next
