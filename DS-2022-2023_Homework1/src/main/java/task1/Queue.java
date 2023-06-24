package task1;

public class Queue<Item> {
    private static class Node<Item> { //klasa koja definise node u queue
        Item data;
        Node<Item> next; //pointer na next node
    }

    private Node<Item> head = null;
    private Node<Item> tail = null;
    private  int size = 0;

    public void enqueue(Item item) {    // public void enqueue(Node<Item> node)
        Node<Item> newNode = new Node<>();  // bez ovog
        newNode.data = item;                // i ovog bi bilo
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;  //pointer to new node
            tail = newNode;
        }
        size++;
    }

    public Item dequeue() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty.");
        }
        Item data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }
}