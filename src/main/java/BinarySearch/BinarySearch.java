package BinarySearch;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-06-29 18:07
 **/

/**
 * @Title: buildTree
 * @Package BinarySearch
 * @Description: todo
 * @author yanfeng3
 * @date 2018/6/29 18:07
 * @version V1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] sourceData = {1, 3, 4, 5, 7, 8, 11, 13, 16 };
        int result = BinarySearch(0, sourceData.length-1, 16, sourceData);
        System.out.println(result);
    }

    private static int BinarySearch(int start, int end, int target, int[] sourceData) {

        int index = (start+ end) >> 1;

        if (sourceData[index] == target) {
            return index;
        } else if (target < sourceData[index]) {
            return BinarySearch(start, end - 1, target, sourceData);
        } else if (target > sourceData[index]) {
            return BinarySearch(start + 1, end, target, sourceData);
        }

        return -1;
    }

}

