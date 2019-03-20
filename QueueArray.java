package OOOP3;
// Реалізація черги на массивах
public class QueueArray<E> {
    private int first = 0;
    private int last = 0;
    private int size;
    private E[] queue;
    public QueueArray(int size){
        queue = (E []) new Object[size];
        this.size = size;
    }

    public void add(E elem){
        if(last == queue.length)
            resize(size * 2);
        queue[last] = elem;
        last++;
    }
    public E pop(){
        if (!isEmpty()) {
            E elem = queue[first];
            first++;
            return elem;
        }
        return null;
    }
    public void print(){
        System.out.print("[ ");
        for(E elem: queue){
            if (elem != null)
                System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    public boolean isEmpty(){
       return queue[first] == null;
    }

    private void resize(int new_size){
        E [] new_arr = (E[]) new Object[new_size];
        for (int i=0 ; i < queue.length;i++){
            new_arr[i] = queue[i];
        }
        this.queue = new_arr;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        QueueArray<Integer> q = new QueueArray<>(10);
        System.out.println(q.isEmpty());
        q.add(5);
        q.add(7);
        q.add(8);
        System.out.println(q.isEmpty());
        q.pop();
        q.pop();
        q.pop();
        System.out.println(q.isEmpty());
        q.print();
    }

}


