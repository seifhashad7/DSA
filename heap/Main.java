public class Main
{
    public static void main(String[] args)
    {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insertNode(10);
        maxHeap.insertNode(20);
        maxHeap.insertNode(5);
        maxHeap.insertNode(30);
        maxHeap.insertNode(2);
        
        maxHeap.deleteNode(20);

        maxHeap.display();
    }
}