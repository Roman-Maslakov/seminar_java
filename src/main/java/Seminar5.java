import java.util.*;

public class Seminar5 {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
//        phoneBook.put("Лена", "89242295843");
//        phoneBook.put("Игорь", "89960822525 89996547890 89242293541 89963459090");
//        phoneBook.put("Рома", "89940604766 89242356789 89963907551");
//        phoneBook.put("Даниил", "89296475789 89997893434");
//        phoneBook.put("Саша", "89296549087 89954076589");

        AddContacts(phoneBook);

        SortedOutput(phoneBook);
    }

    public static void AddContacts(HashMap<String, String> map){
        System.out.println("Здравствуйте! Заполните телефонную книгу\n" +
                "Чтобы закрыть введите пустое поле");
        Scanner scanner = new Scanner(System.in);
        String name;
        String phone;
        do {
            System.out.println("Введите имя");
            name = scanner.nextLine();
            if (!name.isEmpty()) {
                    System.out.println("Теперь введите номер телефона");
                    phone = scanner.nextLine();
                    if (!map.containsKey(name)) map.put(name, phone);
                    else map.replace(name, map.get(name) + " " + phone);
                    System.out.println("Номер добавлен");
                }
        } while (!name.isEmpty());
        System.out.println("Завершено");
        scanner.close();
    }

    public static void SortedOutput(HashMap<String, String> map){
        String[] contacts = map.toString()
                .replace("{", "")
                .replace("}", "")
                .replace("=", " - ")
                .split(", ");
        Arrays.sort(contacts, (o1, o2) -> o2.split(" ").length - o1.split(" ").length);
        for (String contact : contacts) System.out.println(contact);
    }
}
