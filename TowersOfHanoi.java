import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TowersOfHanoi {

    public static List<String> computerTowerOfHanoiSteps(List<Deque<Integer>> towers, int fromTower, int toTower,
                                                 int extraTower, int numOfRingsToMove, List<String> steps){
        if(numOfRingsToMove > 0){
            computerTowerOfHanoiSteps(towers, fromTower, extraTower, toTower,numOfRingsToMove - 1, steps);
            steps.add("Moving ring num " + Integer.toString(numOfRingsToMove) + " from tower " +
                    Integer.toString(fromTower) + " to tower " + Integer.toString(toTower));
            towers.get(toTower).addFirst(towers.get(fromTower).removeFirst());
            computerTowerOfHanoiSteps(towers, extraTower, toTower, fromTower, numOfRingsToMove - 1, steps);
        }
        return steps;
    }

    public static void main(String[] args){
        int towerSize = 4;
        List<String> results = new ArrayList<>();
        List<Deque<Integer>> towers = new ArrayList<>();
        for(int i=0; i<3; i++){
            Deque<Integer> deque = new LinkedList<>();
            towers.add(deque);
        }
        for(int i=0; i<towerSize; i++){
            towers.get(0).addLast(i);
        }
        computerTowerOfHanoiSteps(towers, 0, 1, 2, towerSize, results);
        for(int i=0; i<results.size(); i++){
            System.out.println(results.get(i));
        }
    }
}
