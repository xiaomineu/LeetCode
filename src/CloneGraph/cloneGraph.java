package CloneGraph;

import java.lang.reflect.Array;
import java.util.*;

class Node{
    public int val;
    public List<Node> neighbors;
    public Node(){}
    public Node(int _val,List<Node> _neighbors){
        val=_val;
        neighbors=_neighbors;
    }
}
public class cloneGraph {
    public static void main(String[] args) {

    }
    //实现图的深层拷贝;为每个之前对象开辟新的内存地址，并复制数值;
    Map<Node,Node> map=new HashMap<>();//map表示节点与它的深拷贝节点的键值对;
    public Node clone(Node node){
        if(node==null){
            return null;
        }
        return traversalNodeChildren(node);
    }
    //using dfs
    private Node traversalNodeChildren(Node node){
        ArrayList<Node> arrayList=new ArrayList<>();
        Node copyNode=new Node(node.val,arrayList);
        map.put(node,copyNode);
        for(Node neighbor:node.neighbors){
            Node neighborCopy=map.get(neighbor);
            if(neighborCopy==null){
                neighborCopy=traversalNodeChildren(neighbor);
            }
            arrayList.add(neighborCopy);
        }
        return copyNode;
    }
}
