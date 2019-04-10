package Design.singleton;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-28 19:43
 **/

/**
 * @Title: interviewTest
 * @Package Design.singleton
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/28 19:43
 * @version V1.0
 */
public class SingletonByStaticClass {

    private SingletonByStaticClass(){};

    private static class SingletonHolder {
      private final static SingletonByStaticClass singleton = new SingletonByStaticClass();
    }

    public static SingletonByStaticClass getInstance() {
        return SingletonHolder.singleton;
    }
}
