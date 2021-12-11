class Node {
    final String name;
    final int val;
    final HashMap<String, Node> children;
    
    public Node(final String name, 
                final int val) {
        this.name = name;
        this.children = new HashMap<String, Node>();
        this.val = val;
    }
}

class FileSystem {
    public Node root;
    
    public FileSystem() {
        root = new Node("root", 0);
    }
    
    public Node getNode(String[] tokens) {
        Node node = root;
        for (int i = 0; i < tokens.length; i++) {
            if (node == null) return null;
            node = node.children.get(tokens[i]);
        }
        return node;
    }
    
    public boolean createPath(String path, int value) {
        final String[] rawT = path.split("/");
        final String[] tokens = Arrays.copyOfRange(rawT, 1, rawT.length - 1);
        final String leave = rawT[rawT.length - 1];
        
        final Node parent = getNode(tokens);
        if (parent == null) return false; //noparent
        if (parent.children.containsKey(leave)) return false; //exist
        parent.children.put(leave, new Node(leave, value));
        return true;
    }
    
    public int get(String path) {
        final String[] rawT = path.split("/");
        final String[] tokens = Arrays.copyOfRange(rawT, 1, rawT.length);
        
        final Node target = getNode(tokens);
        if (target == null) return -1;
        return target.val; 
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */