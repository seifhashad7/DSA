public class Main {
    public static void main(String[] args)
    {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst("seif");
        dll.addLast("aldein");
        dll.addLast("ahmed");
        dll.addLast("ahmed");
        dll.addAfter(dll.head.next.next.next,"hashad");
        dll.addLast("ali");
        dll.deleteNode(dll.head.next.next);
        dll.deleteNode(dll.head.next.next.next.next);
        System.out.println(dll.toString());
    }
}
