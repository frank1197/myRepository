package PrintABC;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-21 15:36
 **/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: interviewTest
 * @Package PrintABC
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/21 15:36
 * @version V1.0
 */
public class TestLock {

    Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();
    int no = 1;


    public void process1() {
        lock.lock();
        try {
            if (no != 1) conditionA.await();
            System.out.println("A");
            no = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void process2() {
        lock.lock();
        try {
            if (no != 2) conditionB.await();
            System.out.println("B");
            no = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void process3() {
        lock.lock();
        try {
            if (no != 3) conditionC.await();
            System.out.println("C");
            no = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestLock testLock = new TestLock();

        new Thread(()->{
            for(int i=0; i < 15;i++) {
                testLock.process1();
            }
        }).start();

        new Thread(()->{
            for(int i=0; i < 15;i++) {
                testLock.process2();
            }
        }).start();

        new Thread(()->{
            for(int i=0; i < 15;i++) {
                testLock.process3();
            }
        }).start();
    }

}
