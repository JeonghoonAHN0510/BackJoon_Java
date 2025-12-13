import java.util.*;

class Solution {
    public int solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            queue.add(s.charAt(i));
        } // for end
        
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (ischeck(new LinkedList<>(queue))) count++;
            queue.add(queue.poll());
        } // for end
        
        return count;
    } // func end
    public boolean ischeck(Queue<Character> queue){
        Stack<Character> stack = new Stack<>();
        while (!queue.isEmpty()){
            char ch = queue.poll();
            
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                
                char last = stack.pop();
                
                if (ch == ')' && last != '(') return false;
                if (ch == ']' && last != '[') return false;
                if (ch == '}' && last != '{') return false;
            } // if end
        } // while end
        return stack.isEmpty();
    } // func end
} // class end