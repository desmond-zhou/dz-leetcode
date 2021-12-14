/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    final LinkedList<NestedInteger> stack;
        
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
    
    private void advance() {
        NestedInteger next = stack.peek();
        while (next != null && !next.isInteger()) {
            next = stack.pop();
            for (int i = next.getList().size() - 1; i >= 0; i--) {
                stack.push(next.getList().get(i));
            }
            next = stack.peek();
        }
    }

    @Override
    public Integer next() {
        advance();
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        advance();
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */