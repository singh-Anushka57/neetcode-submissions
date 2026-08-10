/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        HashMap<Node,Node> map=new HashMap<>();
        Node curr=head;
        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
    while(curr!=null){
            Node copy=map.get(curr);//A--->A'
            copy.next=map.get(curr.next);//B---->B'
            copy.random=map.get(curr.random);//A---C  THEN map.get gives A'--->C' as a points to a' and c points to c'
            curr=curr.next;
        }
        return map.get(head);
    }
    }

