package ru.itmo.chizhikov.visitor;

import ru.itmo.chizhikov.token.tokens.BraceToken;
import ru.itmo.chizhikov.token.tokens.NumberToken;
import ru.itmo.chizhikov.token.tokens.OperationToken;

public interface TokenVisitor {
    void visit(NumberToken token);

    void visit(BraceToken token);

    void visit(OperationToken token);
}