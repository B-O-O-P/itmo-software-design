package ru.itmo.chizhikov.token;

import ru.itmo.chizhikov.visitor.TokenVisitor;

public interface Token {
    void accept(TokenVisitor visitor);
}