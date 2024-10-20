import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        
        Set<Laptop> laptops = new HashSet<>(); // коллекция для множества ноутбуков

        laptops.add(new Laptop(4, 512, "black", "Windows 11")); // добавление ноутбука во множество
        laptops.add(new Laptop(6, 256, "white", "macOS"));
        laptops.add(new Laptop(8, 512, "gray", "Windows 11"));
    

        Map<Integer, String> criter = new HashMap<>(); // меню, позволяющее пользователю выбирать критерии фильтрации.
        criter.put(1, "ОЗУ");
        criter.put(2, "Память");
        criter.put(3, "Цвет");
        criter.put(4, "Операционная система");

        Scanner sc = new Scanner(System.in); // ввод с клавиатуры критерия

        Map<String, Object> criterFilters = new HashMap<>(); // для хранения выбранных критериев фильтрации и их значений

        boolean continueFiltering = true;   // !!!!!

        while (continueFiltering) {     // !!!!!!
            System.out.println("Критерий "); // выбираем критерий через сканнер
            for (Map.Entry<Integer, String> entry : criter.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue()); //возвращает набор элементов коллекции
            }
            int criteria = sc.nextInt();  // непосредственно сам выбор


            switch (criteria) {             // оператор свитч-кейс для добавления в мапу выбранного критерия
                case 1:
                    System.out.print("ОЗУ: ");
                    criterFilters.put("ozu", sc.nextInt());
                    break;
                case 2:
                    System.out.print("Память: ");
                    criterFilters.put("Memory", sc.nextInt());
                    break;
                case 3:
                    System.out.print("Цвет: ");
                    criterFilters.put("Color", sc.nextLine());
                    break;
                case 4:
                    System.out.print("Операционная система: ");
                    criterFilters.put("OS", sc.nextLine());
                    break;
                default:
                    System.out.println("Критерий отсутствует.");
            }
            System.out.print("Хотите добавить еще один критерий? (да/нет): ");
            String response = sc.nextLine();                                      // !!!!!!!!
            continueFiltering = response.equalsIgnoreCase("да");   // !!!!!!!!!!
        }    
    
        filterLaptops(laptops, criterFilters);
    }
    public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = true;                                                                  // !!!!!!!!!!!
            if (filters.containsKey("ozu") && laptop.getOzu() < (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("Memory") && laptop.getMemory() < (int) filters.get("hdd")) {
                matches = false;
            }
            if (filters.containsKey("OS") && !laptop.getOperSystem().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("Color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                matches = false;
            }
            if (matches) {
                System.out.println(laptop);
            }
        }
    }

}