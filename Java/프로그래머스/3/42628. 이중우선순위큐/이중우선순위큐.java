import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> valueCnt = new HashMap<>();
        int size = 0;

        for (String op : operations) {
            String[] s = op.split(" ");

            if (s[0].equals("I")) {
                int num = Integer.parseInt(s[1]);
                minHeap.offer(num);
                maxHeap.offer(num);
                valueCnt.put(num, valueCnt.getOrDefault(num, 0) + 1);
                size++;
            } else {
                if (size == 0) continue;

                if (s[1].equals("1")) {
                    while (valueCnt.getOrDefault(maxHeap.peek(), 0) == 0) {
                        maxHeap.poll();
                    }
                    int popNum = maxHeap.poll();
                    valueCnt.put(popNum, valueCnt.getOrDefault(popNum, 0) - 1);
                } else {
                    while (valueCnt.getOrDefault(minHeap.peek(), 0) == 0) {
                        minHeap.poll();
                    }
                    int popNum = minHeap.poll();
                    valueCnt.put(popNum, valueCnt.getOrDefault(popNum, 0) - 1);
                }
                size--;
            }
        }

        if (size == 0) return new int[]{0, 0};

        while (valueCnt.getOrDefault(maxHeap.peek(), 0) == 0) maxHeap.poll();
        while (valueCnt.getOrDefault(minHeap.peek(), 0) == 0) minHeap.poll();

        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}