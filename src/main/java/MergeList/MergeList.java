package MergeList;/**
 * ${DESCRIPTION}
 *
 * @author yanfeng3
 * @create 2018-06-22 13:43
 **/

/**
 * @Title: buildTree
 * @Package MergeList
 * @Description: todo
 * @author yanfeng3
 * @date 2018/6/22 13:43
 * @version V1.0
 */
public class MergeList {

    public static void main(String[] args) {

        int[] firstData = {1, 4, 5, 7, 9};
        int[] secondData = {1, 2, 6, 8};

        int[] merge = mergeList(firstData, secondData);
        for (int k : merge) {
            System.out.println(k);
        }
    }

    public static int[] mergeList(int[] firstData, int[] secondData) {

        int i = 0,j = 0,k = 0;

        int[] merge = new int[firstData.length + secondData.length];

        while (i < firstData.length && j < secondData.length) {

            if (firstData[i] <= secondData[j]) {
                merge[k] = firstData[i];
                i++;
            } else {
                merge[k] = secondData[j];
                j++;
            }
            k++;
        }

        while (i < firstData.length) {
            merge[k++] = firstData[i++];
        }

        while (j < secondData.length) {
            merge[k++] = secondData[j++];
        }
        return merge;
    }
}
