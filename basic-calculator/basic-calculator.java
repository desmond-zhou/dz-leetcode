class Solution {
    private int evaluate(Stack<Object> stack) {
        if (stack.empty() || !(stack.peek() instanceof Integer)) {
            stack.push(0);
        }
        
        int res = (int) stack.pop(); // get left
        
        while(!stack.empty() && !((char) stack.peek() == ')')) {
            char sign = (char) stack.pop(); // get sign
        
            if (sign == '+')
                res += (int) stack.pop(); // get next
            else
                res -= (int) stack.pop();
        }
        
        return res;
    }
    public int calculate(String s) {
        Stack<Object> stack = new Stack<Object>();
        int mult = 0;
        int operand = 0;
        // reverse evaluation with stack
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                operand = (int) Math.pow(10, mult) * (int) (c - '0') + operand; //TRICK: i to s as we go.
                mult += 1;
            } else if (c != ' ') {
                if (mult != 0) {
                    stack.push(operand);
                    mult = 0;
                    operand = 0;
                } 
                
                if (c == '(') {
                    int res = evaluate(stack);
                    stack.pop();
                    stack.push(res);
                } else {
                    stack.push(c);
                }
            }
        }
        
        if (mult != 0) {
            stack.push(operand);
        }
        
        return evaluate(stack);
    }
}

//(1+(4+5+2)-3)+(6+8)