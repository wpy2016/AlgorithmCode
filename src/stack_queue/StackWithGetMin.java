package stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 输入描述:
 第一行输入一个整数N，表示对栈进行的操作总数。

 下面N行每行输入一个字符串S，表示操作的种类。

 如果S为"push"，则后面还有一个整数X表示向栈里压入整数X。

 如果S为"pop"，则表示弹出栈顶操作。

 如果S为"getMin"，则表示询问当前栈中的最小元素是多少。

 输出描述:
 对于每个getMin操作，输出一行表示当前栈中的最小元素是多少。

 示例1
 输入
 复制
 6
 push 3
 push 2
 push 1
 getMin
 pop
 getMin
 输出
 复制
 1
 2
 */
public class StackWithGetMin {

    static class MinStack
    {
        private Stack<Integer> stackData = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();

        public void push(Integer value)
        {
            stackData.push(value);
            if (stackMin.isEmpty())
            {
                stackMin.push(value);
                return;
            }

            value = value <= stackMin.peek() ? value : stackMin.peek();
            stackMin.push(value);
        }

        public Integer pop()
        {
            Integer value = stackData.pop();
            stackMin.pop();
            return value;
        }

        public Integer getMin()
        {
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        Scanner input=new Scanner(System.in);
        Integer num = Integer.parseInt(input.nextLine());
        while (num-- > 0)
        {
            String line = input.nextLine();
            String[] split = line.split(" ");
            switch (split[0].intern())
            {
                case "push":
                    minStack.push(Integer.parseInt(split[1]));
                    break;
                case "getMin":
                    System.out.println(minStack.getMin());
                    break;
                case "pop":
                    minStack.pop();
                    break;
                default:
                    break;
            }
        }
    }
}
