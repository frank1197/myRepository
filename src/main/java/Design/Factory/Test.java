package Design.Factory;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-28 17:38
 **/

/**
 * @Title: interviewTest
 * @Package Design.Factory
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/28 17:38
 * @version V1.0
 */
public class Test {
    public static void main(String[] args) {
        MouseFactory hpFact = new HpMouseFactory();
        MouseFactory dellFact = new DellMouseFactory();
        Mouse hpm = hpFact.createMouse();
        Mouse dellm = dellFact.createMouse();
        hpm.sayHi();
        dellm.sayHi();
    }
}
