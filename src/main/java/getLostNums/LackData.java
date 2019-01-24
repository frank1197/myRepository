package getLostNums;

public class LackData {
    public static void main(String[] args) {
        int[] src={1,2,3,4,6,9};
        System.out.println(getRemoveNums(src,9));
    }
    private static String getRemoveNums(int[] src, int fullLength){
        String result = "";
        int[] toolArray = new int[fullLength + 1];
        toolArray[0]=1;
        for (int i = 0; i < src.length; i++) {
            int num = src[i];
            toolArray[num] = 1;
        }
        for (int i = 0; i < toolArray.length; i++) {
            int num = toolArray[i];
            if (num != 1 ) {
                result += i + ",";
            }
        }
        return result;

    }

}
