import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Seminar3 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = GetList();
        System.out.println(myList);

        System.out.println(RemoveEven(myList) + " наш лист без четных чисел");

        System.out.println(FindMin(myList) + " минимальное значение в нашем листе");

        System.out.println(FindMax(myList) + " максимальное значение в нашем листе");

        System.out.println(FindAverage(myList) + " среднее значение в нашем листе");
    }

    public static ArrayList<Integer> GetList(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(100));
        }
        return list;
    }

    public static ArrayList<Integer> RemoveEven(ArrayList<Integer> list){
//        int size = list.size();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) % 2 == 0) {
//                list.remove(i);
//                size = list.size();
//                i--;
//            }
//        }
        ArrayList<Integer> res = new ArrayList<>(list);
        Iterator<Integer> iterator = res.iterator();
        while (iterator.hasNext()){
            if (iterator.next() % 2 == 0){
                iterator.remove();
            }
        }
        return res;
    }

    public static int FindMin(ArrayList<Integer> list){
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min){
                min = list.get(i);
            }
        }
        return min;
    }

    public static int FindMax(ArrayList<Integer> list){
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;
    }

    public static int FindAverage(ArrayList<Integer> list){
        int sum = 0;
        for (int i: list) sum += i;
        if (list.contains(sum / list.size())) return sum / list.size();
        return FindClosest(sum / list.size(), list);
    }

    public static int FindClosest(int number, ArrayList<Integer> list){
        int closest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (Math.abs(closest - number) > Math.abs(list.get(i) - number)){
                closest = list.get(i);
            }
        }
        return closest;
    }
}
