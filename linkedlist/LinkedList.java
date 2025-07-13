public class LinkedList {
    Node head;

    //Create a node
    class Node
    {
        int data;
        Node next;

        Node()
        {
            next = null;
        }

        //Constructor
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /**
     * Checks if the linked list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Inserts a node at the beginning of the linked list
     * @param d value to insert
     */
    public void insertAtBeginning(int d) {
        Node newNode = new Node(d);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    /**
     * Inserts a node after a given node in the linked list
     * @param d value to insert
     * @param prevNode node after which to insert
     */
    public void insertAfterNode(int d, Node prevNode) {
        if (prevNode == null) {
            System.out.println("Previous node is null");
            return;
        }
        Node newNode = new Node(d);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    /**
     * Inserts a node at the end of the linked list
     * @param d value to insert
     */
    public void insertAtEnd(int d) {
        Node newNode = new Node(d);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = null;
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
    }

    /**
     * Deletes the node at the specified position
     * @param pos position of the node to delete (0-based)
     */
    public void deleteNode(int pos) {
        if (head == null) return;
        if (pos == 0) {
            head = head.next;
            return;
        }
        Node p = head;
        for (int i = 0; i < pos - 1 && p != null; i++) {
            p = p.next;
        }
        if (p == null || p.next == null) return;
        p.next = p.next.next;
    }

    /**
     * Displays all values in the linked list
     */
    public void display() {
        Node p = head;
        System.out.print("Values: ");
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * Returns the length of the linked list
     */
    public int length() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * Searches for a value in the linked list
     * @param d value to search for
     * @return true if found, false otherwise
     */
    public boolean search(int d) {
        Node p = head;
        while (p != null) {
            if (p.data == d) return true;
            p = p.next;
        }
        return false;
    }
}
