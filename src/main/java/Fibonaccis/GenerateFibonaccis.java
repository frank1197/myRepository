package Fibonaccis;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-04-13 17:03
 **/

/**
 * @Title: interviewTest
 * @Package Fibonaccis
 * @Description: todo
 * @author yanfeng3
 * @date 2019/4/13 17:03
 * @version V1.0
 */
public class GenerateFibonaccis {

    public static void main(String[] args) {
//        int n = 10;
//        Integer[] fib = getFibnaccis(n);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Long.toUnsignedString(fib[i]) + " ");
//        }

        System.out.println(Fibonacci(5));

    }

    private static Integer[] getFibnaccis(int n) {

        Integer[] value = new Integer[n];
        value[0] = 1;
        value[1] = 1;

        for (int i = 2; i < n; ++i) {
            value[i] = value[i - 2] + value[i - 1];
        }

        return value;
    }

    private static int Fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
