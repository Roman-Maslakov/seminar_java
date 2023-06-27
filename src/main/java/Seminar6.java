import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Seminar6 {
    public static void main(String[] args) {
        Set set = new Set();
        for (int i = 0; i < 20; i++) set.add(new Random().nextInt(1000));
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            System.out.print(i + " ");
        }

        System.out.println("\n" + set.get(4) + "\n");

        Integer[] myArr = set.toArray();
        for (Integer i : myArr) System.out.print(i + " ");

        System.out.println("\n" + set.toString());
    }
}

class Set{
    
    private HashMap<Integer, Object> map = new HashMap<>();
    private final Object OBJ = new Object();

    public boolean add(int number) {
        return map.put(number, OBJ) == null;
    }

    public boolean delete(int number){
        return map.remove(number, OBJ);
    }

    public int size(){
        return map.size();
    }

    public boolean isEmpty(){
        return map.size() == 0;
    }

    public boolean contains(int number){
        return map.containsKey(number);
    }

    public Iterator<Integer> iterator() {
        return map.keySet().iterator();
    }

    public Integer[] toArray(){
        Integer[] arr = new Integer[map.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = (int) map.keySet().toArray()[i];
        return arr;
    }

    public int get(int index){
        return (int) map.keySet().toArray()[index];
    }

    public String toString(){
        return map.keySet().toString();
    }
}