import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        // N을 i개 쓴 set을 담을 list
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < 9; i++){
            list.add(new HashSet<>());
        } // for end
        
        list.get(1).add(N);
        
        for (int i = 2; i < 9; i++){
            // N, NN, NNN와 같은 숫자 만들기
            StringBuilder str = new StringBuilder();
            for (int k = 0; k < i; k++) str.append(N);
            list.get(i).add(Integer.parseInt(str.toString()));
            
            for (int k = 1; k < i; k++){
                // k개로 구성된 숫자와 i - k로 구성된 숫자의 연산 시작
                // 4개로 구성되어 있으면, 1 - 3 / 2 - 2 / 1 - 3 연산
                for (int num1 : list.get(k)){
                    for (int num2 : list.get(i - k)){
                        list.get(i).add(num1 + num2);
                        list.get(i).add(num1 - num2);
                        list.get(i).add(num1 * num2);
                        if (num2 != 0) list.get(i).add(num1 / num2);
                    } // for end
                } // for end
            } // for end
            if (list.get(i).contains(number)) return i;
        } // for end
        
        return -1;
    } // func end
} // class end