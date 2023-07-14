package org.example.structure;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListDummyDataGenerator {
    private static int numNodes = 10; // Number of nodes in the linked list
    private static LinkedList<Node> linkedList;

    public static void main(String[] args) {
        generateDummyData();

        System.out.println("Generated Linked List:");
        visualizeLinkedList(linkedList);

        System.out.println("\nUpdate Node:");
        int updatePosition = getRandomPosition();
        String updatedData = "Updated Node " + updatePosition;
        updateNode(updatePosition, updatedData);
        visualizeLinkedList(linkedList);

        System.out.println("\nDelete Node:");
        int deletePosition = getRandomPosition();
        deleteNode(deletePosition);
        visualizeLinkedList(linkedList);

        System.out.println("\nInsert Node at Position:");
        int insertPosition = getRandomPosition();
        String newData = "New Node";
        insertNodeAtPosition(insertPosition, newData);
        visualizeLinkedList(linkedList);

        System.out.println("\nReverse Linked List:");
        reverseLinkedList();
        visualizeLinkedList(linkedList);
    }

    public static void generateDummyData() {
        linkedList = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < numNodes; i++) {
            String data = "Node " + (i + 1);
            Node node = new Node(data);
            linkedList.add(node);
        }

        for (int i = 0; i < numNodes; i++) {
            Node currentNode = linkedList.get(i);
            int previousIndex = random.nextInt(i + 1);
            Node previousNode = linkedList.get(previousIndex);
            currentNode.setPrevious(previousNode);
            previousNode.setNext(currentNode);
        }
    }

    public static int getRandomPosition() {
        Random random = new Random();
        return random.nextInt(numNodes);
    }

    public static void visualizeLinkedList(LinkedList<Node> linkedList) {
        for (Node node : linkedList) {
            System.out.println(node.getData());
        }
    }

    public static void updateNode(int position, String newData) {
        if (position >= 0 && position < linkedList.size()) {
            Node node = linkedList.get(position - 1); // Mengakses simpul dengan posisi 4 (indeks 3)
            node.setData(newData);
        } else {
            System.out.println("Invalid position!");
        }
    }

    public static void deleteNode(int position) {
        if (position >= 0 && position < linkedList.size()) {
            Node node = linkedList.get(position);
            Node previousNode = node.getPrevious();
            Node nextNode = node.getNext();

            if (previousNode != null) {
                previousNode.setNext(nextNode);
            }

            if (nextNode != null) {
                nextNode.setPrevious(previousNode);
            }

            linkedList.remove(position);
        } else {
            System.out.println("Invalid position!");
        }
    }

    public static void insertNodeAtPosition(int position, String newData) {
        if (position >= 0 && position <= linkedList.size()) {
            Node newNode = new Node(newData);

            if (position == 0) {
                Node nextNode = linkedList.getFirst();
                if (nextNode != null) {
                    nextNode.setPrevious(newNode);
                }
                newNode.setNext(nextNode);
                linkedList.addFirst(newNode);
            } else if (position == linkedList.size()) {
                Node previousNode = linkedList.getLast();
                if (previousNode != null) {
                    previousNode.setNext(newNode);
                }
                newNode.setPrevious(previousNode);
                linkedList.addLast(newNode);
            } else {
                Node previousNode = linkedList.get(position - 1);
                Node nextNode = previousNode.getNext();
                newNode.setPrevious(previousNode);
                newNode.setNext(nextNode);

                if (previousNode != null) {
                    previousNode.setNext(newNode);
                }

                if (nextNode != null) {
                    nextNode.setPrevious(newNode);
                }

                linkedList.add(position, newNode);
            }
        } else {
            System.out.println("Invalid position!");
        }
    }

    public static void reverseLinkedList() {
        LinkedList<Node> reversedList = new LinkedList<>();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            Node node = linkedList.get(i);
            reversedList.add(node);
        }
        linkedList = reversedList;
    }

    static class Node {
        private String data;
        private Node previous;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
//
//OUTPUT:
//Generated Linked List:
//Node 1
//Node 2
//Node 3
//Node 4
//Node 5
//Node 6
//Node 7
//Node 8
//Node 9
//Node 10
//
//Update Node:
//Node 1
//Node 2
//Node 3
//Node 4
//Node 5
//Node 6
//Updated Node 7
//Node 8
//Node 9
//Node 10
//
//Delete Node:
//Node 1
//Node 2
//Node 3
//Node 4
//Node 5
//Node 6
//Updated Node 7
//Node 8
//Node 9
//
//Insert Node at Position:
//Node 1
//Node 2
//Node 3
//Node 4
//New Node
//Node 5
//Node 6
//Updated Node 7
//Node 8
//Node 9
//
//Reverse Linked List:
//Node 9
//Node 8
//Updated Node 7
//Node 6
//Node 5
//New Node
//Node 4
//Node 3
//Node 2
//Node 1