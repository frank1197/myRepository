package concurrentTest;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2019-02-25 10:59
 **/

import javafx.concurrent.Worker;

import java.util.concurrent.Semaphore;

/**
 * @Title: interviewTest
 * @Package concurrentTest
 * @Description: todo
 * @author yanfeng3
 * @date 2019/2/25 10:59
 * @version V1.0
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
