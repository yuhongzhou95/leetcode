package com.shadow.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * 
 * @author yuhongzhou
 * 
 *
 */
public class Q844 {

    public static void main(String[] args) {
        Q844 q = new Q844();
        String S = "y#fo##f";
        String T = "y#f#o##f";
        System.out.println(q.backspaceCompare(S, T));
    }

    public boolean backspaceCompare(String S, String T) {

        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
//            if (S.charAt(i) == '#' && !s.isEmpty()) {
//                s.pop();
//            }else if(S.charAt(i) != '#'){
//                s.push(S.charAt(i));
//            }
            if(S.charAt(i) != '#'){
                s.push(S.charAt(i));  
            }else if(!s.isEmpty()){
                s.pop(); 
            }
                  
        }

        Stack<Character> t = new Stack<Character>();
        for (int i = 0; i < T.length(); i++) {
//            if (T.charAt(i) == '#' && !t.isEmpty()) {
//                t.pop();
//            }else if(T.charAt(i) != '#'){
//                t.push(T.charAt(i));
//            }
            if(T.charAt(i) != '#'){
                t.push(T.charAt(i));  
            }else if(!t.isEmpty()){
                t.pop(); 
            }
        }
        return s.equals(t);
    }
}
