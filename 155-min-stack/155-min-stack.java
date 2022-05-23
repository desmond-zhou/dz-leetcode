class MinStack {

    private List<Integer> stack;
    private int min;
    
    public MinStack() {
        stack = new ArrayList<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.add(Integer.valueOf(val));
        if (val < min )
            min = val;
    }
    
    public void pop() {
        int current_val = this.top();
        stack.remove(stack.size()-1);
        if (current_val <= min)
        {
            min = Integer.MAX_VALUE;
            for (Integer var : stack)
            {
                min = Math.min((int)var, min);
            }
        }
    }
    
    public int top() {
        return (int)stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return min;
    }
}