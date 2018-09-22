package ru.geekbrains.algorithms.lesson6_trees;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Value value;
        private Key key;
        private Node left;
        private Node right;
        private int size;

        public Node(Value value, Key key, int size) {
            this.value = value;
            this.key = key;
            this.size = size;
        }
    }

    private Node root;
    private int maxDepth;
    private int i;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (key == null) throw new IllegalArgumentException("can't be key=null");
        if (node == null) return null;
        int cmp = key.compareTo(node.key);

        if (cmp == 0) return node.value;
        else if (cmp < 0) return get(node.left, key);
        else return get(node.right, key);
    }


    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("can't be key=null");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(value, key, 1);
        int cmp = key.compareTo(node.key);
        if (cmp == 0) node.value = value;
        else if (cmp < 0) node.left = put(node.left, key, value);
        else node.right = put(node.right, key, value);

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException();
        root = deleteMin(root);
    }


    public void delete(Key key) {
        delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node tmp = node;
            node = min(node.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }


    public int depth() {
        depth(root);
        return maxDepth;

    }

    private void depth(Node node) {
        //int i=0;
        if (node != null) {
            i++;
            if (maxDepth<i) maxDepth=i;
            if (node.left != null) depth(node.left);
            if (node.right != null) depth(node.right);
        }
        i--;
    }

}
