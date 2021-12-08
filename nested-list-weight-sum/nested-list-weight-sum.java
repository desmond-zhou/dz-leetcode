/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        NestedInteger newRoot = new NestedInteger(0);
        for (NestedInteger rootElement : nestedList) {
            newRoot.add(rootElement);
        }
        int sum = weightSum(newRoot, 0);
        return sum;
    }
    
    public int weightSum(NestedInteger nestedInteger, int depth) {               
       if (nestedInteger.isInteger())  {
           return nestedInteger.getInteger() * depth;  
       } else {
           int sum = 0;
           for (NestedInteger children : nestedInteger.getList()) {
               sum = sum + weightSum(children, depth + 1);
           }
           return sum;
       }
    }
}