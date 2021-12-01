package lesson1.section2;

/**
 * @ClassName QuickUnionUF
 * @Description TODO
 * @Author Nanxing Tang
 * @Date 2021--12--01--12:39
 **/
public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i ++) id[i] = i;
    }

    private int root(int i) {
        while(id[i] != i) i = id[i];
        return i;
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        id[rp] = rq;
    }

}
