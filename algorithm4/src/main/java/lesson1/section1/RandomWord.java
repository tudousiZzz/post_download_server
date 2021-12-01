package lesson1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = "";
        int i = 1;
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / i++)) {
                champion = str;
            }
        }
        StdOut.println(champion);
    }
}
