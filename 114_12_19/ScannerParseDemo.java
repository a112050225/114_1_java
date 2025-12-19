import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerParseDemo {
    public static void main(String[] args) {
        createTestFile();

        List<Student> students = new ArrayList<>();

        // 讀取並建立 Student 物件加入 list
        try (Scanner scanner = new Scanner(new File("scores.txt"))) {
            while (scanner.hasNext()) {
                String name = scanner.next();      // 讀取字串
                if (!scanner.hasNextInt()) break;
                int score = scanner.nextInt();     // 讀取整數
                if (!scanner.hasNextDouble()) break;
                double gpa = scanner.nextDouble(); // 讀取浮點數

                students.add(new Student(name, score, gpa));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 顯示到 console
        System.out.println("=== 成績資料 ===");
        for (Student s : students) {
            System.out.println(s);
        }

        // 將 list 輸出到檔案
        try (PrintWriter pw = new PrintWriter("scores_out.txt")) {
            for (Student s : students) {
                // 寫入格式：姓名 分數 GPA(兩位小數)
                pw.printf("%s %d %.2f%n", s.getName(), s.getScore(), s.getGpa());
            }
            System.out.println("已輸出到 scores_out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createTestFile() {
        try (PrintWriter pw = new PrintWriter("scores.txt")) {
            pw.println("王小明 85 3.5");
            pw.println("李小華 92 4.0");
            pw.println("張小美 78 3.2");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
