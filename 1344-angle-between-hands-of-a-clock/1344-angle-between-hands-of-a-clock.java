class Solution {
    public double angleClock(int hour, int minutes) {
        double difference = Math.abs(hourAngle(hour, minutes) - minuteAngle(minutes));
        return Math.min(difference, 360 - difference);
    }
    
    private static double HOUR_ANGLE = 30;
    private double hourAngle(int hour, int minutes) {
        double base = calculateFractional(hour, 12, 360);
        double fraction = calculateFractional(minutes, 60, HOUR_ANGLE);
        double result = base + fraction;
        //System.out.println("hour: " + result);
        return result;
    }
    
    private double calculateFractional(double value, double total, double map) {
        return value/total * map;
    }    
    
    private double minuteAngle(int minutes) {
        double minuteAngle = calculateFractional(minutes, 60, 360);
        //System.out.println("minute: " + minuteAngle);
        return minuteAngle;
    }
}