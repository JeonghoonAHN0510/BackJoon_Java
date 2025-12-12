import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    static Map<String, Integer> termMap = new HashMap<>();
    static StringTokenizer st;
    
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        
        for (String term : terms){
            st = new StringTokenizer(term);
            termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        } // for end
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i <= privacies.length; i++){
            String privacy = privacies[i - 1];
            st = new StringTokenizer(privacy);
            String join = st.nextToken();
            String term = st.nextToken();
            LocalDate joinDate = LocalDate.parse(join, formatter);
            
            int compare = todayDate.compareTo(joinDate.plusMonths(termMap.get(term)));
            if (compare >= 0) answer.add(i);
        } // for end
        
        return answer;
    } // func end
} // class end