import java.util.Scanner;

public class studentscoresheet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // =========================
        // 1. School Details
        // =========================
        System.out.print("Enter School Name: ");
        String schoolName = sc.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        sc.nextLine(); // clear buffer

        int n = 12; // minimum required students

        // =========================
        // 2. Arrays for Students
        // =========================
        String[] names = new String[n];
        double[] english = new double[n];
        double[] math = new double[n];
        double[] history = new double[n];
        double[] geography = new double[n];
        double[] science = new double[n];
        double[] programming = new double[n];
        double[] total = new double[n];
        char[] rank = new char[n];

        // =========================
        // Input Student Records
        // =========================
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("Name: ");
            names[i] = sc.nextLine();

            System.out.print("English: ");
            english[i] = sc.nextDouble();

            System.out.print("Math: ");
            math[i] = sc.nextDouble();

            System.out.print("History: ");
            history[i] = sc.nextDouble();

            System.out.print("Geography: ");
            geography[i] = sc.nextDouble();

            System.out.print("Science: ");
            science[i] = sc.nextDouble();

            System.out.print("Programming: ");
            programming[i] = sc.nextDouble();
            sc.nextLine(); // clear buffer

            // =========================
            // 3. Compute Total
            // =========================
            total[i] = english[i] + math[i] + history[i]
                    + geography[i] + science[i] + programming[i];

            // =========================
            // Rank / Grade
            // =========================
            if (total[i] >= 540)
                rank[i] = 'A';
            else if (total[i] >= 480)
                rank[i] = 'B';
            else if (total[i] >= 420)
                rank[i] = 'C';
            else if (total[i] >= 360)
                rank[i] = 'D';
            else
                rank[i] = 'F';
        }

        // =========================
        // 4. Class Statistics
        // =========================
        double sumEng = 0, sumMath = 0, sumHist = 0;
        double sumGeo = 0, sumSci = 0, sumProg = 0, sumTotal = 0;

        int A = 0, B = 0, C = 0, D = 0, F = 0;

        for (int i = 0; i < n; i++) {
            sumEng += english[i];
            sumMath += math[i];
            sumHist += history[i];
            sumGeo += geography[i];
            sumSci += science[i];
            sumProg += programming[i];
            sumTotal += total[i];

            switch (rank[i]) {
                case 'A': A++; break;
                case 'B': B++; break;
                case 'C': C++; break;
                case 'D': D++; break;
                case 'F': F++; break;
            }
        }

        // =========================
        // OUTPUT FORMAT
        // =========================
        System.out.println("\n-----------------------------------------------------------------------------------------------");
        System.out.println("                        School Name: " + schoolName);
        System.out.println("                            Teacher: " + teacherName);
        System.out.println("                              Grade: " + grade);
        System.out.println("                               Year: " + year);
        System.out.println("==================================================================================================");

        System.out.printf("%-15s %-8s %-8s %-9s %-11s %-10s %-13s %-10s %-6s\n",
                "Student Name", "English", "Math", "History",
                "Geography", "Science", "Programming", "Total" , "Rank");

        System.out.println("===================================================================================================");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %-8.2f %-8.2f %-9.2f %-11.2f %-10.2f %-13.2f %-10.2f %-6c\n",
                    names[i], english[i], math[i], history[i],
                    geography[i], science[i], programming[i], total[i], rank[i]);
        }

        System.out.println("--------------------------------------------------------------------------------------------------");

        System.out.printf("%-15s %-8.2f %-8.2f %-9.2f %-11.2f %-10.2f %-13.2f %-10.2f\n",
                "TOTAL",
                sumEng, sumMath, sumHist,
                sumGeo, sumSci, sumProg, sumTotal);
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.printf("%-15s %-8.2f %-8.2f %-9.2f %-11.2f %-10.2f %-13.2f %-10.2f\n",
                "AVERAGE", sumEng / n, sumMath / n, sumHist / n, sumGeo / n, sumSci / n, sumProg / n, sumTotal / n);
        System.out.println("=================================================================================================");

        System.out.println("\nRanks  A's: " + A + "  B's: " + B + "  C's: " + C +
                "  D's: " + D + "  F's: " + F);
    }
}
