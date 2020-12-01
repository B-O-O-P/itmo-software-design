package ru.itmo.chizhikov.state;

import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.Tokenizer;

public interface State {
    Token createToken(Tokenizer tokenizer);

    void setNextState(Tokenizer tokenizer);
}