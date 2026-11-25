import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    private static Node readList(Scanner sc, int count) {
        Node head = null, tail = null;
        for (int i = 0; i < count; i++) {
            Node newNode = new Node(sc.nextInt());
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Node l1 = readList(sc, n);

        int m = sc.nextInt();
        Node l2 = readList(sc, m);

        Node dummy = new Node(0);
        Node tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;

        StringBuilder sb = new StringBuilder();
        Node curr = dummy.next;
        while (curr != null) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(curr.data);
            curr = curr.next;
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
