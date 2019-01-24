package singleton;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-01-22 18:52
 **/

/**
 * @Title: interviewTest
 * @Package singleton
 * @Description: todo
 * @author yanfeng3
 * @date 2019/1/22 18:52
 * @version V1.0
 */
public class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton(){};

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized(Singleton.class){
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
