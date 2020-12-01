package ru.itmo.chizhikov.visitor;

import java.util.List;
import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.tokens.BraceToken;
import ru.itmo.chizhikov.token.tokens.NumberToken;
import ru.itmo.chizhikov.token.tokens.OperationToken;

public class PrintVisitor implements TokenVisitor {
    StringBuilder builder = new StringBuilder();

    public String print(List<Token> tokens) {
        tokens.forEach(token -> token.accept(this));

        String result = builder.toString();
        builder = new StringBuilder();
        return result;
    }

    @Override
    public void visit(NumberToken token) {
        print(token);
    }

    @Override
    public void visit(BraceToken token) {
        print(token);
    }

    @Override
    public void visit(OperationToken token) {
        print(token);
    }

    private void print(Token token) {
        builder.append(token).append(" ");
    }

}
