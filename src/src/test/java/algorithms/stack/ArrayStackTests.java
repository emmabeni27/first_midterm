package algorithms.stack;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
//COVERAGE!!!!!

public class ArrayStackTests {
    private static final int DEFAULT_SIZE = 20;

    //ArrayStack parametrizedStack = new ArrayStack(size); //por qeu en este caso no es casteo

    @Test
    public void push() {
        ArrayStack notParametrizedStack = new ArrayStack<>();
        ArrayStack ParametrizedStack= new ArrayStack<>(DEFAULT_SIZE);

        ParametrizedStack.push("Hello World!");
    notParametrizedStack.push("Goodbye World!");
    ParametrizedStack.push(2);
    notParametrizedStack.push(3);
    assertThat(ParametrizedStack.size()).isEqualTo(2);
    assertThat(notParametrizedStack.size()).isEqualTo(2);
    }
    @Test
    public void pop(){
        ArrayStack notParametrizedStack = new ArrayStack<>();
        ArrayStack ParametrizedStack= new ArrayStack<>(DEFAULT_SIZE);

    notParametrizedStack.push("Descalzos por el Parque");
    notParametrizedStack.push("Perdidos en Tokyo");
    //si agrego pop acá el siguiente en realidad devuelve "Descalzos por el Parque"
    assertThat(notParametrizedStack.pop()).isEqualTo("Perdidos en Tokyo"); //no está en violeta pq no es atributo sino variabel
    }
    @Test

    public void underflow() {
        ArrayStack notParametrizedStack = new ArrayStack<>();
        ArrayStack ParametrizedStack= new ArrayStack<>(0);
    assertThrows(NoSuchElementException.class,()->{ParametrizedStack.pop();});
    }
    @Test
    public void isEmpty(){
        ArrayStack notParametrizedStack = new ArrayStack<>();
        ArrayStack ParametrizedStack= new ArrayStack<>(DEFAULT_SIZE);
    assertThat(notParametrizedStack.isEmpty()).isEqualTo(true);
    assertThat(ParametrizedStack.isEmpty()).isEqualTo(true);

    notParametrizedStack.push("Hello World");
    ParametrizedStack.push("Goodbye World");
    assertThat(notParametrizedStack.isEmpty()).isEqualTo(false);
    assertThat(ParametrizedStack.isEmpty()).isEqualTo(false);
    }
    @Test
    public void size(){
        ArrayStack notParametrizedStack = new ArrayStack<>();
        ArrayStack ParametrizedStack= new ArrayStack<>(DEFAULT_SIZE);
        assertThat(notParametrizedStack.size()).isEqualTo(0);
        notParametrizedStack.push("Titanic");
        notParametrizedStack.push("Nuestros años felices");
        assertThat(notParametrizedStack.size()).isEqualTo(2);
        notParametrizedStack.pop();
        assertThat(notParametrizedStack.size()).isEqualTo(1);
    }
    @Test
    public void resize(){
        ArrayStack ParametrizedStack= new ArrayStack<>(DEFAULT_SIZE);
        for(int i=0; i<DEFAULT_SIZE; i++){
            ParametrizedStack.push("element"+i);
        }
        assertThat(ParametrizedStack.size()).isEqualTo(DEFAULT_SIZE);//paréntesis en size pq es método
        ParametrizedStack.push("element 21");
        assertThat(ParametrizedStack.getCurrentCapacity()).isEqualTo(DEFAULT_SIZE*2);
        int elementsToPop = ParametrizedStack.size()-ParametrizedStack.getCurrentCapacity()/4;
        for(int i=1; i<elementsToPop; i++){
            ParametrizedStack.pop();
        }
        assertThat(ParametrizedStack.getCurrentCapacity()).isEqualTo(DEFAULT_SIZE*2);
        ParametrizedStack.pop();
        assertThat(ParametrizedStack.getCurrentCapacity()).isEqualTo(DEFAULT_SIZE); //20/2 para 40/2 sería defs*=2

    }

}

