import java.util.*;

class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedListImp dll = new DoublyLinkedListImp();
        dll.insert(new Node(10));
        dll.insert(new Node(20));
        // dll.insert(new Node(30));
        // dll.insert(new Node(40));
        // dll.insert(new Node(50));
        // dll.append(new Node(-10));
        dll.traverseHead();
        Node rNode = dll.getNodeAtIdx(0);
        dll.remove(rNode);
        dll.traverseHead();
        // dll.traverseTail();
    }

    public static class Node {
        Integer value;
        Node next;
        Node prev;

        Node(Integer value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    public static class DoublyLinkedListImp {
        Node head;
        Node tail;
        // Asume that value of node >= 0
        DoublyLinkedListImp() {
            head = new Node(null);
            tail = new Node(null);

            head.next = tail;
            tail.prev = head;
        }
 
        // Add front
        public void insert(Node node) {
            // connect new node with next node
            node.next = head.next;
            head.next.prev = node;

            // update prev node
            head.next = node;
            node.prev = head;
        }

        public void append(Node node) {
            node.prev = tail.prev;
            tail.prev.next = node;

            node.next = tail;
            tail.prev = node;
        }

        public void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;

            node.next = null;
            node.prev = null;
        }

        public void traverseHead() {
            Node temp = head.next;
            while (temp != null && temp.value != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public boolean isEmpty() {
            return head.next == tail;
        }

        public Node getNodeAtIdx(int index) {
            int count = 0;
            Node cur = head.next;
            while (cur != null && cur.value != null) {
                if (count == index) {
                    return cur;
                }
                count++;
                cur = cur.next;
            }
            throw new IndexOutOfBoundsException("In valid index");
        }

        public void traverseTail() {
            Node temp = tail.prev;
            while(temp != null && temp.value != null) {
                System.out.print(temp.value + " ");
                temp = temp.prev;
            }
            System.out.println();
        }
    
    }


}