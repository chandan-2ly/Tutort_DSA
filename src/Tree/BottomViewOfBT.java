package Tree;

import java.util.*;

public class BottomViewOfBT {
    public static void main(String[] args){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(25);
        root.right.left = new TreeNode(4);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        List<Integer> result = getVerticalOrderElem(root);
        System.out.println(result);
    }
    private static ArrayList<Integer> getVerticalOrderElem(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        while (!queue.isEmpty()){
            Pair temp = queue.poll();
            int vertical = temp._vertical, level = temp._level;
            if (!map.containsKey(vertical))
                map.put(vertical, new TreeMap<>());
            if(!map.get(vertical).containsKey(level))
                map.get(vertical).put(level, new ArrayList<>());

            map.get(vertical).get(level).add(temp._node.val);

            if(temp._node.left != null)
                queue.add(new Pair(temp._node.left, vertical-1, level+1));
            if(temp._node.right != null)
                queue.add(new Pair(temp._node.right, vertical+1, level+1));
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(TreeMap<Integer, List<Integer>> m : map.values()){
            List<Integer> tempList = new ArrayList<>();
            for(List<Integer> pq : m.values()){
                if (pq.size() > 0){
                    tempList.addAll(pq);
                }
            }
            result.add(tempList.get(tempList.size()-1));
        }
        return result;
    }
}
