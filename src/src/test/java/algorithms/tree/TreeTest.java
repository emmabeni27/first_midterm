package algorithms.tree;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Test;

import java.util.Iterator;

public class TreeTest<E> {

    public Node<Character, Character> myBinaryTree(){
        final Node<Character, Character> first = new Node<>('A', 'A'); // uso letras para referenciar los nodos como en los ejemplos vistos en clase
        final Node<Character, Character> fourth = new Node<>('D', 'D');
        final Node<Character, Character> third = new Node<>('C', 'C', null, fourth);
        final Node<Character, Character> second= new Node<>('B', 'B', first, third);
        return second;
    }
    @Test
    public void inOrder() {
        Character[] inOrder = {'A', 'B', 'C', 'D'};
        BinaryTreeVisitor<Character> inOrderVisitor = new BinaryTreeVisitor<>();
        Iterator<Character> inOrderIterator = inOrderVisitor.inOrder(myBinaryTree()); //paso de parámetro root y por tanto el árbol entero
        for(int i=0; inOrderIterator.hasNext(); i++){ // no me sirve usar un while porque no tendría la referenci al índice
            assertThat(inOrder[i]).isEqualTo(inOrderIterator.next());
        }
    }
    @Test
    public void postOrder() {
        Character[] postOrder = {'A', 'D', 'C', 'B'}; //misma lógica de testeo pero con el orden correspondiente a postOrder
        BinaryTreeVisitor<Character> postOrderVisitor = new BinaryTreeVisitor<>();
        Iterator<Character> postOrderIterator = postOrderVisitor.postOrder(myBinaryTree());
        for(int i=0; postOrderIterator.hasNext(); i++){
            assertThat(postOrder[i]).isEqualTo(postOrderIterator.next());
        }
    }

    @Test
    public void preOrder() {
        Character[] preOrder = {'B', 'A', 'C', 'D'};
        BinaryTreeVisitor<Character> preOrderVisitor = new BinaryTreeVisitor<>();
        Iterator<Character> preOrderIterator = preOrderVisitor.preOrder(myBinaryTree());
        for(int i=0; preOrderIterator.hasNext(); i++){
            assertThat(preOrder[i]).isEqualTo(preOrderIterator.next());
        }
    }

    @Test
    public void levelOrder() {
        Character[] levelOrder = {'B', 'A', 'C', 'D'};
        BinaryTreeVisitor<Character> levelOrderVisitor = new BinaryTreeVisitor<>();
        Iterator<Character> levelOrderIterator = levelOrderVisitor.levelOrder(myBinaryTree());
        for(int i=0; levelOrderIterator.hasNext(); i++){
            assertThat(levelOrder[i]).isEqualTo(levelOrderIterator.next());
        }
    }
}
