package linkedlist;

import org.junit.Assert;
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

        Assert.assertEquals(1, output.get(0).getOrder());
        Assert.assertEquals(2, output.get(1).getOrder());
        Assert.assertEquals(3, output.get(2).getOrder());
        Assert.assertEquals(4, output.get(3).getOrder());
        Assert.assertEquals(5, output.get(4).getOrder());
        Assert.assertEquals(6, output.get(5).getOrder());
        Assert.assertEquals(7, output.get(6).getOrder());
        Assert.assertEquals(8, output.get(7).getOrder());
        Assert.assertEquals(9, output.get(8).getOrder());
    }

}