package org.example.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeDummyDataGenerator {
    private static int numNodes = 10; // Number of nodes in the tree
    private static List<TreeNode> nodeList;
    private static TreeNode root;

    public static void main(String[] args) {
        generateDummyData();

        System.out.println("Generated Tree:");
        printTree(root);
    }

    public static void generateDummyData() {
        nodeList = generateDummyNodes(numNodes);
        root = buildTree(nodeList);
    }

    public static List<TreeNode> generateDummyNodes(int numNodes) {
        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 1; i <= numNodes; i++) {
            nodeList.add(new TreeNode("Node " + i));
        }
        return nodeList;
    }

    public static TreeNode buildTree(List<TreeNode> nodeList) {
        TreeNode root = nodeList.get(0);
        Random random = new Random();

        for (int i = 1; i < nodeList.size(); i++) {
            TreeNode node = nodeList.get(i);
            int parentIndex = random.nextInt(i); // Randomly select parent index
            TreeNode parent = nodeList.get(parentIndex);
            parent.addChild(node);
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        printTreeHelper(root, 0);
    }

    public static void printTreeHelper(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.getName());

        for (TreeNode child : node.getChildren()) {
            printTreeHelper(child, level + 1);
        }
    }

    static class TreeNode {
        private String name;
        private List<TreeNode> children;

        public TreeNode(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void addChild(TreeNode child) {
            children.add(child);
        }
    }
}
//OUTPUT:
//Generated Tree:
//Node 1
//Node 2
//Node 3
//Node 4
//Node 5
//Node 8
//Node 10
//Node 6
//Node 7
//Node 9