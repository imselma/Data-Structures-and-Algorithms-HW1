package task1;

public class Stack<Item> {
    private Queue<Item> q1;
    private Queue<Item> q2;

    public Stack() {

        //In constructor we initialize queue 1 and queue 2
        this.q1 = new Queue<>();
        this.q2 = new Queue<>();
    }

    public void push(Item data) {

        //Adding elements in the empty queue -> q2
        q2.enqueue(data);
        while(!q1.isEmpty()){

            q2.enqueue(q1.dequeue());
        }
        //Since q2 has to remain empty for pushing new elements, we swap the queues
        //In order to swap queues, I initialized one more queue (q) --> and to the swapping process as for every other variable
        Queue<Item> q = new Queue<>();
        q=q1;
        q1=q2;
        q2=q;
    }

    public Item pop() {

        //Since q2 remains empty, all present elements are in q1 -> that's why we dequeue from q1 -> since the element
        // So if q1 is not empty -> dequeue first element (FIFO), but since we maintain two gueues this will work as LIFO for stack
        Item element = null;
        if (!q1.isEmpty()) {
            element = q1.dequeue();
        }
        return element;
    }

    public Item peek() {

        /*When we got the element that is top most in stack (dequeue first element from q1, since it holds the elements),
          in order not to remove it we push it back and the size remains the same*/
        Item element = null;
        if(!q1.isEmpty()) {
            element=q1.dequeue();
        }
        this.push(element); //calling the method push in order to bush element in stack
        return element;
    }

    public int size() {

        //Again, since q1 is the one that holds the elements, after swapping -> check size of q1 and that will be the size of stack
        int size = q1.size();
        return size;
    }

    public boolean isEmpty() {
        //Again, since q1 is the one that holds the elements, after swapping -> check if q1 is empty, so we will know if stack is empty
        boolean emptyStack = q1.isEmpty();
        return emptyStack;
    }
}
