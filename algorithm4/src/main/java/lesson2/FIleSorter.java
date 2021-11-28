package lesson2;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * @ClassName FIleSorter
 * @Description TODO
 * @Author Nanxing Tang
 * @Date 2021--11--28--20:06
 **/
public class FIleSorter {
    public static void main(String[] args) {
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        Insertion.sort(files);
        for(int i = 0; i < files.length; i ++){
            StdOut.println(files[i].getName());
        }
    }
}
