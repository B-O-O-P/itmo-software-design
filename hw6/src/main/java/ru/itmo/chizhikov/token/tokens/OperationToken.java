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
public class OperationToken implements Token {
    private final TokenType operationType;

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return operationType.toString();
    }
}
