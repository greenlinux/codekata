package cn.david.kata01;

public class Checkout {

    private int total;
    private int itemACount;
    private int itemBCount;

    public void scan(String item) {
        if("A".equals(item)) {
            itemACount++;
            if(itemACount%3==0) {
                total += 30;
            } else {
                total += 50;
            }
        }

        if("B".equals(item)) {
            itemBCount++;
            if(itemBCount%2==0) {
                total += 15;
            } else {
                total += 30;
            }
        }

        if("C".equals(item)) {
            total += 20;
        }

        if("D".equals(item)) {
            total += 15;
        }
    }

    public int total() {
        return total;
    }
}
