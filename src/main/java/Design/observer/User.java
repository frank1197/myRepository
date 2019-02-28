package Design.observer;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-28 16:51
 **/

/**
 * @Title: interviewTest
 * @Package Design.observer
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/28 16:51
 * @version V1.0
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }

}
