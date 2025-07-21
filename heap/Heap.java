import java.util.ArrayList;

public interface Heap
{
    public void heapify(int i);
    public void insertNode(int newNum);
    public void deleteNode(int num);
    public void display();
}