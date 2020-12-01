package ru.itmo.chizhikov.state;

import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.Tokenizer;

public class EndState implements State {
    @Override
    public Token createToken(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }
}