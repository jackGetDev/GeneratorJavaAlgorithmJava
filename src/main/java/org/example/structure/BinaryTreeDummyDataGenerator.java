package org.example.structure;

import java.util.*;

public class BinaryTreeDummyDataGenerator {
    private static int numNodes = 10; // Number of nodes in the binary tree
    private static List<String> dataList;
    private static TreeNode root;

    public static void main(String[] args) {
        generateDummyData();

        System.out.println("Generated Binary Tree:");
        visualizeBinaryTree(root);

        System.out.println("\nBreadth-First Search (BFS):");
        bfs(root);

        System.out.println("\nDepth-First Search (DFS):");
        dfs(root);
    }

    public static void generateDummyData() {
        dataList = generateDummyList(numNodes);
        root = buildBinaryTree(dataList);
    }

    public static List<String> generateDummyList(int numNodes) {
        List<String> dataList = new ArrayList<>();
        for (int i = 1; i <= numNodes; i++) {
            dataList.add("Node " + i);
        }
        return dataList;
    }

    public static TreeNode buildBinaryTree(List<String> dataList) {
        List<TreeNode> nodeList = new ArrayList<>();
        for (String data : dataList) {
            nodeList.add(new TreeNode(data));
        }

        Random random = new Random();

        TreeNode root = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            TreeNode node = nodeList.get(i);
            TreeNode parent = nodeList.get(random.nextInt(i));
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }

        return root;
    }

    public static void visualizeBinaryTree(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getData());
        visualizeBinaryTree(node.getLeft());
        visualizeBinaryTree(node.getRight());
    }

    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.getData());

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getData());

        dfs(node.getLeft());
        dfs(node.getRight());
    }

    static class TreeNode {
        private String data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public String getData() {
            return data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
//
//OUTPUT:
//Generated Binary Tree:
//Node 1
//Node 2
//Node 3
//Node 4
//Node 10
//
//Breadth-First Search (BFS):
//Node 1
//Node 2
//Node 3
//Node 4
//Node 10
//
//Depth-First Search (DFS):
//Node 1
//Node 2
//Node 3
//Node 4
//Node 10
