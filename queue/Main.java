public class Main
{
    public static void main(String[] args) {
        Queue q = new Queue(3);
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.toString());
    }
}