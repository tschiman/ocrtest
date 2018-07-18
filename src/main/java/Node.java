import java.util.ArrayList;
import java.util.List;

public class Node {
    private Node parent;
    private Node child;
    private Node rightSibling;
    private Node leftSibling;
    private int order;

    public Node(int order) {
        this.order = order;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getRightSibling() {
        return rightSibling;
    }

    public void setRightSibling(Node rightSibling) {
        this.rightSibling = rightSibling;
    }

    public Node getLeftSibling() {
        return leftSibling;
    }

    public void setLeftSibling(Node leftSibling) {
        this.leftSibling = leftSibling;
    }

    public static List<Node> orderByGeneration(List<Node> outputList, List<Node> nodes) {
        List<Node> decendents = new ArrayList<>();

        do {
            if (decendents.size() > 0){
                nodes = new ArrayList<>(decendents);
                decendents.clear();
            }
            for (Node node : nodes) {
                Node nodeForLoop = null;
                do {
                    if (nodeForLoop == null) {
                        nodeForLoop = node;
                    } else {
                        nodeForLoop = nodeForLoop.getRightSibling();
                    }
                    outputList.add(nodeForLoop);
                    if (nodeForLoop.getChild() != null)
                        decendents.add(nodeForLoop.getChild());

                } while (nodeForLoop.getRightSibling() != null);
            }
        } while (decendents.size() > 0);

        return outputList;
    }
}
