import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeTest {

    @Test
    public void testGenerationPrintout() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        one.setRightSibling(two);

        two.setLeftSibling(one);
        two.setRightSibling(three);
        two.setChild(five);

        three.setLeftSibling(two);
        three.setRightSibling(four);

        four.setLeftSibling(three);
        four.setChild(seven);

        five.setParent(two);
        five.setRightSibling(six);
        five.setChild(eight);

        six.setLeftSibling(five);

        seven.setParent(four);
        seven.setChild(nine);

        eight.setParent(five);

        nine.setParent(seven);

        List<Node> output = Node.orderByGeneration(new ArrayList<>(), Collections.singletonList(one));
    }

}