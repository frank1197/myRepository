package Design.observer;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-28 16:55
 **/

/**
 * @Title: interviewTest
 * @Package Design.observer
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/28 16:55
 * @version V1.0
 */
public class Test {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

    }
}
