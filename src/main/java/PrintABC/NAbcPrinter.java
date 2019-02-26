package PrintABC;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-21 15:22
 **/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: interviewTest
 * @Package PrintABC
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/21 15:22
 * @version V1.0
 */
public class NAbcPrinter {

    private final Lock lock = new ReentrantLock();
    private final Condition con1 = lock.newCondition();
    private final Condition con2 = lock.newCondition();
    private final Condition con3 = lock.newCondition();
    private int no = 1;

    public void process1() {
        lock.lock();
        try {
            while (no != 1) { con1.await();}
            System.out.println(Thread.currentThread().getName() + " a");
            no = 2;
            con2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void process2() {
        lock.lock();
        try {
            while (no != 2) {con2.await();}
            System.out.println(Thread.currentThread().getName() + " b");
            no = 3;
            con3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void process3() {
        lock.lock();
        try {
            while (no != 3) {con3.await();}
            System.out.println(Thread.currentThread().getName() + " c");
            no = 1;
            con1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        NAbcPrinter p = new NAbcPrinter();
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {p.process1();}
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 15; i++)
            {p.process2();}
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 15; i++)
            {p.process3();}
        }).start();
    }
}
