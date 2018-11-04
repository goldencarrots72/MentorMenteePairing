public class Node {
    String[] name;
    int rank;
    Node next;
    public Node(String name, int rank, Node next){
        this.name = name.trim().split(" ");
        this.rank = rank;
        this.next = next;
    }
}
