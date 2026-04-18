import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class MapPanel extends JPanel {
    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();
    char nextName = 'A';
    Node sourceNode = null;
    Node caveNode = null, mountainNode = null, seaFloorNode = null;
    Node selectedForEdge = null;

    public MapPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean isRight = SwingUtilities.isRightMouseButton(e) || e.isControlDown();
                Node clicked = findNode(e.getX(), e.getY());
                if (isRight && clicked != null) {
                    showMenu(clicked, e.getX(), e.getY());
                } else if (!isRight && clicked == null) {
                    nodes.add(new Node(e.getX(), e.getY(), String.valueOf(nextName++)));
                }
                repaint();
            }
        });
    }

    private void showMenu(Node n, int x, int y) {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem edgeItem = new JMenuItem(selectedForEdge == null ? "Start Line From " + n.name : "End Line At " + n.name);
        edgeItem.addActionListener(e -> {
            if (selectedForEdge == null) {
                selectedForEdge = n;
            } else {
                String d = JOptionPane.showInputDialog("Enter distance (km):");
                if (d != null && !d.isEmpty()) {
                    edges.add(new Edge(selectedForEdge, n, Integer.parseInt(d)));
                }
                selectedForEdge = null;
            }
            repaint();
        });
        menu.add(edgeItem);
        menu.addSeparator();

        String[] roles = {"East-Blue", "Cave", "Mountain", "Sea-Floor"};
        for (String r : roles) {
            JMenuItem item = new JMenuItem("Set as " + r);
            item.addActionListener(al -> {
                if (r.equals("East-Blue")) {
                    for (Node other : nodes) {
                        if (other.name.equals("East-Blue")) {
                            other.name = "Island";
                            other.bagCapacity = new Random().nextInt(6) + 20;
                        }
                    }
                    sourceNode = n;
                } else if (r.equals("Cave")) caveNode = n;
                else if (r.equals("Mountain")) mountainNode = n;
                else if (r.equals("Sea-Floor")) seaFloorNode = n;
                
                n.name = r;
                n.bagCapacity = 0;
                repaint();
            });
            menu.add(item);
        }
        menu.show(this, x, y);
    }

    public void runRace() {
        if (sourceNode == null || caveNode == null || mountainNode == null || seaFloorNode == null) {
            JOptionPane.showMessageDialog(this, "Set East-Blue and ALL 3 destinations first!");
            return;
        }

        String[] hunters = {"Luffy", "Law", "Blackbeard"};
        Node[] targets = {caveNode, mountainNode, seaFloorNode};
        List<Node> targetList = Arrays.asList(targets);
        Collections.shuffle(targetList);

        StringBuilder sb = new StringBuilder("🏴‍☠️ RACE RESULTS 🏴‍☠️\n\n");
        for (int i = 0; i < 3; i++) {
            int dist = 0;
            for(Edge e : edges) {
                if(e.source == sourceNode && e.destination == targetList.get(i)) dist = e.weight;
            }
            if (dist == 0) dist = 25; // Default if not connected

            int bagCap = new Random().nextInt(6) + 20;
            int expenses = (dist * 40) + 200;
            int profit = (new Random().nextInt(30) + 20) - (expenses/100); // Demo math

            sb.append("👤 ").append(hunters[i]).append(" -> ").append(targetList.get(i).name).append("\n");
            sb.append("🎒 Bag: ").append(bagCap).append("kg | Exp: Rs.").append(expenses).append("\n");
            sb.append("💰 Profit: Rs.").append(profit).append(",000\n\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private Node findNode(int x, int y) {
        for (Node n : nodes) if (Math.sqrt(Math.pow(x-n.x,2)+Math.pow(y-n.y,2))<40) return n;
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Edge e : edges) {
            g.drawLine(e.source.x, e.source.y, e.destination.x, e.destination.y);
            g.drawString(e.weight + "km", (e.source.x+e.destination.x)/2, (e.source.y+e.destination.y)/2);
        }
        for (Node n : nodes) {
            if (n.name.equals("East-Blue")) g.setColor(Color.GREEN);
            else if (n.bagCapacity == 0) g.setColor(Color.RED);
            else g.setColor(Color.LIGHT_GRAY);
            g.fillOval(n.x-20, n.y-20, 40, 40);
            g.setColor(Color.BLACK);
            g.drawString(n.name + " (" + n.bagCapacity + "kg)", n.x-25, n.y-25);
        }
    }
}