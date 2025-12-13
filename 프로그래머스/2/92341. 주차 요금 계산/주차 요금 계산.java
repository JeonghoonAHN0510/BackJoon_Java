import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int plusTime = fees[2];
        int plusFee = fees[3];
        
        // 입차 중인 차
        Map<Integer, Integer> parking = new HashMap<>();
        // 누적 요금
        Map<Integer, Integer> result = new TreeMap<>();
        
        for (String record : records){
            st = new StringTokenizer(record);
            int time = timeToMin(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            
            if (type.equals("IN")){
                parking.put(number, time);
            } else {
                int inTime = parking.remove(number);
                int diff = time - inTime;
                
                result.put(number, result.getOrDefault(number, 0) + diff);
            } // if end
        } // for end
        
        int lastTime = 23 * 60 + 59;
        for (int number : parking.keySet()){
            int inTime = parking.get(number);
            int diff = lastTime - inTime;
            result.put(number, result.getOrDefault(number, 0) + diff);
        } // for end
        
        
        int[] answer = new int[result.size()];
        int index = 0;
        
        for (int number : result.keySet()){
            int totalTime = result.get(number);
            
            if (totalTime <= defaultTime){
                answer[index++] = defaultFee;
            } else {
                int extraTime = totalTime - defaultTime;
                int extraFee = (int) Math.ceil((double) extraTime / plusTime) * plusFee;
                answer[index++] = defaultFee + extraFee;
            } // if end
        } // for end
        
        return answer;
    } // func end
    public int timeToMin(String time){
        String[] splitTime = time.split(":");
        
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    } // func end
} // class end