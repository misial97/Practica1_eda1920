package material.linear;


public class ArrayQueue<E> implements Queue<E> {

    private Object[] queue;
    private int top;
    private int size;

    public ArrayQueue(){
        this.queue = new Object[100];
        this.top = -1;
        this.size = 0;
    }

    public ArrayQueue(int capacidad){
        this.queue = new Object[capacidad];
        this.top = -1;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public E front() {
        return (E) this.queue[top];
    }

    @Override
    public void enqueue(E element) {
        int sizeQueue = this.size;
        if(isEmpty()) {
            this.queue[this.size] = element;
            this.top++;
        }else if(this.queue.length == sizeQueue+1){//si esta lleno
             resize();
             this.queue[this.size] = element;
        }else{
            this.queue[this.size] = element;
        }
        this.size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else{
            E element = (E) this.queue[top];
            this.top++;
            this.size--;
            return element;
        }
    }

    private void resize(){
        Object[] newQueue = new Object[this.size*2];
        int i = 0;
        for(Object e : this.queue){
            newQueue[i] = e;
            i++;
        }
        this.queue = newQueue;
        this.top = 0;
    }

}
