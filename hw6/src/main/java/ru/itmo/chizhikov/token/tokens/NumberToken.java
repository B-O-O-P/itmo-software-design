package ru.itmo.chizhikov.token.tokens;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.TokenType;
import ru.itmo.chizhikov.visitor.TokenVisitor;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class NumberToken implements Token {
    private final int value;

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.NUMBER;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}