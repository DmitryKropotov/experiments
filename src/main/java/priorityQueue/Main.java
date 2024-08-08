package priorityQueue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>();
//
//        studentPriorityQueue.add(new Student(2, "Mark"));
//        studentPriorityQueue.add(new Student(4, "Joe"));
//        studentPriorityQueue.add(new Student(1, "Harry"));
//        studentPriorityQueue.add(new Student(3, "Milos"));
//        studentPriorityQueue.add(new Student(5, "John"));
//
//        Iterator it = studentPriorityQueue.iterator();
//        while (it.hasNext()) {
//            //System.out.println(it.next());
//            System.out.println(studentPriorityQueue.peek());
//        }
        System.out.println(validParentheses("{[]}"));
    }

    private static boolean validParentheses(String str) {
        Deque<Character> parentheses = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if(c=='{' || c=='(' || c=='[') {
                parentheses.add(c);
            }
            Character a = parentheses.peek();
            if(c=='}' && parentheses.element()!='{' || c==')' && parentheses.element()!='('
                    || c==']' && parentheses.element()!='[') {
                return false;
            }
            if(c=='}' && parentheses.element()=='{' || c==')' && parentheses.element()=='('
                    || c==']' && parentheses.element()=='[') {
                parentheses.pop();
            }
        }
        return parentheses.isEmpty();
    }
}
