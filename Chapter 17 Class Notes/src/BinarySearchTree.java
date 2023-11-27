/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;

        if(this.root == null){
            this.root = newNode;
        }
        
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        Node current = this.root;

        while(current != null){
            int diff = obj.compareTo(current.data);
            if(diff ==0){
                return true;
            }else if(diff <0){
                current = current.left;
            }else if (diff >0){
                current = current.right;
            }
        }
        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        Node TBR = this.root;
        Node parent = null;
        boolean found = false;

        while(!found && TBR != null){
            int diff = obj.compareTo(TBR.data);
            if(diff==0){
                found = true;
            }else{
                parent = TBR;
            }
        }

        //case 1 and 2(one child is null)
        if(TBR.left == null || TBR.right ==null){
            Node newChild;

            if (TBR.left == null){
                newChild = TBR.right;
            }
        }

        //case 3 (node to be removed has two children
        Node leastParent = TBR;
        Node least = TBR.right;
        while(least.left != null){
            leastParent = least;
            least = least.left;
        }
        TBR.data = least.data;//move data

        //unlink least child
        if(leastParent == TBR){
            leastParent.right = least.right;
        }else{
            leastParent.left = least.right;
        }
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        print(this.root);
        System.out.println();
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        if(parent == null){
            return;
        }

        print(parent.left);
        System.out.println(parent.data+" ");
        print(parent.right);
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        //must be made of comparables
        public Comparable data;
        public Node left;
        public Node right;

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
          int diff = newNode.data.compareTo(data);

          if (diff <0){
              if(left==null){
                  left = newNode;
              }else{
              left.addNode(newNode);
              }
          }else if(diff >0){
              if(right == null){
                  right = newNode;
              }else{
                  right.addNode(newNode);
              }
          }
        }
    }
}



