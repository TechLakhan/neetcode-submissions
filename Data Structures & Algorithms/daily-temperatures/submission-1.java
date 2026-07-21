class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] warmDays = new int[days];

        for (int i = 0; i < days; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pop = stack.pop();
                warmDays[pop] = i - pop;
            }
            stack.push(i);
        }
        return warmDays;
    }
}
