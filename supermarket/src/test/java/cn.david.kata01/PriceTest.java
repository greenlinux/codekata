package cn.david.kata01;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class PriceTest {

    private int price(String itemStr) {

        if(itemStr==null||"".equals(itemStr.trim())) {
            return 0;
        }

        Checkout co = new Checkout();
       String[] items= itemStr.split("");
        for (String item:items) {
            co.scan(item);
        }
        return co.total();
    }

    private void assertEqual(int expect, int actual) {
        Assert.assertThat(actual, IsEqual.equalTo(expect));
    }

    @Test
    public void testIncrementPrice() {

        Checkout co = new Checkout();
        co.scan("A");
        assertEqual(50, co.total());

        co.scan("A");
        assertEqual(100, co.total());

        co.scan("A");
        assertEqual(130, co.total());

        co.scan("A");
        assertEqual(180, co.total());

        co.scan("B");
        assertEqual(210, co.total());
    }

    @Test
    public void testTotalPrice() {

        assertEqual(190, price("AAABBD"));
        assertEqual(190, price("DABABA"));
        assertEqual(115, price("CDBA"));
    }
}
