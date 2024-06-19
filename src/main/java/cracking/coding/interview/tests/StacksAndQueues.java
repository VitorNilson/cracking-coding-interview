package cracking.coding.interview.tests;

import java.util.HashMap;
import java.util.Map;

public class StacksAndQueues {
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

    private static void putValue(Integer[] stack, int value, int firtIndex, int finalIndex) {
        for (int i = firtIndex; i < finalIndex; i++) {
            if (stack[i] == null) {
                stack[i] = value;
                return;
            }
        }
    }


    public static void pushThreeStack(Integer[] stack, int stackId, int val) {
        if (stack[stackId] == null) {
            stack[stackId] = val;
        } else {
            int stackSize = stack.length / 3;

            for (int i = 0; i < stackSize - 1; i++) {
                if (stack[i] != null) {
                    stack[i + 1] = stack[i];
                    stack[i] = null;
                }
            }

        }
    }
}
