import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, (o1, o2) -> {
            String[] file1 = splitFileName(o1);
            String[] file2 = splitFileName(o2);
            
            int headCompare = file1[0].compareTo(file2[0]);
            
            if (headCompare == 0){
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);
                
                return num1 - num2;
            } else {
                return headCompare;
            } // if end
        }); // sort end
        
        return files;
    } // func end
    private String[] splitFileName(String file){
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        
        int index = 0;
        for (; index < file.length(); index++){
            char ch = file.charAt(index);
            if (Character.isDigit(ch)) break;
            head.append(ch);
        } // for end
        
        int numStart = index;
        for (; index < file.length(); index++){
            char ch = file.charAt(index);
            if (!Character.isDigit(ch) || index - numStart >= 5) break;
            number.append(ch);
        } // for end
        
        return new String[]{head.toString().toLowerCase(), number.toString()};
    } // func end
} // class end