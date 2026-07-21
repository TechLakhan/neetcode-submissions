class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Pair position and speed for sorting
        Integer[][] cars = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a ,b) -> b[0] - a[0]);

        int fleet = 0;
        double maxTime = 0.0;

        for (int i = 0; i < n; i++) {
            double time = ((double) (target - cars[i][0]) /cars[i][1]);
            if (time >  maxTime) {
                fleet++;
                maxTime = time;
            }
        }
        return fleet;
    }
}
