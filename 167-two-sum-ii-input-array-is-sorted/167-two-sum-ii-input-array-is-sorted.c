int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int* result = malloc(2*sizeof(int));
    int l = 0;
    int r = numsSize - 1;
    while (l < r) {
        if (nums[l] + nums[r] > target) {
            r = r-1;
        } else if (nums[l] + nums[r] < target) {
            l = l+1;
        } else if (nums[l] + nums[r] == target) {
            *result = l + 1;
            *(result + 1) = r + 1;
            *returnSize = 2;
            return result;
        }
    }
    
    return NULL;
}


