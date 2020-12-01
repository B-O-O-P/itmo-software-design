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

    public int evaluate(int a, int b) {
        if (operationType.equals(TokenType.PLUS)) {
            return a + b;
        }
        if (operationType.equals(TokenType.MINUS)) {
            return a - b;
        }
        if (operationType.equals(TokenType.MUL)) {
            return a * b;
        }
        if (operationType.equals(TokenType.DIV)) {
            return a / b;
        }
        throw new IllegalStateException();
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getTokenType() {
        return operationType;
    }

    @Override
    public String toString() {
        return operationType.toString();
    }
}
