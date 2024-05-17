package algorithms.queue;

import algorithms.stack.ArrayStack;
import org.jetbrains.annotations.NotNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>, Iterable<E> {

    private E[] arrayqueue;
    private static final int DEFAULT_SIZE = 20;
    private int currentCapacity; //cuantos espacios (libres+ocupados)
    private int size = 0; //cuantos espacios teine ocuapados de momento
    private int tail = 0;
    public int head = 0;
    public int modifications = 0;

    //agregar módulo cuando uso head como índice
    public ArrayQueue() { //constructor parametrizado
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int initialSize) { //constructor no parametrizado (con imput)
        arrayqueue = (E[]) new Object[initialSize];
        currentCapacity = initialSize;
    }

    public void resize(int newCapacity) {
        E[] newarrayqueue = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {//agregar string al stack//tengo que recorrer el array que ya tengo e ir copiando el contenido en el nuevo array
            //¡¡¡¡en el for tenía que sacar el =!!!!
            newarrayqueue[i] = arrayqueue[(head + i) % currentCapacity]; //asigno los nuevos elementos
        }//para evitar nulls
        currentCapacity = newCapacity;
        arrayqueue = newarrayqueue;//ahora la piso
        head = 0; // una vez que ya hice el resize reinicio el head a 0
        tail = size;// tail debe ser igual a size, porque cuando tenga 1 elemento en la posición 0, tail va a estar en la posición siguiente, en la 1. Entonces--> size=tail
    }

    @Override
    public void enqueue(E element) {
        if (size >= currentCapacity) {
            resize(currentCapacity * 2); //multiplicar por dos y pasar como parámetro, pero no reasignar la current capacity todavía
            //pq la vos a usar para el módulo (la current capacity "vieja") y la puedo duplicar después
        }
        //¡¡¡¡¡¡puedo reducir el if y sacar las funciones que siguen pq se repiten en ambas!!!
        arrayqueue[tail] = element;
        size++;
        tail++;
        modifications += 1;
    }

    public int getCurrentCapacity() {
        return currentCapacity; //getter porque es privado, sin this porque pertenece a la clase
    }

    @NotNull
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }

        final E toDelete = arrayqueue[head % currentCapacity];
        arrayqueue[head++ % currentCapacity] = null;
        size--;

        if (size <= currentCapacity / 4) {
            resize(currentCapacity / 2);

        }
        modifications += 1;
        return toDelete;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator(modifications);
    }

    private class ArrayQueueIterator implements Iterator<E> {
        private final int currentModifications;//hago subclase para implementar los métodos de la clase abstracta iterator
        private int currentPosicion = head; //lo detecta por ser clase interna de arrayqueue

        public ArrayQueueIterator(int modifications) {
            currentModifications = modifications;
        }
        //no es necesario un constructor porque usa el de Java (del que hereda)

        @Override
        public boolean hasNext() {
            return currentPosicion != tail;

        }

        @Override
        public E next() {
            if (currentModifications != modifications) throw new ConcurrentModificationException("Modified queue");
            if (!hasNext()) throw new NoSuchElementException("Failure: empty stack");

            E currentInformation = arrayqueue[currentPosicion];
            currentPosicion++;
            return currentInformation;
        }
    }
    public Iterator<E> reversed(){
        return new ArrayQueueIteratorR(modifications); //primero implemento el método y después implemento inner class
    }
    public class ArrayQueueIteratorR implements Iterator<E>{
        int currentPosition=size-1;
        final int currentModifications;
        public ArrayQueueIteratorR(int modifications) {currentModifications=modifications;}
        @Override
        public boolean hasNext() {
            return currentPosition >= 0;
        }

        @Override
        public E next() {
            if(hasNext()){
                E currentInformation=arrayqueue[currentPosition];
                currentPosition--;
                return currentInformation;
            }
            else{
                throw new NoSuchElementException("Failure: empty queue");
            }
        }
    }
}
