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
        int k = sc.nextInt();

        if (k <= 0) {
            System.out.println(-1);
            sc.close();
            return;
        }

        Node fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                System.out.println(-1);
                sc.close();
                return;
            }
            fast = fast.next;
        }

        Node slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(slow != null ? slow.data : -1);
        sc.close();
    }
}
