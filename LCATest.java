

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class LCATest{
    @Test
    public void testConstructor(){
        new LCA();
    }
    @Test
    public void testLCA() {
        LCA lca = LCA.newLCA(); 
        LCA empty = LCA.emptyLCA();
        assertEquals("Expected answer == 2",2, lca.findLCA(4, 5) );
        assertEquals("Expected answer == 1",1, lca.findLCA(3,2));
        assertEquals("Expected answer == -1 as null, EMPTY BST ",-1, empty.findLCA(1, 2));
        assertEquals("Expected answer == -1, only left node exists",-1, lca.findLCA(1, 8));
        assertEquals("Expected answer == -1, only right node exists",-1, lca.findLCA(-1, 1));
        
            
    }


}