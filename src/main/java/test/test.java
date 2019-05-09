package test;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-07-02 16:32
 **/

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @Title: buildTree
 * @Package test
 * @Description: todo
 * @author yanfeng3
 * @date 2018/7/2 16:32
 * @version V1.0
 */
public class test {

    public static void main(String[] args) {

        ObjPool<Long, String> pool = new ObjPool<Long, String>(10, 2L);
        try {
            pool.exec(t -> {
                System.out.println(t);
                return t.toString();
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ObjPool<T, R> {
    final List<T> pool;
    final Semaphore sem;
    ObjPool(int size, T t) {
        pool = new Vector<T>(){};
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }
}
