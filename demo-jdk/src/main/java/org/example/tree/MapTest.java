package org.example.tree;

import java.util.HashMap;

public class MapTest {

    public static class TreeNode {
        public int val;        // 节点值
        public int height;     // 节点高度
        public TreeNode left;  // 左子节点
        public TreeNode right; // 右子节点
        public TreeNode(int x) { val = x; }
    }



    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<>(16);
        map.put("","");
    }
}
