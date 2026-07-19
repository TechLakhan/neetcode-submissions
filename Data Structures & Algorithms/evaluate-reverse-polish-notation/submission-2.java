class Solution {
    public int evalRPN(String[] arr) {
        int length = arr.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (!arr[i].equals("+") && !arr[i].equals("-") && !arr[i].equals("*") && !arr[i].equals("/") ) {
                stack.push(Integer.valueOf(arr[i]));
            } else if (arr[i].equals("+")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                int result = first + second;
                stack.push(result);
            } else if (arr[i].equals("-")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                int result = second - first;
                stack.push(result);
            } else if (arr[i].equals("*")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                int result = second * first;
                stack.push(result);
            } else if (arr[i].equals("/")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                int result = second/first;
                stack.push(result);
            }
        }
        return stack.peek();
    }
}
