package algorithms.tree;

import algorithms.queue.LinkedListQueue;
import algorithms.queue.Queue;

import java.util.Iterator;

//resumen de ordenes (gráfico)--> https://www.google.com/url?sa=i&url=https%3A%2F%2Fmedium.com%2F%40ajinkyajawale%2Finorder-preorder-postorder-traversal-of-binary-tree-58326119d8da&psig=AOvVaw2K5vY4lYvve1EbzPMWD7j_&ust=1715483658363000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPijjeLQhIYDFQAAAAAdAAAAABAE
//sólo levelOrder (gráfico)--> https://www.google.com/url?sa=i&url=https%3A%2F%2Fm.youtube.com%2Fwatch%3Fv%3D86g8jAQug04&psig=AOvVaw21ghLwSibIatvSLc4Q8yAi&ust=1715485515376000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCMjnsdfXhIYDFQAAAAAdAAAAABAI

public class BinaryTreeVisitor<E> implements TreeVisitor<E>{



    @Override
    public Iterator<E> inOrder(Node<E, ?> root) {
    Queue<E> keys = new LinkedListQueue<>(); //utilizo LL que ya creé en el tp anterior par aguardar las claves de los nodos del árbol
        inOrder(root, keys);
        return keys.iterator(); //está usando el iterator del tp llqueue
    }
private void inOrder(Node<E, ?> node, Queue<E> keys){ //paso de estructura árbol a llqueue
        if(node==null){
            return;
        }//cuando lo va recorriendo lo va guardando
        inOrder(node.left, keys); //primero chequeo la izquierda del nodo
        keys.enqueue(node.key); //luego el nodo mismo
        inOrder(node.right, keys); // por último la derecha del nodo
    //cuando haya llegado a los extremos no avanza más y los empieza a agregar
}



    @Override
    public Iterator<E> postOrder(Node<E, ?> root) {
        Queue<E> keys =new LinkedListQueue<>();
        postOrder(root, keys);
        return keys.iterator(); //al hacer un return del iterator me permite ir viendo cada elemento
    }

    private void postOrder(Node<E, ?> node, Queue<E> keys){
        if(node==null){
            return; //  QUÉ PASA LLEGADO ESTE PUNTO, CORTA TODO??
        }
        postOrder(node.left, keys);
        postOrder(node.right, keys);
        keys.enqueue(node.key);
    }



    @Override
    public Iterator<E> preOrder(Node<E, ?> root) {
        Queue<E> keys = new LinkedListQueue<>();
        preOrder(root, keys);
        return keys.iterator();
    }

    private void preOrder(Node<E, ?> node, Queue<E> keys){ //función privada porque es auxiliar
// ? representa un tipo desconocido

        if(node==null){
            return; //si el nodo es nulo hace un return void e interrupe el proceso
        }

        keys.enqueue(node.key); //si el nodo no es nulo, agrego la key del nodo a la queue
        preOrder(node.left, keys); //luego hago la misma verificación y proceso con el nodo hijo izquierdo
        preOrder(node.right, keys); // y por último con el nodo hijo derecho
    }




    @Override
    public Iterator<E> levelOrder(Node<E, ?> root) {

        Queue<E> keys = new LinkedListQueue<>();
        Queue<Node<E, ?>> auxtree = new LinkedListQueue<>();
        auxtree.enqueue(root); //"inicializo" la raíz, si tengo la head (root) de LL, tengo copia de la LL entera

        if(root==null){
            return keys.iterator();
        }
//permite la posibilidad de encolar un null y solo después verifica si el nodo raíz es null, lo cual podría ser menos seguro dependiendo de la implementación de la cola
        while(!auxtree.isEmpty()){//voy avanzanzdo por los niveles
            Node<E, ?> node = auxtree.dequeue();
            keys.enqueue(node.key);
            if(node.left!=null){
                auxtree.enqueue(node.left); //mientreas los nodos sean distintos de null, los agrego a la queue de nodos
                // van a ser la próxima root, se van a ir en el dequeue y repetir pasos
            }
            if(node.right!=null){
                auxtree.enqueue(node.right);
            }

        }
        return keys.iterator();
    }
}
