package cracking.coding.interview.tests;

import java.util.HashMap;
import java.util.Map;

public class StacksAndQueues {

    //    3.1 Three in One: Describe how you could use a single array to implement three stacks.
    //    Hints: #2, #12, #38, #58
    public static Integer pop(Integer[] stack, WhichStack whichStack) {
        int stackSize = stack.length / 3;

        switch (whichStack) {
            case A -> {
                return popValue(stack, 0, 0 + stackSize);
            }
            case B -> {
                return  popValue(stack,0 + stackSize, stackSize * 2);
            }
            case C -> {
                return popValue(stack,  stackSize * 2, stackSize * 3);
            }
        }
        return null;
    }

    //    3.1 Three in One: Describe how you could use a single array to implement three stacks.
    //    Hints: #2, #12, #38, #58
    private static Integer popValue(Integer[]stack,  int firtIndex, int finalIndex) {
        for(int i = finalIndex - 1; i >= firtIndex; i--) {
            if(stack[i]!= null) {
                int result = stack[i];
                stack[i] = null;
                return result;
            }
        }

        return null; // Stack is empty
    }

    //    3.1 Three in One: Describe how you could use a single array to implement three stacks.
    //    Hints: #2, #12, #38, #58

    public enum WhichStack {A, B, C}

    //    3.1 Three in One: Describe how you could use a single array to implement three stacks.
    //    Hints: #2, #12, #38, #58
    public static Integer[] threeInOne(Integer[] threeStacks, int value, WhichStack whichStack) {

        if (threeStacks.length % 3 != 0) {
            throw new RuntimeException("Array capacity must be divisble by 3");
        }

        int stackSize = threeStacks.length / 3;

        switch (whichStack) {
            case A -> {
                putValue(threeStacks, value, 0, 0 + stackSize);
                return threeStacks;
            }
            case B -> {
                putValue(threeStacks, value, 0 + stackSize, stackSize * 2);
                return threeStacks;
            }
            case C -> {
                putValue(threeStacks, value, stackSize * 2, stackSize * 3);
                return threeStacks;
            }
        }
        return null;

    }

    //    3.1 Three in One: Describe how you could use a single array to implement three stacks.
    //    Hints: #2, #12, #38, #58
    private static void putValue(Integer[] stack, int value, int firtIndex, int finalIndex) {
        for (int i = firtIndex; i < finalIndex; i++) {
            if (stack[i] == null) {
                stack[i] = value;
                return;
            }
        }
    }

}
