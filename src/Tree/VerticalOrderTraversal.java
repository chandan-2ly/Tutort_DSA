package Tree;


import java.util.*;

class Pair{
    TreeNode _node;
    int _vertical;
    int _level;

    public Pair(TreeNode node, int vertical, int level){
        _node = node;
        _vertical = vertical;
        _level = level;
    }
}
public class VerticalOrderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        List<List<Integer>> result = getVerticalOrderElem(root);
        System.out.println(result);
    }

    private static List<List<Integer>> getVerticalOrderElem(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while (!queue.isEmpty()){
            Pair temp = queue.poll();
            int vertical = temp._vertical, level = temp._level;
            if (!map.containsKey(vertical))
                map.put(vertical, new TreeMap<>());
            if(!map.get(vertical).containsKey(level))
                map.get(vertical).put(level, new PriorityQueue<>());

            map.get(vertical).get(level).add(temp._node.val);

            if(temp._node.left != null)
                queue.add(new Pair(temp._node.left, vertical-1, level+1));
            if(temp._node.right != null)
                queue.add(new Pair(temp._node.right, vertical+1, level+1));
        }
        List<List<Integer>> result = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> m : map.values()){
            List<Integer> tempList = new ArrayList<>();
            for(PriorityQueue<Integer> pq : m.values()){
                while (!pq.isEmpty()){
                    tempList.add(pq.poll());
                }
            }
            result.add(tempList);
        }
        return result;
    }
}
