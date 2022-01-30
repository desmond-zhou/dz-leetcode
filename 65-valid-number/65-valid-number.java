class Solution {
    public boolean isNumber(String s) {
        String state = "EMPTY";
        for (char c : s.toCharArray()) {
            state = stateTransition(c, state);
            System.out.println("Char: " + c + " : " + state);
        }
        String end = stateTransition('#', state);
        return end == "DONE";
    }
    
    private String stateTransition(char c, String state) {
        switch (state){
            case "EMPTY":
                if (Character.isDigit(c)) return "DECIMAL_START_DIGIT";
                if (c == '+' || c == '-') return "DECIMAL_SIGN";
                if (c == '.') return "DECIMAL_DOT_START";
                return "FAIL";
            
            case "DECIMAL_START_DIGIT":
                if (c == '#') return "DONE";
                if (Character.isDigit(c)) return "DECIMAL_START_DIGIT";
                if (c == '.') return "DECIMAL_DOT_MIDDLE";
                if (c == 'e' || c == 'E') return "EXP";
                return "FAIL";
          
            case "DECIMAL_MID_DIGIT":
                if (c == '#') return "DONE";
                if (Character.isDigit(c)) return "DECIMAL_MID_DIGIT";
                if (c == 'e' || c == 'E') return "EXP";
                return "FAIL";
            
            case "DECIMAL_SIGN":
                if (Character.isDigit(c)) return "DECIMAL_START_DIGIT";
                if (c == '.') return "DECIMAL_DOT_START";
                return "FAIL";
            
            case "DECIMAL_DOT_START":
                if (Character.isDigit(c)) return "DECIMAL_MID_DIGIT";
                return "FAIL";
                
            case "DECIMAL_DOT_MIDDLE":
                if (c == '#') return "DONE";
                if (Character.isDigit(c)) return "DECIMAL_MID_DIGIT";
                if (c == 'e' || c == 'E') return "EXP";
                return "FAIL";
            
            case "EXP": 
                if (c == '+' || c == '-') return "EXP_SIGN";
                if (Character.isDigit(c)) return "EXP_DIGIT";
                return "FAIL";
                
            case "EXP_SIGN": 
                if (Character.isDigit(c)) return "EXP_DIGIT";
                return "FAIL";
                
            case "EXP_DIGIT": 
                if (c == '#') return "DONE";
                if (Character.isDigit(c)) return "EXP_DIGIT";
                return "FAIL";
        }
        return "FAIL";
    }
}