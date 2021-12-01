package lesson1.section2;

/**
 * @ClassName QuickFindUF
 * @Description TODO
 * @Author Nanxing Tang
 * @Date 2021--12--01--12:34
 **/
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id  = new int[N];
        for (int i = 0; i < N ; i ++ ) id[i] = i;
    }

    private boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    private void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i ++) {
            if (id[i] == pid) id[i] = qid;
        }
    }
}
