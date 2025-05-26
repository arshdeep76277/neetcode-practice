import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

// Imports not needed when submitting challenges

class TopKFrequentElements {

    public class countComparator implements Comparator<List<Integer>>{
        public int compare(List<Integer> a,List<Integer> b){
            return b.get(0)-a.get(0);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<List<Integer>> pq=new PriorityQueue<List<Integer>>(new countComparator());
        Arrays.sort(nums);
        int currentCount=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                pq.add(new ArrayList<Integer>(Arrays.asList(currentCount,nums[i])));
                currentCount=0;
            }
            currentCount++;

            if(pq.size()>k) pq.poll();
        }

        pq.add(Arrays.asList(new Integer[]{currentCount,nums[nums.length-1]}));
        if(pq.size()>k) pq.poll();

        int[] ans=new int[k];
        int currentIndex=0;
        while(!pq.isEmpty()){
            ans[currentIndex++]=pq.poll().get(1);
        }
        return ans;
    }

    // Not needed when submitting solution
    public static void main(String args[]){
        int[] p=new int[]{1,1,1,2,2,3};  // example test case
        TopKFrequentElements s=new TopKFrequentElements();
        System.out.println(s.topKFrequent(p,2));
    }
}