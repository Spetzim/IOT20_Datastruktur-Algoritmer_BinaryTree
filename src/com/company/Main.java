package com.company;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(8);
        bt.insert(3);
        bt.insert(10);
        bt.insert(1);
        bt.insert(6);
        bt.insert(13);
        bt.insert(5);

        System.out.println("Inorder:");
        bt.printTreeInOrder();
        System.out.println("\nReverseOrder:");
        bt.printTreeInReverseOrder();
        System.out.println("\nPreOrder");
        bt.printTreeInPreOrder();
        System.out.println("\nPostOrder:");
        bt.printTreeInPostOrder();
        bt.delete(5);
        System.out.println("\nAfter Delete:");
        bt.printTreeInPreOrder();
        System.out.println("\n");
        int[] list  = new int[] {3,6, 65,11, 5,1};
        Sort.bubbleSort(list);
    }
}
