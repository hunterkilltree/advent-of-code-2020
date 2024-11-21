public class SingLinkedList {
    public static void main(String[] args) {
        SingleLinkedListImpl sll = new SingleLinkedListImpl();
        sll.insert(new Node(2));
        sll.insert(new Node(3));
        Node node1 = sll.getNodeAtIndx(0);
        sll.remove(node1);
        
        Node node2 = sll.getNodeAtIndx(0);
        sll.remove(node2);
        sll.traverse();
    }

    public static class Node {
        Integer value;
        Node next;

        Node (Integer value) {
            this.value = value;
            next = null;
        }
    }

    public static class SingleLinkedListImpl {
        Node head;

        SingleLinkedListImpl() {
            head = new Node(null);
        }

        public void insert(Node node) {
            node.next = head.next;
            head.next = node;
        }

        public void remove(Node node) {
            // edge case last node
            if (node.next == null) {
                node.value = null;
                return;
            }
            // swap value
            node.value = node.next.value;
            node.next = node.next.next;
        }

        public Node getNodeAtIndx(int idx) {
            Node cur = head.next; // due to init dummy node is null
            int count = 0;
            while (cur != null && cur.value != null) {
                if (count == idx) {
                    return cur;
                }
                count++;
                cur = cur.next;
            }
            throw new IndexOutOfBoundsException("Invalid index ");
        }

        public void traverse() {
            Node cur = head.next;
            while(cur != null && cur.value != null) {
                System.out.print(cur.value + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
