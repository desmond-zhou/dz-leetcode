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
    public int depthSumInverse(List<NestedInteger> nestedList) {
        NestedInteger newRoot = new NestedInteger(0);
        for(NestedInteger rootElement : nestedList) {
            newRoot.add(rootElement);
        }
        
        int maxDepth = findMaxDepth(newRoot) - 1;
        System.out.println(maxDepth);
        int sum = weightSum(newRoot, 0, maxDepth);
        return sum;
    }
    
    public int findMaxDepth(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            return 1;
        } else {
            int maxOfChildren = 1;
            for (NestedInteger children : nestedInteger.getList()) {
                maxOfChildren = Math.max(maxOfChildren, findMaxDepth(children));
            }
            return maxOfChildren + 1;
        }
    }
    
    public int weightSum(NestedInteger nestedInteger, int depth, int maxDepth) {               
       if (nestedInteger.isInteger())  {
           return nestedInteger.getInteger() * ((maxDepth - depth) + 1);  
       } else {
           int sum = 0;
           for (NestedInteger children : nestedInteger.getList()) {
               sum = sum + weightSum(children, depth + 1, maxDepth);
           }
           return sum;
       }
    }
}

