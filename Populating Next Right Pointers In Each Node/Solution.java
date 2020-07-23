/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node rootPointer = root;
 
        //maintain 2 pointers
        Node childHead = null; //NEXT level's head pointer
        Node child = null; //NEXT level's traversal pointer
 
        while (root !=null ) 
        {
            //*******************************************
            //Step1: build child level's next pointers
            //*******************************************
             
            //if current item has left child
            if (root.left !=null ) 
            {    
                //mark child level's head if it is not done
                if(childHead ==null)
                {
                    //both child and childHead point to left node
                    childHead = root.left;
                    child = root.left;
                }
                else
                {
                    //attach child next to root's left node
                    child.next = root.left;   
                     
                    //move to child's next                     
                    child = child.next;
                }
            }
 
            if (root.right !=null) 
            {
                //mark child level's head if it is not done
                if(childHead ==null)
                {
                    //both child and childHead point to right node
                    childHead = root.right;
                    child = root.right;
                }
                else
                {
                    //attach child next to root's right node
                    child.next = root.right;   
                     
                    //move to child's next                     
                    child = child.next;
                }
            }
             
            //*******************************************
            //Step2: move to next item on SAME level
            //*******************************************
            root = root.next;
 
            //*******************************************
            //Step3: Once we reach END of current level
            //*******************************************
            if(root ==null)
            {
                //go to next LEVEL
                root = childHead;                    
 
                //reset child and childHead pointers 
                childHead = null;
                child = null;
            }
        }
         
        return rootPointer;
    
        
    }
}
