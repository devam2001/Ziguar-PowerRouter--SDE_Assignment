import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueueTask1 {
    public static int findNewIndex(List<Character> oldQueue, int currentIndex, List<Character> newQueue) {
        Map<Character, List<Integer>> memberIndices = new HashMap<>();
        for (int i = 0; i < oldQueue.size(); i++) {
            char member = oldQueue.get(i);
            if (!memberIndices.containsKey(member)) {
                memberIndices.put(member, new ArrayList<>());
            }
            memberIndices.get(member).add(i);
        }

        char currentMember = oldQueue.get(currentIndex);
        int newIndex = -1;
        List<Integer> indices = memberIndices.get(currentMember);
        for (int index : indices) {
            if (index > currentIndex) {
                newIndex = index;
                break;
            }
        }

        // If the Current Index Member is not found in the new queue,
        // find the index of the next available member
        if (newIndex == -1) {
            for (int i = currentIndex + 1; i < oldQueue.size(); i++) {
                char member = oldQueue.get(i);
                if (memberIndices.containsKey(member)) {
                    newIndex = memberIndices.get(member).get(0);
                    break;
                }
            }
        }

        return newIndex;
    }

    public static void main(String[] args) {
        List<Character> oldQueue = new ArrayList<>();
        oldQueue.add('A');
        oldQueue.add('B');
        oldQueue.add('C');
        oldQueue.add('D');
        oldQueue.add('E');
        oldQueue.add('F');
        oldQueue.add('A');
        oldQueue.add('B');
        oldQueue.add('C');
        oldQueue.add('D');
        oldQueue.add('A');
        oldQueue.add('B');
        oldQueue.add('C');
        oldQueue.add('A');
        oldQueue.add('B');
        int currentIndex = 7;

        List<Character> newQueue = new ArrayList<>();
        newQueue.add('B');
        newQueue.add('C');
        newQueue.add('E');
        newQueue.add('F');
        newQueue.add('B');
        newQueue.add('C');
        newQueue.add('B');
        newQueue.add('C');
        newQueue.add('B');

        int newIndex = findNewIndex(oldQueue, currentIndex, newQueue);
        System.out.println("New Index: " + newIndex);
    }
}
