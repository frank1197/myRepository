package Design.Factory;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-28 17:32
 **/

/**
 * @Title: interviewTest
 * @Package Design.Factory
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/28 17:32
 * @version V1.0
 */
public class HpMouseFactory implements MouseFactory {

    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
