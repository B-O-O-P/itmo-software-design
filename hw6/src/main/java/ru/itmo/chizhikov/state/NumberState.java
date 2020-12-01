package ru.itmo.chizhikov.state;

import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.Tokenizer;
import ru.itmo.chizhikov.token.tokens.NumberToken;

public class NumberState implements State {
    @Override
    public Token createToken(Tokenizer tokenizer) {
        StringBuilder value = new StringBuilder();
        while (!tokenizer.isEndOfInput() && Character.isDigit(tokenizer.getCurrentCharacter())) {
            value.append(tokenizer.getCurrentCharacter());
            tokenizer.nextCharacter();
        }
        return new NumberToken(Integer.parseInt(value.toString()));
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        if (tokenizer.isEndOfInput()) {
            tokenizer.setState(new EndState());
        } else if (tokenizer.isOperationOrBrace()) {
            tokenizer.setState(new StartState());
        } else {
            tokenizer.setState(new ErrorState("Unexpected symbol : " + tokenizer.getCurrentCharacter()));
        }
    }
}
