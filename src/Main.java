import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 4, 5, 1, 5, 4 };
        //1
        HashMap hsFirstWay = new HashMap();
        hsFirstWay = (HashMap) countUniqueValue(arr);
        System.out.println(hsFirstWay);

        System.out.println();

        //2
        int[] arrClone = makeUnique(arr);
        HashMap hmSecondWay = new HashMap();
        for(int i = 0; i < arrClone.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++)
            if(arrClone[i] == arr[j]){
                count++;
            }
            hmSecondWay.put(arr[i], count);
        }
        System.out.println(hmSecondWay);
    }

    //Метод для первого способа
    public static Map<Integer, Long> countUniqueValue(int[] inputArray) {
        Map<Integer, Long> resultMap = new HashMap<>();
        for (Integer element : inputArray) {
            if (resultMap.containsKey(element)) {
                resultMap.put(element, resultMap.get(element) + 1L);
            } else {
                resultMap.put(element, 1L);
            }
        }
        return resultMap;
    }

    //Метод для второго способа, находим уникальные значения
    public static int[] makeUnique(int... values)
    {
        return Arrays.stream(values).distinct().toArray();
    }
}
