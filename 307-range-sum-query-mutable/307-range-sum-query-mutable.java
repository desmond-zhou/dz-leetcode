class NumArray {
    int[] segmentHeap;
    int n; 
    
    public NumArray(int[] nums) {
        n = nums.length;
        segmentHeap = new int[n * 2]; // segment heap is size 2n
        for (int index = 0; index < n; index++) {
            segmentHeap[leafOf(index)] = nums[index]; 
        }
        for (int node = n - 1; node > 0; node--) { // build bottom up
            segmentHeap[node] = segmentHeap[left(node)] + segmentHeap[right(node)]; 
        }
    }
    
    public void update(int index, int val) {
        int node = leafOf(index);
        segmentHeap[node] = val;
        while (node > 0) {
            segmentHeap[parent(node)] = 
                segmentHeap[left(parent(node))] + segmentHeap[right(parent(node))];
            node = parent(node);
        }
    }
    private int parent(int node) { return node / 2; }
    private int left(int node) { return node * 2; }
    private int right(int node) { return node * 2 + 1; }
    private int leafOf(int index) { return index + n; }
    
    public int sumRange(int left, int right) {
        int leftLeaf = leafOf(left);
        int rightLeaf = leafOf(right);
        int sum = 0;
        while (leftLeaf <= rightLeaf) {
            boolean isLeftARightLeaf = leftLeaf % 2 == 1;
            boolean isRightALeftLeaf = rightLeaf % 2 == 0;
            if (isLeftARightLeaf) {
                sum += segmentHeap[leftLeaf];
                leftLeaf++; // move to the next leaf
            }
            if (isRightALeftLeaf) {
                sum += segmentHeap[rightLeaf];
                rightLeaf--; //move to the previous leaf.
            }
            leftLeaf = parent(leftLeaf);
            rightLeaf = parent(rightLeaf);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */