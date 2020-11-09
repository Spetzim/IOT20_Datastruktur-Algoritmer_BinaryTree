package com.company;

//2. Fortsätt med implementationen av ett binärt sökträd
//        a) Lägg till metoder för att ta bort ett element, tänk på fallen:
//        1. Noden har inga barn
//        2. Noden har ett barn
//        3. Noden har två barn
//        Tänk också på att ni kan behöva hantera fallet där det som skall tas bort ligger i rot-noden.
//        b) Lägg till metoder för traversering
//        1. pre-order
//        2. in-order
//        3. reverse in-order
//        4. post-order
//        För att visa att traverseringen fungerar räcker det att skriva ut värdet i varje nod.

public class BinaryTree {
    Node root;

    class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printTreeInOrder() {
        printTreeInOrder(root);
    }

    public void printTreeInReverseOrder() {
        printTreeInReverseOrder(root);
    }

    private void printTreeInReverseOrder(Node node) {
        if (node == null) {
            return;
        }
            printTreeInReverseOrder(node.right);
            System.out.print(" " + node.value);
            printTreeInReverseOrder(node.left);
    }

    private void printTreeInOrder(Node node) {
        if (node == null) {
            return;
        }
            printTreeInOrder(node.left);
            System.out.print(" " + node.value);
            printTreeInOrder(node.right);
    }

    public void printTreeInPreOrder() {
        printTreeInPreOrder(root);
    }

    private void printTreeInPreOrder(Node node) {
        if (node == null) {
            return;
        }
            System.out.print(" " + node.value);
            printTreeInPreOrder(node.left);
            printTreeInPreOrder(node.right);
    }

    public void printTreeInPostOrder() {
        printTreeInPostOrder(root);
    }

    private void printTreeInPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printTreeInPostOrder(node.left);
        printTreeInPostOrder(node.right);
        System.out.print(" " + node.value);
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node current, int value) {
        if (current == null) {
            current = new Node(value);
            return current;
        }
        if (value < current.value){
            current.left = insertRec(current.left, value);
        } else if (value > current.value) {
            current.right = insertRec(current.right, value);
        }
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if(current == null) {
            return null;
        }
        if(value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
        else {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.right == null) {
                return current.left = deleteRecursive(current.left, current.value);
            } else if (current.left == null) {
                return current.right = deleteRecursive(current.right, current.value);
            }
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
        }
    }

    private int findSmallestValue(Node root) {
        if (root.left == null) {
            return root.value;
        }else {
            return findSmallestValue(root.left);
        }
    }
}
