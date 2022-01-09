class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        HashSet<Integer> double_sided = new HashSet<Integer>();
        
        //set to 2001 because 2000 was the cap for front[i] and backs[i], aka, im lazy
        int smallest = 2001;
        
        //creates a set of unique double sided cards
        for(int i = 0; i<fronts.length; i++){
            if(fronts[i]==backs[i]) double_sided.add(fronts[i]);
        }
        
        //finds the smallest value of any card that isn't in the set
        for(int i = 0; i<fronts.length; i++){
            if(fronts[i]<smallest && !double_sided.contains(fronts[i])) smallest = fronts[i];
            if(backs[i]<smallest && !double_sided.contains(backs[i])) smallest = backs[i];
        }
        
        //checks if smallest changed since if it did it has to be less than 2001
        if(smallest == 2001) return 0;
        else return smallest;
    }
}