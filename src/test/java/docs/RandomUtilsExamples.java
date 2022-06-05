package docs;

import static utils.RandomUtils.*;

public class RandomUtilsExamples {
    public static void main(String[] args) {
        System.out.println("Random string 10: " + getRandomString(10));
        System.out.println("Random message 100: " + getRandomMessage(10, 100));
        System.out.println("Random int 3-20: " + getRandomInt(3, 20));
        System.out.println("Random email: " + getRandomEmail());
    }
}
