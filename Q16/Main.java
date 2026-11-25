import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        // Read values into nodes first, then read pos and link tail if pos >= 0.
        // We cannot read pos before values, so we connect after reading all inputs
        // without using an array: we traverse to index pos after reading pos.
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        int pos = sc.nextInt();

        if (pos >= 0 && tail != null) {
            Node target = head;
            for (int i = 0; i < pos && target != null; i++) {
                target = target.next;
            }
            tail.next = target;
        }

        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        System.out.println(hasCycle ? "Yes" : "No");
        sc.close();
    }
}
