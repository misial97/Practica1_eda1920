package material.linear;

public class LinkedQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedQueue(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E front() {
        return this.head.getElement();
    }

    @Override
    public void enqueue(E element) {
        Node newNode = new Node(element, null);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else{
            E element = this.head.getElement();
            this.head = this.head.getNext();
            this.size--;
            return element;
        }
    }
}
