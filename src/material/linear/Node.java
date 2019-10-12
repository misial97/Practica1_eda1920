package material.linear;

public class Node<E> {
    private E element;
    private Node next;

    public Node(E element, Node next){
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node){
        this.next = node;
    }
}
