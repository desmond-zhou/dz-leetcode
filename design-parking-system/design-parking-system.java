class ParkingSystem {
    int[] capacity;
    int[] cur  = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        this.capacity = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (carType > 3) return false;
        int carI = carType - 1;
        if (cur[carI] < capacity[carI]) {
            cur[carI]++;
            return true;
        } else 
            return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */