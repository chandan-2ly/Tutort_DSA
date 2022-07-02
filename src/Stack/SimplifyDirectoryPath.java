package Stack;

import java.util.Objects;
import java.util.Stack;

//https://www.interviewbit.com/problems/simplify-directory-path/
public class SimplifyDirectoryPath {
    public static void main(String[] args){
        String str = "/../";
        String path = simplifyPath(str);
        System.out.println(path);
    }

    private static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strArray = path.split("/");
        for(String str : strArray){
            if(!stack.isEmpty() && Objects.equals(str, "..")){
                stack.pop();
            }
            else if(str.equals("..") || str.equals(".") || str.equals("/") || str.equals(""))
                continue;
            else stack.push(str);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            String str = stack.pop();
            result.insert(0, str + "/");
        }
        //if(result.length() == 0) return "/";
        result.insert(0, "/");
        if(result.length() > 1 && result.charAt(result.length()-1) == '/')
            result.deleteCharAt(result.length()-1);

        return result.toString();
    }
}
