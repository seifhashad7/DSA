public class Main
{
    public static void main(String[] args) {
        cQueue q = new cQueue(5);
        
        // Fails because front = -1
        // q.dequeue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        // Fails to enqueue because front == 0 && rear == SIZE - 1
        // q.enqueue(6);

        System.out.println(q.toString());

        int elem = q.dequeue();

        if (elem != -1) {
        System.out.println("Deleted Element is " + elem);
        }
        
        System.out.println(q.toString());

        q.enqueue(7);

        System.out.println(q.toString());

        // Fails to enqueue because front == rear + 1
        // q.enqueue(8);
    }
}