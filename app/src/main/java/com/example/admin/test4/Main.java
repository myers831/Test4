package com.example.admin.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Admin on 10/20/2017.
 */

public class Main {
    public static Stack<Character> pbStack = new Stack<>();
    public static List<Boolean> returnList = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println(String.valueOf(checkPB("{a,b}(a,b,c)")));
        System.out.println(String.valueOf(strCopies("xyxyx", "xyx", 2)));

    }

    public static boolean checkPB(String s){

        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    pbStack.push(new Character(')'));
                    break;
                case '{':
                    pbStack.push(new Character('}'));
                    break;
                case '[':
                    pbStack.push(new Character(']'));
                    break;
                case ')':
                    if(pbStack.peek().charValue() == ')'){
                        pbStack.pop();
                    }else{
                        return false;
                    }
                    break;
                case '}':
                    if(pbStack.peek().charValue() == '}'){
                        pbStack.pop();
                    }else{
                        return false;
                    }
                    break;
                case ']':
                    if(pbStack.peek().charValue() == ']'){
                        pbStack.pop();
                    }else{
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

    public static void strCheck(String s, String sub, int cp){
        if(s.toLowerCase().contains(sub.toLowerCase()) && cp != 0){
            if(sub.charAt(0) == sub.charAt(sub.length() - 1)){
                cp--;
                strCheck(s.toLowerCase().replaceFirst(sub.toLowerCase(),String.valueOf(sub.charAt(0))), sub, cp);
            }else{
                cp--;
                strCheck(s.toLowerCase().replaceFirst(sub.toLowerCase(),""), sub, cp);
            }
        }
        if(!s.toLowerCase().contains(sub.toLowerCase()) && cp == 0){
            returnList.add(true);
        }else if (s.toLowerCase().contains(sub.toLowerCase()) && cp == 0 || !s.toLowerCase().contains(sub.toLowerCase()) && cp != 0){
            returnList.add(false);
        }
    }

    public static boolean strCopies(String s, String sub, int cp){
        if(cp < 0){
            System.out.println("No negative numbers!!!");
            return false;
        }
        strCheck(s, sub, cp);
        return returnList.get(0);
    }
}
