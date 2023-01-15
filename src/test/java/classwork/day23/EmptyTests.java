package classwork.day23;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyNgListener.class})
public class EmptyTests {

    @Test(description = "147407")
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test(description = "147408")
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test(description = "147409")
    public void test3() {
        Assert.assertTrue(true);
    }

    @Test(description = "147410")
    public void test4() {
        Assert.assertTrue(false);
    }
}
