class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> s = new LinkedList<>();
        int rightIndex = 0;
        while (rightIndex < asteroids.length) {
            int right = asteroids[rightIndex];
            
            if (s.isEmpty()) {
                s.offer(right);
                rightIndex++;
                continue;
            }
            int left = s.peekLast();
            
            boolean collision = left > 0 && right <= 0 || left >= 0 && right < 0;
            boolean bothCrash = Math.abs(right) == Math.abs(left);
            boolean leftWin = Math.abs(right) < Math.abs(left);
            boolean rightWin = Math.abs(right) > Math.abs(left);
            
            if (!collision) {
                s.offer(right);
                rightIndex++;
                continue;
            } else if (bothCrash) {
                s.pollLast();
                rightIndex++;
                continue;
            } else if (leftWin) {
                rightIndex++;
                continue;
            } else if (rightWin) {
                s.pollLast();
                continue;
            }
        }
        
        int[] resultA = new int[s.size()];
        for (int i = 0; i < resultA.length; i++) {
            resultA[i] = s.pollFirst();
        }
        
        return resultA;
    }
}