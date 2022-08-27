import java.util.List;
import java.util.Arrays;

/**
 * Algorithm:
 * 1) Sort all jobs in decreasing order of profit.
 * 2) Iterate on jobs in decreasing order of profit.
 *    For each job , do the following :
 * a) Find a time slot i, such that slot is empty and i < deadline and i is greatest.
 *    Put the job in this slot and mark this slot filled.
 * b) If no such i exists, then ignore the job.
 * 
 * Time Complexity is O(n^2)
 * referenced from: https://www.geeksforgeeks.org/job-sequencing-problem/
 **/

public class GreedyMethod {

    public static List<String> sequenceJobs(List<Job> list, int numOfJobsToSequence) {
        // Sort the jobs according to decreasing order of marks
        list.sort((a, b) -> b.getMark() - a.getMark());

        // To keep track of free time slots
        boolean[] result = new boolean[numOfJobsToSequence];

        // To store resulting sequence of jobs
        String[] job = new String[numOfJobsToSequence];

        // Iterating through all given jobs
        try {
            for (Job value : list) {
                if (list.contains(null)) {
                    throw new NullPointerException("ERROR :Job.txt file data is missing.");
                } else {
                    // Find a free slot for this job starting from the last possible slot
                    for (int j = Math.min(numOfJobsToSequence - 1, value.getDeadline() - 1); j >= 0; j--) {
                        // Free slot found
                        if (!result[j]) { // If the slot is currently empty
                            result[j] = true; // Set the slot to be filled
                            job[j] = value.id; // Store the job into the resulting sequence
                            break; // Move on to the next job in the list
                        }
                    }
                }
                
            }
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

        // }catch (Exception e) {
        //     // Print message when any exception occurs
        //     System.out.println("Something went wrong.");
        // }
        return Arrays.asList(job);
    }

}