package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/remove-comments/
public class RemoveComments {
    public static void main(String[] args){
        String[] source = {"a//*b/*/c","blank","d/*/e/*/f"};
        List<String> result = removeComment(source);
        //result = removeSingleLineComment(result);
        for(String s : result)
            System.out.println(s);
    }

    private static List<String> removeBlockLineComment(String[] source) {
        List<String> result = new ArrayList<>();
        boolean isBlock = false;
        StringBuilder temp = new StringBuilder();
        for (String s : source) {
            int j = 0;
            for (j = 0; j < s.length() - 1; j++) {
                if (!isBlock && s.charAt(j) == '/' && s.charAt(j + 1) == '*') {
                    isBlock = true;
                    j++;
                }
                else if (isBlock && s.charAt(j) == '*' && s.charAt(j + 1) == '/') {
                    isBlock = false;
                    j++;
                }
                else if(!isBlock)
                    temp.append(s.charAt(j));
            }
            if (!isBlock && j == s.length() - 1)
                temp.append(s.charAt(j));

            if (!isBlock && temp.length() != 0) {
                result.add(String.valueOf(temp));
                temp = new StringBuilder();
            }
        }
        return result;
    }

    private static List<String> removeSingleLineComment(List<String> source) {
        List<String> result = new ArrayList<>();

        for(String str : source){
            StringBuilder temp = new StringBuilder();
            int i = 0;
            for(i = 0; i < str.length() - 1; i++){
                if(str.charAt(i) == '/' && str.charAt(i+1) == '/'){
                    break;
                }
                temp.append(str.charAt(i));
            }
            if(i == str.length() - 1)
                temp.append(str.charAt(i));

            if(temp.length() != 0)
                result.add(String.valueOf(temp));
        }
        return result;
    }
    private static List<String> removeComment(String[] source) {
        List<String> result = new ArrayList<>();
        boolean isBlock = false;
        StringBuilder temp = new StringBuilder();
        for (String s : source) {
            int j = 0;
            for (j = 0; j < s.length() - 1; j++) {
                if (!isBlock && s.charAt(j) == '/' && s.charAt(j + 1) == '*') {
                    isBlock = true;
                    j++;
                }
                else if (isBlock && s.charAt(j) == '*' && s.charAt(j + 1) == '/') {
                    isBlock = false;
                    j++;
                }
                else if(!isBlock && s.charAt(j) == '/' && s.charAt(j+1) == '/'){
                    break;
                }
                else if(!isBlock)
                    temp.append(s.charAt(j));
            }
            if (!isBlock && j == s.length() - 1)
                temp.append(s.charAt(j));

            if (!isBlock && temp.length() != 0) {
                result.add(String.valueOf(temp));
                temp = new StringBuilder();
            }
        }
        return result;
    }
}
