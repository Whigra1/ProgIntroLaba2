package laba2;
import com.MyStack;

import java.util.EmptyStackException;

//Реалізація стеку на массиві
public class StackArray<E> {
    private int top = -1;
    private E [] arr;
    private int size;

    public StackArray(int size){
        this.size = size;
        this.arr = (E[]) new Object[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(E element) {
        if (this.isFull())
            resize(this.size*2);
        top++;
        this.arr[top] = element;


    }
    public E pop() {
        if(!isEmpty()) {
            E elem = arr[top];
            top--;
            return elem;
        }
        return null;
    }

    public E peek() {
        if (!this.isEmpty()) {
            return arr[top];
        }
        else{
            return null;
        }
    }

    public int getSize(){
        return size;
    }
    private void resize(int new_size){
        this.size = new_size;
        E [] temp = (E[]) new Object[new_size];
        for(int i = 0; i < this.arr.length;i++){
            temp[i] = this.arr[i];
        }
        this.arr = temp;
    }
    public void clear(){top = -1;}

}
