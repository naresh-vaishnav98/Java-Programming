import java.util.*;

public class JobSequencing{

    public static class Job{
        int deadline;
        int profit;
        int id;

        Job(int d, int p, int id){
            this.deadline = d;
            this.profit = p;
            this.id = id;
        }
    }

    public static void main(String args[]){
        int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i = 0; i < jobInfo.length; i++){
            jobs.add(new Job(jobInfo[i][0],jobInfo[i][1],i));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        // System.out.println(jobs.get(0));

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i = 0; i < jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println(seq);
    }
}