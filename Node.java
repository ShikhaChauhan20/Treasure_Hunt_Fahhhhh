import java.util.Random;

public class Node {
    int x, y;
    String name;
    int bagCapacity; // Used as the "Magic Bag" capacity later

    public Node(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.bagCapacity = new Random().nextInt(6) + 20; // 20 to 25 kg
    }
}