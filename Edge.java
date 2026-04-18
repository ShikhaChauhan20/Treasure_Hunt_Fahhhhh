public class Edge {
    Node source, destination;
    int weight; // Distance in km

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}