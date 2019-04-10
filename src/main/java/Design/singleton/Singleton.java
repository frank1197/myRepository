package Design.singleton;/**
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

    /** volatile说明：主要在于singleton = new Singleton()这句，这并非是一个原子操作。
        通过volatile保证了在一个写操作（[1-2-3]）完成之前，不会调用读操作（if (instance == null)）
     **/
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
