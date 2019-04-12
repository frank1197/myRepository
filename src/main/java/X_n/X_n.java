package X_n;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-04-12 13:26
 **/

/**
 * @Title: x的n次方
 * @Package X_n
 * @Description: todo
 * @author yanfeng3
 * @date 2019/4/12 13:26
 * @version V1.0
 */
public class X_n {

    public static void main(String[] args) {

        int x1=power(2,5);
        System.out.println(x1);
    }

    /**
     * 第二种方法：把n转化为二进制数，扫描每个二进制位，若为0则，则直接平方，否则平方后再乘以x
     *
     * @param i
     * @param j
     * @return
     */
    private static int power1(int i, int j) {
        // TODO Auto-generated method stub
        int y = 1;
        String ab = Integer.toBinaryString(j);
        for (int a = 0; a < ab.length(); a++) {
            //	System.out.println(ab.length());
            int s = Integer.parseInt(String.valueOf(ab.charAt(a)));//char类型转化为int

            //		System.out.println(s);
            y = y * y;
            if (s == 1) {
                y = y * i;
            }
        }
        System.out.println(ab);
        return y;
    }

    /**
     * 第一种方法：采用递归的方法，假设已经知道x的m次方，则若m为偶数，则x的n次方等译(x^m)^2,否则等于x(x^m)^2
     *
     * @param i
     * @param j
     * @return
     */
    private static int power(int i, int j) {
        // TODO Auto-generated method stub
        int y = 0;
        if (j == 0) {
            y = 1;
        } else {
            y = power(i, j / 2);
            y = y * y;
            if (j % 2 != 0) {
                y = i * y;
            }
        }
        return y;
    }
}