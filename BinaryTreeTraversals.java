class Node<T>{
    public T data;
    public Node<T> leftNode, rightNode;

    public Node(T data){
        this.data = data;
    }
}

public class BinaryTreeTraversals {

    // Time Complexity: O(n)
    // Space Complexity: O(h) where h is the height of the tree. h will be at least lg(n) and max n

    public static void preOrderTraversal(Node<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.leftNode);
        preOrderTraversal(root.rightNode);
    }

    public static void inOrderTraversal(Node<Integer> root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.leftNode);
        System.out.print(root.data + " ");
        inOrderTraversal(root.rightNode);
    }

    public static void postOrderTraversal(Node<Integer> root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.leftNode);
        postOrderTraversal(root.rightNode);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args){
        Node<Integer> root = new Node<>(10);
        Node<Integer> a = new Node<>(20);
        Node<Integer> b = new Node<>(30);
        Node<Integer> c = new Node<>(40);
        Node<Integer> d = new Node<>(50);

        root.leftNode = a;
        root.rightNode = b;
        b.leftNode = c;
        b.rightNode = d;

        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
    }
}
