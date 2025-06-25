import java.util.*;

public class RecordManager {
    static List<Learner> recordList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Student Management Records");
            System.out.println("1. Insert Record");
            System.out.println("2. Display All");
            System.out.println("3. Modify Record");
            System.out.println("4. Remove Record");
            System.out.println("5. Terminate");
            System.out.print("Choose an option: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    insertLearner();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    modifyLearner();
                    break;
                case 4:
                    removeLearner();
                    break;
                case 5:
                    System.out.println("Ended.");
                    break;
                default:
                    System.out.println("Please choose a valid option.");
            }

        } while (option != 5);
    }

    public static void insertLearner() {
        System.out.print("ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Score: ");
        double score = input.nextDouble();

        Learner l = new Learner(id, name, score);
        recordList.add(l);
        System.out.println("Entry added.");
    }

    public static void showAll() {
        if (recordList.isEmpty()) {
            System.out.println("No entries available.");
        } else {
            for (Learner l : recordList) {
                System.out.println(l);
            }
        }
    }

    public static void modifyLearner() {
        System.out.print("Enter ID to modify: ");
        int id = input.nextInt();
        for (Learner l : recordList) {
            if (l.getStudentId() == id) {
                input.nextLine();
                System.out.print("Updated Name: ");
                l.setFullName(input.nextLine());
                System.out.print("Updated Score: ");
                l.setScore(input.nextDouble());
                System.out.println("Record updated.");
                return;
            }
        }
        System.out.println("ID not found.");
    }

    public static void removeLearner() {
        System.out.print("Enter ID to delete: ");
        int id = input.nextInt();
        boolean deleted = recordList.removeIf(l -> l.getStudentId() == id);
        if (deleted) {
            System.out.println("Record removed.");
        } else {
            System.out.println("No matching ID found.");
        }
    }
}
