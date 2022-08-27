import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class JobSequencingProblem {

    public static void main(String[] args) throws InputMismatchException, IOException, IllegalArgumentException, ParseException {

        List<Job> arraylist = new ArrayList<>();

        try {
            Scanner in = new Scanner(new File("jobs.txt"));
            String line;
            while (in.hasNext()) {
                line = in.nextLine();
                String[] words = line.split(",");
                arraylist.add(new Assignment(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR : Job.txt file is missing.");
            e.printStackTrace();
        } catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}


        System.out.println("Using Greedy Algorithm:");
        System.out.print(
                "Final job sequence following maximum marks: ");
        try {
            printJobs(GreedyMethod.sequenceJobs(arraylist, 3));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        // printJobs(GreedyMethod.sequenceJobs(arraylist, 3));

        System.out.println("\nUsing Branch And Bound Algorithm:");
        System.out.print(
                "Final job sequence following maximum marks: ");
        // printJobs(BranchAndBound.sequenceJobs());
    }

    public static void printJobs(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (list == null) {
                System.out.println("String is null");
            } else {
                System.out.print(iterator.next() + " ");
            }
        }
        System.out.println();
    }

}