package ru.itmo.chizhikov.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.Tokenizer;

@Getter
@Setter
@AllArgsConstructor
public class ErrorState implements State {
    private final String message;

    @Override
    public Token createToken(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }
}