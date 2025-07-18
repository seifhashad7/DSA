public class DoublyLinkedList<T> {    
    private int size = 0;
    private Node<T> head = null;

    //Node class
    public static class Node<T>
    {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        Node(T data)
        {
            this(data, null, null);
        }

        Node(T data, Node<T> prev, Node<T> next)
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString()
        {
            return data.toString();
        }
    }

    //size
    public int size()
    {
        return size;
    }

    //isEmpty
    public boolean isEmpty()
    {
        //head == null
        return (head == null);
    }
    
    //add
    public void add(T val)
    {
        addLast(val);
    }

    //addLast
    public void addLast(T val)
    {
        Node<T> newNode = new Node<T>(val, null, null);
        Node<T> tmp = head;
        if(isEmpty())
        {
            head = newNode;
            return;
        }
        else
        {
            while(tmp.next != null)
            {
                //Traverse till end of the list
                tmp = tmp.next;
            }

            newNode.prev = tmp;
            tmp.next = newNode;
        }
        size++;
    }

    //addFirst
    public void addFirst(T val)
    {
        Node<T> newNode = new Node<T>(val, null, null);

        if(isEmpty())
        {
            
        }
        else
        {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }
    
    //peekFirst
    public T peekFirst()
    {
        if(isEmpty()) throw new RuntimeException("Empty List!!");
        return head.data;
    }
    
    //peekLast
    public T peekLast()
    {
        if(isEmpty()) throw new RuntimeException("Empty List!!");
        Node<T> tmp = head;

        while(tmp.next != null) tmp = tmp.next;

        return tmp.data;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        Node<T> tmp = head;
        while(tmp.next != null)
        {
            sb.append(tmp.data + ", ");
            tmp = tmp.next;
        }
        sb.append(tmp.data);
        return sb.toString();
    }
}
