package ru.itmo.chizhikov.visitor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.tokens.BraceToken;
import ru.itmo.chizhikov.token.tokens.NumberToken;
import ru.itmo.chizhikov.token.tokens.OperationToken;

public class CalcVisitor implements TokenVisitor {
    private final ArrayDeque<Integer> stack = new ArrayDeque<>();

    public int calculate(List<Token> tokens) {
        if (tokens.isEmpty()) {
            return 0;
        }

        tokens.forEach(token -> token.accept(this));

        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid sequence of tokens");
        }

        return stack.pollLast();
    }

    @Override
    public void visit(NumberToken token) {
        stack.add(token.getValue());
    }

    @Override
    public void visit(BraceToken token) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(OperationToken token) {
        if (stack.size() < 2) {
            throw new IllegalStateException();
        }
        int b = stack.pollLast();
        int a = stack.pollLast();
        stack.add(token.evaluate(a, b));
    }

}