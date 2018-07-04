package LRU;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-07-03 10:41
 **/

/**
 * @Title: buildTree
 * @Package LRU
 * @Description: todo
 * @author yanfeng3
 * @date 2018/7/3 10:41
 * @version V1.0
 */

import java.util.LinkedHashMap;
import java.util.Map;
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
}
