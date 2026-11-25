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
        int x = sc.nextInt();

        int pos = 1;
        int result = -1;
        Node curr = head;
        while (curr != null) {
            if (curr.data == x) {
                result = pos;
                break;
            }
            pos++;
            curr = curr.next;
        }
        System.out.println(result);
        sc.close();
    }
}
