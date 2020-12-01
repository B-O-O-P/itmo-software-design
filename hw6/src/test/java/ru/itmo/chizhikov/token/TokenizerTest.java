package ru.itmo.chizhikov.token;

import java.text.ParseException;
import org.junit.Test;

import ru.itmo.chizhikov.token.tokens.BraceToken;
import ru.itmo.chizhikov.token.tokens.NumberToken;
import ru.itmo.chizhikov.token.tokens.OperationToken;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {
    private final Tokenizer tokenizer = new Tokenizer();

    @Test
    public void testNumber() throws ParseException {
        assertThat(tokenizer.parse("123"))
                .containsExactly(
                        new NumberToken(123)
                );
    }

    @Test
    public void testOperations() throws ParseException {
        assertThat(tokenizer.parse("1 + 2 * 3"))
                .containsExactly(
                        new NumberToken(1),
                        new OperationToken(TokenType.PLUS),
                        new NumberToken(2),
                        new OperationToken(TokenType.MUL),
                        new NumberToken(3)
                );
    }

    @Test
    public void testBraces() throws ParseException {
        assertThat(tokenizer.parse("(1 + 2)"))
                .containsExactly(
                        new BraceToken(TokenType.LEFT_BRACE),
                        new NumberToken(1),
                        new OperationToken(TokenType.PLUS),
                        new NumberToken(2),
                        new BraceToken(TokenType.RIGHT_BRACE)
                );
    }

    @Test(expected = ParseException.class)
    public void testIncorrectInput() throws ParseException {
        tokenizer.parse("[1]");
    }

}