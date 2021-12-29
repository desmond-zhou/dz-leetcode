class Route {
    int id; 
    String stationIn;
    int t;
    public Route(int id, String stationIn, int t) {
        this.id = id;
        this.stationIn = stationIn;
        this.t = t;
    }
}

class UndergroundSystem {
    HashMap<Pair<String, String>, int[]> routeTimes;
    HashMap<Integer, Route> openRoutes;
    public UndergroundSystem() {
        routeTimes = new HashMap<>();
        openRoutes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Route r = new Route(id, stationName, t);
        openRoutes.put(id, r);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Route r = openRoutes.get(id);
        int duration = t - r.t;
        Pair<String, String> trip = new Pair(r.stationIn, stationName);
        routeTimes.putIfAbsent(trip, new int[]{0, 0});
        routeTimes.compute(trip, (k, v) -> new int[]{v[0] + duration, v[1] + 1});
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String> trip = new Pair(startStation, endStation);
        int[] stat = routeTimes.get(trip);
        return (double) stat[0] / (double) stat[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */