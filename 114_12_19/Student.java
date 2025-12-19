public class Student {
    private String name;
    private int score;
    private double gpa;

    public Student(String name, int score, double gpa) {
        this.name = name;
        this.score = score;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("%s: %d 分, GPA: %.2f", name, score, gpa);
    }
}