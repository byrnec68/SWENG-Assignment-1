import org.junit.Test;
import static org.junit.Assert.*;

public class DAGTest {

    @Test
    public void testFindLCA(){

        DAG newDAG = new DAG();
        newDAG.root = new dagNode(1);
        dagNode r2 = new dagNode(2);
        dagNode r3 = new dagNode(3);
        dagNode r4 = new dagNode(4);
        dagNode r5 = new dagNode(5);
        dagNode r6 = new dagNode(6);
 
        dagNode[] rootout = new dagNode[4];
        rootout[0] = r2;rootout[1] = r3;rootout[2] = r4;rootout[3] = r5;

        dagNode[] r2out = new dagNode[1];
        r2out[0] = r4;
        dagNode[] r2in = new dagNode[1];
        r2in[0] = newDAG.root;

        dagNode[] r3out = new dagNode[2];
        r3out[0] = r4;r3out[1] = r5;
        dagNode[] r3in = new dagNode[1];
        r3in[0] = newDAG.root;

        dagNode[] r4out = new dagNode[1];
        r4out[0] = r5;
        dagNode[] r4in = new dagNode[3];
        r4in[0] = newDAG.root;r4in[1] = r2; r4in[2] = r3;

        dagNode[] r5in = new dagNode[3];
        r5in[0] = newDAG.root;r5in[1] = r3;r5in[2] = r4;

        dagNode[] r6in = new dagNode[1];
        r6in[0] = r4;

        newDAG.addEdgesOut(newDAG.root, rootout);
        newDAG.addEdgesOut(r2, r2out);
        newDAG.addEdgesIn(r2, r2in);
        newDAG.addEdgesOut(r3, r3out);
        newDAG.addEdgesIn(r3, r3in);
        newDAG.addEdgesOut(r4, r4out);
        newDAG.addEdgesIn(r4, r4in);
        newDAG.addEdgesIn(r5, r5in);
        newDAG.addEdgesIn(r6, r6in);


        assertEquals("", 3, newDAG.findLCA(newDAG.root, r5, r4));
        assertEquals("", 1, newDAG.findLCA(newDAG.root, r4, r3));
        assertEquals("", -1, newDAG.findLCA(null, r4, r6));
        assertEquals("", 1, newDAG.findLCA(newDAG.root, newDAG.root, r2));
        assertEquals("", 4, newDAG.findLCA(newDAG.root, r6, r5));
        assertEquals("", 5, newDAG.findLCA(newDAG.root, r5, r5));
    }

}