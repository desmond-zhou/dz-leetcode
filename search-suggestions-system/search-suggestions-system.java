class Node {
    boolean isWord;
    char val;
    TreeMap<Character, Node> children;
    public Node(boolean isWord, char val, TreeMap<Character, Node> children) {
        this.isWord = isWord;
        this.val = val;
        this.children = children;
    }
}
class Solution {
    TreeMap<Character, Node> tries = new TreeMap<>();
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products) {
            insert(product, tries);
        }
        
        List<List<String>> result = new ArrayList<>();
        Node searchBase = null;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            
            if (i == 0) {
                searchBase = tries.get(c);
            } else if (searchBase != null) {
                searchBase = searchBase.children.get(c);
            } else {
                result.add(new ArrayList<String>());
                continue;
            }
            
            List<String> searchResult = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append(searchWord.substring(0, i));
            searchFrom(searchBase, searchResult, sb);
            result.add(searchResult);            
        }
        
        return result;
    }
    
    private void searchFrom(Node searchBase, List<String> searchResult, StringBuilder sb) {
        if (searchResult.size() >= 3 || searchBase == null) return;
        
        sb.append(searchBase.val);
        
        if (searchBase.isWord) {
            searchResult.add(sb.toString());
        }
        
        for (Character c : searchBase.children.keySet()) {
            searchFrom(searchBase.children.get(c), searchResult, sb);
        }
        
        sb.setLength(sb.length() - 1);
    }
    
    private void insert(String product, TreeMap<Character, Node> tries) {
        Node prev = null;
        for (int i = 0; i < product.length(); i++) {
            char curChar = product.charAt(i);
            TreeMap<Character, Node> prevChildren = (i == 0) ? tries : prev.children;
            if (!prevChildren.containsKey(curChar)) {
                Node newNode = new Node((i == product.length() - 1), product.charAt(i), new TreeMap<>());
                prevChildren.put(curChar, newNode);
            }
            prev = prevChildren.get(curChar);
            if (i == product.length() - 1 && !prev.isWord) prev.isWord = true; //BUG capture isWord for previously unseen.
        }

    }
}