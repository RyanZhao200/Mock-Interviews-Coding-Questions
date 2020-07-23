class Node{
        int val;
        int min;
        Node next;

        Node(int x,int min){
            this.min = min;
            this.val = x;
            this.next = null;
        }
    }


class MinStack {
    Node head;

    /** initialize your data structure here. */
    public MinStack() {
        head = null;
        
    }
    
    public void push(int x) {
        if(head == null){
            head = new Node(x,x);
        }

        else{
            Node newNode = new Node(x, Math.min(x,head.min));
            newNode.next = head;
            head = newNode;
        }
        
    }
    
    public void pop() {
        int val = head.val;
        head = head.next;
        //return val;
        
    }
    
    public int top() {
        return head.val;
        
    }
    
    public int getMin() {
        return head.min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
