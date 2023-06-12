import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Seminar2 {
    public static void main(String[] args) throws IOException {
        Task1();
        Task2();
        StarredTask(); // строка 57
    }

    public static void Task1() {
        String sqlRequest = "select * from students where ";
        String jsonStr = "{name:Ivanov, country:Russia, city:Moscow, age:null}";
        jsonStr = jsonStr.replace("{", "");
        jsonStr = jsonStr.replace("}", "");
        String[] arr = jsonStr.split(", ");
        StringBuilder whereRequest = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String[] word = arr[i].split(":");
            if (!word[1].equals("null")) {
                whereRequest.append(word[0] + "=" + word[1] + ", ");
            }
        }
        whereRequest.setCharAt(whereRequest.length() - 2, ' ');
        System.out.println(sqlRequest + whereRequest + "\n");
    }

    public static void Task2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("jsonStr.txt"));
        String jsonStr = br.readLine();
        br.close();
        StringBuilder result = BuildStringOf(ParseJson(jsonStr)); //строка 36 и 45
        System.out.println(result);
    }

    public static String[] ParseJson(String str) {
        str = str.replace("{", "");
        str = str.replace("}", "");
        str = str.replace("\"", "");
        str = str.replace("[", "");
        str = str.replace("]", "");
        return str.split(",");
    }

    public static StringBuilder BuildStringOf(String[] data) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.length; i += 3) {
            res.append("Студент " + data[i].split(":")[1]
                    + " получил " + data[i + 1].split(":")[1]
                    + " по предмету " + data[i + 2].split(":")[1] + ".\n");
        }
        return res;
    }

    public static void StarredTask(){
        String str = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            str += (char)(new Random().nextInt(1040, 1103));
            sb.append((char)(new Random().nextInt(1040, 1103)));
            // вроде как 1040 - 1103 диапозон кириллицы в unicode
        }

        //System.out.println(str);
        long time = System.currentTimeMillis();
        str = str.replace("а", "А");
        long res = System.currentTimeMillis() - time;
        //System.out.println(str);
        System.out.println("Время замены в String в мс - " + res);

        //System.out.println(sb);
        time = System.currentTimeMillis();
        for (int i = 0; i < sb.length(); i++) { // правда не знаю как еще можно сделать
            if (sb.charAt(i) == 'а'){
                sb.setCharAt(i, 'А');
            }
        }
        res = System.currentTimeMillis() - time;
        //System.out.println(sb);
        System.out.println("Время замены в StringBuilder в мс - " + res);
    }
}
