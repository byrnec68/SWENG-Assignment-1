import java.util.*;

class dagNode {

    int data;
    dagNode[] in;
    dagNode[] out;

    public dagNode(int data) {
        this.data = data;
        in = null;
        out = null;
    }

}

public class DAG {
    dagNode root;

    public void addEdgesIn(dagNode x, dagNode[] inArray) {
        x.in = inArray;
    }

    public void addEdgesOut(dagNode x, dagNode[] outArray) {
        x.out = outArray;
    }

    public int findLCA(dagNode root, dagNode val1, dagNode val2) {
        if (root == null) {
            return -1;
        }
        if ((root.data == val1.data) || (root.data == val2.data)) {
            return root.data;
        }
        if (val1.data == val2.data) {
            return val1.data;
        }
        ArrayList<Integer> lca = new ArrayList<Integer>();
        int i = 0;
        while (i < val1.in.length) {
            int j = 0;
            while (j < val2.in.length) {
                if (val1.in[i].data == val2.in[j].data) {
                    lca.add(val1.in[i].data);
                    j++;
                } else {
                    j++;
                }
            }
            i++;
        }
        if (lca.size() == 0) {
            if (val1.data > val2.data) {
                lca.add(findLCA(root, val1.in[0], val2));
            } else {
                lca.add(findLCA(root, val1, val2.in[0]));
            }
        }

        return Collections.max(lca);
    }
}
