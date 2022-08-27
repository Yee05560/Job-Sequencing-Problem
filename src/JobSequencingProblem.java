import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class JobSequencingProblem {

    public static void main(String[] args) throws IOException, ParseException {

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
        } catch (NumberFormatException e) {
			System.out.println("ERROR : Job.txt file data have incorrect format");
			e.printStackTrace();
        } catch (IllegalArgumentException e) {
			System.out.println("ERROR : Argument is invalid");
			e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR :Array has been accessed with an illegal index.");
			e.printStackTrace();
        } 


        //  catch (NullPointerException e) {
		// 	System.out.println("ERROR :Job.txt file data is missing.");
		// 	e.printStackTrace();
        // }

        // catch (Exception e) {
		// 	System.out.println("ERROR");
		// 	e.printStackTrace();
		// }
        // printJobs(BranchAndBound.sequenceJobs());
    }

    public static void printJobs(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (list.contains(null)) {
                throw new NullPointerException("ERROR :Job.txt file data is missing.");
            } else {
                System.out.print(iterator.next() + " ");
            }
        }
        System.out.println();
    }

}