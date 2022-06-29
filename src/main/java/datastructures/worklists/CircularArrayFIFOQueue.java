package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FixedSizeFIFOWorkList;

import java.util.NoSuchElementException;


/**
 * See cse332/interfaces/worklists/FixedSizeFIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
    private E[] arr;
    private int size_of_arr, val_of_arr;
    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);

        this.arr = (E[]) new Comparable[capacity];
        this.size_of_arr =0;
        this.val_of_arr =0;


        //throw new NotYetImplementedException();
    }

    @Override
    public void add(E work) {
        if(this.isFull()){
            throw new IllegalStateException();
        }
        else {
            //this.val_of_arr = this.val_of_arr + this.size_of_arr;
            this.arr[(this.val_of_arr + this.size_of_arr) % this.arr.length] = work;
            this.size_of_arr++;
        }

        //throw new NotYetImplementedException();
    }

    @Override
    public E peek() {
        return this.peek(0);
       // throw new NotYetImplementedException();
    }

    @Override
    public E peek(int i) {

        if (this.size() <=0){
            throw new NoSuchElementException();
        }
        else if (i< size() && i >= 0){
            //this.val_of_arr = this.val_of_arr + i;
            return this.arr[(this.val_of_arr + i) % this.arr.length];
        }

        else {
            throw new IndexOutOfBoundsException();
        }

        //throw new NotYetImplementedException();
    }

    @Override
    public E next() {

        if (this.size()> 0){
            E tmp_val = this.arr[this.val_of_arr];
            this.val_of_arr = (this.val_of_arr+1)%this.arr.length;
            this.size_of_arr --;
            return tmp_val;

        }
        else {
            throw new NoSuchElementException();
        }
        //throw new NotYetImplementedException();
    }

    @Override
    public E update(int i, E value) {
        if (this.size() <=0){
            throw new NoSuchElementException();
        }
        else if (i< size() && i >= 0){
            //this.val_of_arr = this.val_of_arr + i;
            return this.arr[(this.val_of_arr + i) % this.arr.length] = value;
        }

        else {
            throw new IndexOutOfBoundsException();
        }


        //throw new NotYetImplementedException();
    }

    @Override
    public int size() {
        return this.size_of_arr;
        //throw new NotYetImplementedException();
    }

    @Override
    public void clear() {
        this.arr = (E[]) new Comparable[this.capacity()];
        this.size_of_arr = 0;
        this.val_of_arr = 0;
        //throw new NotYetImplementedException();
    }

    @Override
    public int compareTo(FixedSizeFIFOWorkList<E> other) {
        // You will implement this method in project 2. Leave this method unchanged for project 1.
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // You will finish implementing this method in project 2. Leave this method unchanged for project 1.
        if (this == obj) {
            return true;
        } else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        } else {
            // Uncomment the line below for p2 when you implement equals
            // FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            // Your code goes here

            throw new NotYetImplementedException();
        }
    }

    @Override
    public int hashCode() {
        // You will implement this method in project 2. Leave this method unchanged for project 1.
        throw new NotYetImplementedException();
    }
}
