package tree;

import java.util.ArrayList;

public class BinarySearchTree<K extends Comparable, V> {

    Node<K, V> root;

    public Node<K, V> getRoot() {
        return root;
    }

    public void setRoot(Node<K, V> root) {
        this.root = root;
    }

    static class Node<K extends Comparable, V> {
        K key;
        V value;

        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        Node() {
        }

        Node(K key, V value, Node<K, V> parent) {
            this.parent = parent;
            this.key = key;
            this.value = value;
            if (key.compareTo(parent.key) < 0) {
                parent.left = this;
            } else {
                parent.right = this;
            }
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BinarySearchTree() {
        root = new Node<K, V>(null, null);
    }

    /*
    public void addNodeRecursive(final K key, final V value){
        if (root==null){
            root = new Node<K, V>(key,value);
        } else {
            addNodeRecursive(key,value,root);
        }
    }

    private Node<K, V> addNodeRecursive(final K key, final V value, Node<K, V> tree){
        if (tree==null) {
            return new Node<K, V>(key,value);
        }
        if (key.compareTo(tree.key)>0){
            if (tree.right==null) {
                tree.right = addNodeRecursive(key, value, tree.right);
                return tree.right;
            } else {
                return addNodeRecursive(key, value, tree.right);
            }
        } else if (key.compareTo(tree.key)<0) {
            if (tree.left==null) {
                tree.left = addNodeRecursive(key, value, tree.left);
                return tree.left;
            } else {
                return addNodeRecursive(key, value, tree.left);
            }
        } else {
            tree.value = value;
            return tree;
        }
    }
    */
    public void addNodeRecursive(final K key, final V value) {
        if (root.key == null) {
            root = new Node<K, V>(key, value);
        } else {
            Node<K, V> parent = findNodeRecursive(key, root);
            if (parent.key.compareTo(key) == 0) {
                parent.value = value;
            } else {
                Node<K, V> node = new Node<K, V>(key, value, parent);
            }
        }
    }

    public boolean deleteNodeRecursive(K key) {
        Node<K, V> node;
        if (root.key!=null) {
            node = findNodeRecursive(key, root);
            if (node.key != null && node.key.compareTo(key) == 0) {
                Node<K, V> replace = null;
                if (node.left != null) {
                    replace = findNodeRecursive(key, node.left);
                } else if (node.right != null) {
                    replace = findNodeRecursive(key, node.right);
                } else {
                    replace = node;
                }

                if (replace.parent != null) {
                    node.key = replace.key;
                    node.value = replace.value;
                    Node<K, V> child = getChild(replace);
                    if (replace.parent.left == replace) {
                        replace.parent.left = child;
                    } else {
                        replace.parent.right = child;
                    }
                    if (child != null) {
                        child.parent = replace.parent;
                    }
                } else {
                    replace.key = null;
                    replace.value = null;
                }
                return true;
            }
        }
        return false;
    }

    private Node<K, V> getChild(Node<K, V> parent){
        if (parent!=null){
            if (parent.left!=null){
                return parent.left;
            }
            if (parent.right!=null){
                return parent.right;
            }
        }
        return null;
    }

    private Node<K, V> findNodeRecursive(final K key, Node<K, V> parent) {
        if (parent.key.compareTo(key) > 0 && parent.left != null) {
            return findNodeRecursive(key, parent.left);
        }
        if (parent.key.compareTo(key) < 0 && parent.right != null) {
            return findNodeRecursive(key, parent.right);
        }
        return parent;
    }

    public void addNode(final K key, final V value) {
        Node<K, V> node = root;
        Node<K, V> parent = root;
        int compareResult = 0;
        boolean papa = false;
        while (node != null) {
            if (node.key == null) {
                node.value = value;
                node.key = key;
                papa = true;
                break;
            }
            compareResult = key.compareTo(node.key);
            parent = node;
            if (compareResult < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        Node<K, V> newNode = new Node<K, V>(key, value);
        if (papa) {
        } else {
            newNode.parent = parent;
            if (compareResult < 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }

    public void view() {
        if (root.key==null){
            System.out.println("Tree is empty!");
        } else {
            ArrayList<Node> nodes = new ArrayList<Node>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                Node node = nodes.get(0);
                System.out.print("Me: " + node.value.toString());
                if (node.parent != null) {
                    System.out.println(", parent: " + node.parent.value.toString());
                } else {
                    System.out.println();
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                nodes.remove(node);
            }
        }
    }

    public void deleteNode(K key) {
        Node<K, V> node = root;
        Node<K, V> leaf = root;
        Node<K, V> parent = root;

        while (node != null) {
            int cr = key.compareTo(node.key);
            if (cr == 0) {
                break;
            }
            //parent = node;
            node = cr < 0 ? node.left : node.right;
        }
        if (node == null) {
            return;
        }

        if (node.left != null) {
            leaf = node.left;
        } else if (node.right != null) {
            leaf = node.right;
        } else {
            if (node.parent == null) {
                node.key = null;
                node.value = null;
            } else {
                if (node.parent.left == node) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            }
            return;
        }
        parent = node;
        while (leaf != null) {
            int cr = key.compareTo(leaf.key);
            parent = leaf;
            if (cr > 0) {
                leaf = leaf.right;
            } else {
                leaf = leaf.left;
            }
        }

        //System.out.println("parent "+parent.key);
        node.key = parent.key;
        node.value = parent.value;
        if (parent.parent == null) {
            parent.key = null;
            parent.value = null;
        } else {
            if (parent.parent.left == parent) {
                parent.parent.left = null;
            } else {
                parent.parent.right = null;
            }
        }
    }

}
