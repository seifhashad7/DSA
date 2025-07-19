public class DoublyLinkedList<T> {    
    private int size = 0;
    public Node<T> head = null;

    //Node class
    public static class Node<T>
    {
        public T data;
        public Node<T> prev;
        public Node<T> next;

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

    public void addAfter(Node<T> node, T data)
    {
        // check if previous node is null
        if (node == null) {
            throw new RuntimeException("The Node you inserted isn't in the list");
        }

        // allocate memory for newNode and assign data to newNode
        Node<T> newNode = new Node<T>(data);

        // set next of newNode to next of prev node's next
        newNode.next = node.next;

        // set next of prev node to newNode
        node.next = newNode;

        // set prev of newNode to the previous node
        newNode.prev = node;

        // set prev of newNode's next to newNode
        if (newNode.next != null)
        newNode.next.prev = newNode;

        size++;
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

    public void deleteNode(Node<T> node)
    {
        // If the list is empty or the node to delete is null, throw an exception
        if(isEmpty() || node == null) throw new RuntimeException("Can't delete since the list is empty!!");
        
        // If the node to delete is the head, update head to the next node
        if(head == node)
        {
            head = head.next;
            // If the new head is not null, set its prev to null
            if(head != null) head.prev = null;
        }

        // If the node to delete is not the last node, update the next node's prev pointer
        if(node.next != null)
        {
            node.next.prev = node.prev;
        }

        // If the node to delete is not the first node, update the previous node's next pointer
        if(node.prev != null)
        {
            node.prev.next = node.next;
        }

        // Decrement the size of the list
        size--;
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
