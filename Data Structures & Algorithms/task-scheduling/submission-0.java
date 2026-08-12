class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int count:freq)
        {
            if(count>0){
                maxHeap.offer(count);
            }
        }
        Queue<int[]> cooldown =new LinkedList<>();
        int time=0;
        while(!maxHeap.isEmpty()|| !cooldown.isEmpty()){
            while(!cooldown.isEmpty() && cooldown.peek()[1]<=time){
                maxHeap.offer(cooldown.poll()[0]);
            }
            if(!maxHeap.isEmpty()){
                int count=maxHeap.poll();
                count--;
                if(count>0){
                    cooldown.offer(new int[]{count,time+n+1});
                }
            }
            time++;
        }
        return time;
    }
}
