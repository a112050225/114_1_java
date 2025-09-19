import java.util.Scanner;

public class ClassAverage {
    public static void main (String[]args)
    {
        Scanner input = new Scanner (System.in);

        int total = 0;
        int gradeCounter = 0;
        System.out.println("輸入完成請按ctrl-z(Window)或ctrl-d(Mac/Linux) 輸入結束");
        //println 輸出完需要的資料會換行或是打\n //print直接輸出
        while (input.hasNext())
        {
            if (input.hasNextInt()) {
            int grade = input.nextInt();//讀取成績
            total +=grade;//累積總分
            gradeCounter++;//成績計數器加1
            } else {
                System.out.println("輸入錯誤，請輸入整數成績，該筆資料已跳過。");
                input.next(); // 跳過錯誤輸入
            }
        }

        if (gradeCounter !=0)
        {double average = (double) total / gradeCounter;//計算平均值
            System.out.printf("總分:%d%n",total);//%d是整數,%n=\n換行
            System.out.printf("成績數:%d%n",gradeCounter);
            System.out.printf("平均成績:%.2f%n",average);
        } else
        {
            System.out.println("沒有輸入任何成績");
        }//End of else
    }//End of main
}//end of ClassAverage
