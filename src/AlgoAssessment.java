import java.util.Scanner;

public class AlgoAssessment {
    public static void sortStudentsByMark(String[] names, int[] mark) {

        for (int i = 1; i < mark.length; i++) {
            int keyMark = mark[i];
            String keyName = names[i];
            int j = i - 1;

            while (j >= 0 && mark[j] > keyMark) {
                mark[j + 1] = mark[j];
                names[j + 1] = names[j];
                j--;
            }

            mark[j + 1] = keyMark;
            names[j + 1] = keyName;
        }
    }

    public static int binarySearch(int[] marks, int targetMark) {
        int left = 0;
        int right = marks.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (marks[mid] == targetMark) {
                return mid;
            } else if (marks[mid] < targetMark) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] studentNames = {"Alice", "John", "Maria", "David", "Sophia", "Liam", "Olivia", "Ethan", "Emma", "Noah"};
        int[] studentMarks = {95, 89, 86, 92, 78, 88, 91, 84, 90, 87};

        System.out.println("Student marks (unsorted):");
        for (int i = 0; i < studentMarks.length; i++){
            System.out.println(studentNames[i] + " - " + studentMarks[i]);
        }

        sortStudentsByMark(studentNames, studentMarks);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Students sorted by marks (descending):");
        for (int i  = studentMarks.length - 1; i >= 0; i--) {
            System.out.println(studentNames[i] + " - " + studentMarks[i]);
        }

        System.out.println("Enter the mark of the student you're searching for: ");
        int target = scanner.nextInt();
        int index = binarySearch(studentMarks, target);

        if (index != -1) {
            System.out.println("Student with mark " + target + ": " + studentNames[index]);
        } else {
            System.out.println("No student with that mark was found");
        }
    }
}