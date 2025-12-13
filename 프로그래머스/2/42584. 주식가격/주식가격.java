class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++){
            int count = 1;
            int price = prices[i];
            for (int j = i + 1; j < prices.length - 1; j++){
                int current = prices[j];
                if (price <= current){
                    count++;
                } else {
                    break;
                } // if end
            } // for end
            answer[i] = count;
        } // for end
        
        answer[prices.length - 1] = 0;
        
        return answer;
    } // func end
} // class end