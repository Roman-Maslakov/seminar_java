import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Seminar4 {
    public static void main(String[] args) {
        System.out.println("Здравствуйте!");
        System.out.println("Чтобы добавить пользователя введите фамилию, имя, отчество,\n" +
                "возвраст и пол через пробел и нажмите Enter\n" +
                "Чтобы увидеть список всех добавленных пользователей введите пустую строку");
        ArrayList<String> users = new ArrayList<>();
//        users.add("Татьяна Николаевна Андросова 46 лет жен");
//        users.add("Бобкова Елена Олеговна 42 года жен");
//        users.add("Тимошенко Игорь Александрович 23 года муж");
//        users.add("Маслаков Роман Дмитриевич 22 года муж");
//        users.add("Ожегова Олеся Владимировна 20 года жен");
//        users.add("Булат Павел Владимирович 54 года муж");
        String user = Request();
        while (!user.isEmpty()){
            users.add(user);
            user = Request();
        }
        Show(users);
        System.out.println("Если хотите отсортировать по возврасту введите sort или сорт в консоль\n" +
                "Для выхода нажмите Enter");
        String sortReq = Request();
        if (sortReq.equals("sort") || sortReq.equals("сорт")) {
            //Show(Sort(users));
            //Show(SortByIndex(users));
            Show(SortBySexAndIndex(users));
        }
        System.out.println("До свидания!");
    }

    public static String Request(){
        Scanner reader = new Scanner(System.in);
        String req = reader.nextLine();
        return req;
    }

    public static void Show(ArrayList<String> arr){
        for (int i = 0; i < arr.size(); i++) {
            String[] data = arr.get(i).split(" ");
            data[1] = data[1].charAt(0) + ".";
            data[2] = data[2].charAt(0) + ".";
            for (String u: data) System.out.print(u + " ");
            System.out.println();
        }
    }

    public static ArrayList<String> SortByIndex(ArrayList<String> arr){
        String tmp;
        int minAge;
        int minIndex;
        for (int i = 0; i < arr.size() - 1; i++) {
            minAge = Integer.parseInt(arr.get(i).split(" ")[3]);
            minIndex = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (minAge > Integer.parseInt(arr.get(j).split(" ")[3])){
                    minAge = Integer.parseInt(arr.get(j).split(" ")[3]);
                    minIndex = j;
                }
            }
            if (i != minIndex){
                tmp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, tmp);
            }
        }
        return arr;
    }

    public static ArrayList<String> Sort(ArrayList<String> arr){
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split(" ")[3])
                        - Integer.parseInt(o2.split(" ")[3]);
            }
        });
        return arr;
    }

    public static ArrayList<String> SortBySexAndIndex(ArrayList<String> arr){
        ArrayList<String> maleArr = new ArrayList<>();
        ArrayList<String> femaleArr = new ArrayList<>();
        for (String person : arr) {
            if (person.split(" ")[5].equals("муж")){
                maleArr.add(person);
            } else femaleArr.add(person);
        }
        maleArr = SortByIndex(maleArr);
        femaleArr = SortByIndex(femaleArr);
        maleArr.addAll(femaleArr);
        return maleArr;
    }
}
