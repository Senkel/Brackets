package com.senkel;

import java.util.Stack;

/**
 * Contains brackets balance method.
 */
public class Brackets {

    private Stack<Character> symbolStack;

    /**
     * Checks brackets balance.
     *
     * @param inputText text to check.
     */
    public void balance(String inputText) {
        symbolStack = new Stack<Character>();
        for (int index = 0; index < inputText.length(); index++) {
            char currentSymbol = inputText.charAt(index);
            switch (currentSymbol) {
                case '(':   // opening symbols
                case '[':
                case '{':
                    symbolStack.push(currentSymbol);    // push them
                    break;

                case ')':   // closing symbols
                case ']':
                case '}':
                    if (!symbolStack.isEmpty()) {   // if stack is not empty
                        char symbolStackTop = symbolStack.pop();    // pop and check
                        if ((currentSymbol == '}' && symbolStackTop != '{')
                                || (currentSymbol == ')' && symbolStackTop != '(')
                                || (currentSymbol == ']' && symbolStackTop != '[')) {
                            System.out.println("Incorrect");
                            return;
                        }
                    } else {
                        System.out.println(String.format("Extra closing bracket while parsing %s at character %s",
                                currentSymbol, index + 1));
                        return;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!symbolStack.isEmpty()) {
            System.out.println("Insufficient closing brackets after parsing the entire input text");
        } else {
            System.out.println("Brackets are balanced");
        }
    }
}
