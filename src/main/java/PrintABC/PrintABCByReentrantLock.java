package PrintABC;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-21 11:32
 **/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: interviewTest
 * @Package PrintABC
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/21 11:32
 * @version V1.0
 */
public class PrintABCByReentrantLock {
    int count = 0;
    Lock lock = new ReentrantLock();
    Condition conditionA = this.lock.newCondition();
    Condition conditionB = this.lock.newCondition();
    Condition conditionC = this.lock.newCondition();

    public class PrintA implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.print("A");
                    try {
                        conditionB.signal();  //线程b唤醒,因为a打印完应该打印b
                        conditionA.await();  //线程a进入等待队列
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
        }
    }

    public class PrintB implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.print("B");
                    try {
                        conditionC.signal();
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
        }
    }

    public class PrintC implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.println("C" + count);
                    count++;//打印完c后,count++
                    try {
                        conditionA.signal();
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
        }
    }

    public static void main(String[] args) {
        PrintABCByReentrantLock printABCD = new PrintABCByReentrantLock();
        new Thread(printABCD.new PrintA()).start();
        new Thread(printABCD.new PrintB()).start();
        new Thread(printABCD.new PrintC()).start();
    }

}
