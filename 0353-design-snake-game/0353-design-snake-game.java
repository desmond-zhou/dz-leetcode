class SnakeGame {    
    public static class Segment {
        int x;
        int y;
        public Segment(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
        @Override
        public int hashCode(){
            return List.of(x, y).hashCode();
        }
        @Override
        public boolean equals(Object other) {
            return List.of(x, y).equals(List.of(((Segment)other).x, ((Segment)other).y));
        }
    }

    int width;
    int height;
    
    ArrayList<Segment> foods = new ArrayList<Segment>();;
    int foodIndex = 0;
    LinkedList<Segment> snake = new LinkedList<>();
    Set<Segment> occupied = new HashSet<>();
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snake.add(new Segment(0, 0));
        occupied.add(new Segment(0, 0));
        for (int[] f : food) {
            foods.add(new Segment(f[0], f[1]));
        }
        System.out.println(foods.get(0));
    }
    
    public int move(String direction) {
        updateSnake(direction);
        if(!validate()) return -1;
        return foodIndex;
    }

    private void updateSnake(String direction) {
        Segment oldHead = snake.getFirst();
        int[] delta = getDelta(direction);
        Segment newHead = new Segment(oldHead.x + delta[0], oldHead.y + delta[1]);
        snake.addFirst(newHead);
        if (foodIndex < foods.size() && (newHead.x == foods.get(foodIndex).x && newHead.y == foods.get(foodIndex).y)) {
            foodIndex++;
        } else {
            Segment tail = snake.removeLast();
            occupied.remove(tail);
        }
        if (foodIndex < foods.size()) {
            System.out.println("d: " + direction + ", newHead: " + newHead + ", food: " + foods.get(foodIndex) + ", occupied: " + occupied);
        }
    }
    
    private boolean validate() {
        Segment newSeg = snake.getFirst();
        if (newSeg.x < 0 || newSeg.x >= height || newSeg.y < 0 || newSeg.y >= width) { return false;}
        if (occupied.contains(newSeg)) {
            System.out.println("occupied: " + occupied + ", newSeg: " + newSeg);
            return false;
        }
        occupied.add(newSeg);
        return true;
    }

    private int[] getDelta(String direction) {
        switch(direction) {
            case "U":
                return new int[] {-1, 0};
            case "D":
                return new int[] {1, 0};
            case "R":
                return new int[] {0, 1};
            case "L":
                return new int[] {0, -1};
        }
        throw new IllegalArgumentException("bad direction");
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */