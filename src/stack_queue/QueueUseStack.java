package stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 用两个栈实现队列，支持队列的基本操作。
 * 输入描述:
 * 第一行输入一个整数N，表示对队列进行的操作总数。
 *
 * 下面N行每行输入一个字符串S，表示操作的种类。
 *
 * 如果S为"add"，则后面还有一个整数X表示向队列尾部加入整数X。
 *
 * 如果S为"poll"，则表示弹出队列头部操作。
 *
 * 如果S为"peek"，则表示询问当前队列中头部元素是多少。
 * 输出描述:
 * 对于每一个为"peek"的操作，输出一行表示当前队列中头部元素是多少。
 * 示例1
 * 输入
 * 复制
 * 6
 * add 1
 * add 2
 * add 3
 * peek
 * poll
 * peek
 * 输出
 * 复制
 * 1
 * 2
 */
public class QueueUseStack {

    static class QueueStack
    {
        private Stack<Integer> stackQueue = new Stack<>();
        private Stack<Integer> stackSwap = new Stack<>();

        public void add(Integer value)
        {
            stackQueue.add(value);
        }

        public Integer poll()
        {
            return stackQueue.pop();
        }

        public Integer peek()
        {
            return stackQueue.peek();
        }
    }

    public static void main(String[] args) {
        QueueStack queueStack = new QueueStack();
        Scanner input=new Scanner(System.in);
        Integer num = Integer.parseInt(input.nextLine());
        while (num-- > 0)
        {
            String line = input.nextLine();
            String[] split = line.split(" ");
            switch (split[0].intern())
            {
                case "add":
                    queueStack.add(Integer.parseInt(split[1]));
                    break;
                case "poll":
                    queueStack.poll();
                    break;
                case "peek":
                    System.out.println(queueStack.peek());
                    break;
                default:
                    break;
            }
        }
    }
}
