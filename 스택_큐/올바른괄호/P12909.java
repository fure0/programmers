import java.util.Stack;

public class P12909 {
    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(solution(s));
    }

    static boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 여는 괄호일 경우 스택에 넣는다.
            if (c == '(') {
                stack.push(c);
            }

            // 아래는 모두 닫는 괄호 일 경우들이다.

            // 스택이 비어있는 경우. 즉, 닫는 괄호를 입력받았으나 pop할 원소가 없을 경우
            else if (stack.empty()) {
                return false;
            }
            // 그 외의 경우 stack 원소를 pop 한다.
            else {
                stack.pop();
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
