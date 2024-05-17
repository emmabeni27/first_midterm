package algorithms.tree;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;

// si usamos árboles, la estrucutra es recursiva

public class BinarySearchTree<K,V> implements TreeMap<K,V>{

    private Node<K,V> root;
    private final Comparator<K> comparator; //creo comparador para el objeto que estoy comparando no es necesario que sea comparable o que implemente la forma de comparación predefinida
    int size=0;
    private final BinaryTreeVisitor<K> visitor;

    public BinarySearchTree(Comparator<K> comparator){
        this.comparator=comparator; //siempre que podemos codear en contra de una interfaz nos conviene
        visitor= new BinaryTreeVisitor<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(@NotNull K key) {
        return get(key)!=null;
    }

    @Override
    public V get(@NotNull K key) {
        Node<K,V> result = find(root, key);
        return result!=null? result.value:null;

        /*if (result!=null) return result.value;
        else return null;
        el nuevo sólo sirve para definir valor, asignar varible
         */
    }

    private Node<K,V> find(Node<K,V> node, K key){
        if(node==null) return node; // puedo omitir llaves
        int cmp = comparator.compare(key, node.key);
        if (cmp<0) return find(node.left,key);
        else if (cmp>0) return find(node.right, key);
        else return node;
    }

    @Override
    public void put(@NotNull K key, V value) {
    root=put(root, key, value);
//otra opción es hacerlo con un while acá
        // todo lo iterativo puede ser recursivo y vicecersa
    }

    private Node<K,V> put(Node<K,V> node, K key, V value) {
        if(node==null){
            size++;
            return new Node<K,V>(key,value);
        }
        else{
            int cmp= comparator.compare(key, node.key);
            if (cmp<0){
                node.left= put(node.left, key, value);
            }
            else if (cmp>0){
                node.right = put(node.right, key, value);
            }
            else{
                node.value=value;
            }
            return node;
        }
    }

    @Override
    public void remove(@NotNull K key) {
        root= remove(root, key);

        }

    private Node<K,V> remove(Node<K,V> node, K key) {
        if (node==null) return null;
        int cmp =comparator.compare(key, node.key);
        if(cmp<0){
            node.left =remove(node.left, key);
            return node;
        }
        else if (cmp>0){
            node.right= remove(node.right, key);
            return node;
        }
        else{
            if(node.left==null) return node.right;
            else if(node.right==null) return node.left;
            else{
            Node<K,V> next=first(node.right);
            node.value= next.value;
            node.key=key;
            node.right= remove(node.right, key);
            size--;

            return node;
            }
        }

    }

    private Node<K, V> first(Node<K,V> node) {
        Node<K,V> aux = node;
    while(aux.left!=null){
        aux = aux.left;
    }

    node.key=aux.key;
    aux.key=null;
    node.value= aux.value;
    aux.value=null;
    return node;
    // una vez copiados key y value en la posición de interés, elimino el nodo

    }
//SACAR LA V

    @Override
    public void clear() {
    root=null;

    }

    @Override
    public Iterator<K> inOrder() {
        return visitor.inOrder(root);
    }

    @Override
    public Iterator<K> postOrder() {
        return visitor.postOrder(root);
    }

    @Override
    public Iterator<K> preOrder() {
        return visitor.preOrder(root);
    }

    @Override
    public Iterator<K> levelOrder() {
        return visitor.levelOrder(root);
    }

    @Override
    public void removeMin() {
        remove(min());
    }

    @Override
    public void removeMax() {
        remove(max());
    }

    @Override
    public K min() {
        return first(root).key;
    }

    @Override
    public K max() {
        Node<K, V> aux = root; // CREO QUE ESTE TIPADO ESTA MAL!!
        while(aux.right!=null){
            aux=aux.right;
        }
        return aux.key;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }
}
