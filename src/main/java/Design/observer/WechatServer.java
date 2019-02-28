package Design.observer;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-28 16:48
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: interviewTest
 * @Package Design.observer
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/28 16:48
 * @version V1.0
 */
public class WechatServer implements Observerable {

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()) {
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }


}
