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
public class BraceToken implements Token {
    private final TokenType braceType;

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getTokenType() {
        return braceType;
    }

    @Override
    public String toString() {
        return braceType.toString();
    }

}