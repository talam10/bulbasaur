package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See cse332/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    /*
    We declare node variables head and tail for the linked list,
    and a size variable to keep track of the size.
     */
    private Node head;
    private Node tail;
    private int size;

    public ListFIFOQueue() {
        //Default constructor with no value in the node.
        head = new Node();
        tail = new Node();
        size = 0;

        head.setNext(tail);
        tail.setPrev(head);
    }

    @Override
    public void add(E work) {
        /*
        The add method adds value to the end of the linked list.
        We first store work into a Node variable temp. Then, we
        check if tail's prev is head. If so, we append temp into
        the back of the list. If not, we append temp after head.
         */
        Node temp = new Node(work);
        if(tail.getPrev() != head) {
            Node temp2 = tail.getPrev();
            temp2.setNext(temp);
            temp.setNext(tail);
            temp.setPrev(temp2);
            tail.setPrev(temp);
        } else {
            head.setNext(temp);
            temp.setNext(tail);
            temp.setPrev(head);
            tail.setPrev(temp);
        }
        size++;
    }

    @Override
    public E peek() {
        /*
        The peek method checks the first value of the linked list.
        We check if head is null, and if head's next is tail. If so,
        the linked list is empty, where we throw exception. Otherwise,
        we return head's next node, as it is the first value of the list.
         */
        if(head != null && head.getNext() != tail) {
            return head.getNext().getData();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E next() {
        /*
        The next method removes the first value of the linked list.
        We first declare a temp variable to return the value we removed
        from the linked list. Then, we check if head's next is tail. If so,
        the linked list is empty, where we throw exception. Otherwise, we
        declare a temp2 variable as head's next, and we set head's next to
        temp2's next, and prev of temp2's next to head.
         */
        E temp;
        if(head.getNext() != tail) {
            Node temp2 = head.getNext();
            temp = temp2.getData();

            head.setNext(temp2.getNext());
            temp2.getNext().setPrev(head);
        } else {
            throw new NoSuchElementException();
        }
        size--;
        return temp;
    }

    @Override
    public int size() {
        //The size method checks the size of the linked list.
        return this.size;
    }

    @Override
    public void clear() {
        /*
        The clear method clears the linked list.
        We set head node to null to clear the linked list.
        Then, we set size to 0.
         */
        head = null;
        size = 0;
    }

    public boolean hasWork() {
        /*
        We check if head is null. If head isn't null,
        then it has work.
         */
        return head != null;
    }

    private class Node {
        /*
        This is the subclass Node we will use for the queue implementation.
        We declare a generic variable data to keep track of the data,
        and we declare node variables next and prev to keep track of the
        next and prev nodes of each individual node.
         */
        private E data;
        private Node next;
        private Node prev;

        //Default constructor, we set everything to null.
        public Node() {
            this.data = null;
            this.next = null;
            this.prev = null;
        }

        //Constructor with given data.
        public Node(E dataValue) {
            this.data = dataValue;
            this.next = null;
            this.prev = null;
        }

        //getData returns the data of the node.
        public E getData() {
            return this.data;
        }

        //getNext returns the next node.
        public Node getNext() {
            return this.next;
        }

        //getPrev returns the prev node.
        public Node getPrev() {
            return this.prev;
        }

        //setData changes the data of the current node.
        public void setData(E dataValue) {
            this.data = dataValue;
        }

        //setNext changes the next node.
        public void setNext(Node nextN) {
            this.next = nextN;
        }

        //setPrev changes the prev node.
        public void setPrev(Node prevN) {
            this.prev = prevN;
        }
    }
}


