package Design.singleton;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-28 19:54
 **/

/**
 * @Title: interviewTest
 * @Package Design.singleton
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/28 19:54
 * @version V1.0
 */
public class SingletonByDoubleCheck {

    private SingletonByDoubleCheck(){};

    private static volatile SingletonByDoubleCheck singleton = null;

    public static SingletonByDoubleCheck getSingleton() {
        if (singleton ==null) {
            synchronized (SingletonByDoubleCheck.class) {
                if (singleton == null) {
                    singleton = new SingletonByDoubleCheck();
                }
            }
        }
        return singleton;
    }
}
