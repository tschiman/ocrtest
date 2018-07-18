package nameddto;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NamedDtoServiceTest {

    @Test
    public void testTreeTraversalForLongestName() {
        NamedDto one = new NamedDto(1, "A");
        NamedDto two = new NamedDto(2, "B");
        NamedDto three = new NamedDto(3, "C");
        NamedDto four = new NamedDto(4, "D");
        NamedDto five = new NamedDto(5, "E");
        NamedDto six = new NamedDto(6, "F");
        NamedDto seven = new NamedDto(7, "G");

        one.setChildren(Arrays.asList(2,3,4));
        two.setChildren(Arrays.asList(6,7));
        six.setChildren(Arrays.asList(4));

        NamedDtoService namedDtoService = new NamedDtoService();
        namedDtoService.addNamedDto(one);
        namedDtoService.addNamedDto(two);
        namedDtoService.addNamedDto(three);
        namedDtoService.addNamedDto(four);
        namedDtoService.addNamedDto(five);
        namedDtoService.addNamedDto(six);
        namedDtoService.addNamedDto(seven);

        String output = namedDtoService.findLongestString(one);

        Assert.assertEquals("ABFD", output);
    }

}