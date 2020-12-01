package ru.itmo.chizhikov.visitor;

import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.util.Lists;
import org.junit.Test;

import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.TokenType;
import ru.itmo.chizhikov.token.tokens.BraceToken;
import ru.itmo.chizhikov.token.tokens.NumberToken;
import ru.itmo.chizhikov.token.tokens.OperationToken;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcVisitorTest {
    private final CalcVisitor calcVisitor = new CalcVisitor();

    @Test
    public void testNumber() {
        assertThat(calcVisitor.calculate(Collections.singletonList(new NumberToken(1)))).isEqualTo(1);
    }

    @Test
    public void testOperations() {
        assertThat(calcVisitor.calculate(Arrays.asList(
                new NumberToken(1),
                new NumberToken(2),
                new OperationToken(TokenType.PLUS)
        ))).isEqualTo(3);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBraces() {
        calcVisitor.calculate(Collections.singletonList(new BraceToken(TokenType.RIGHT_BRACE)));
    }

    @Test(expected = IllegalStateException.class)
    public void testWrongTokensSequence() {
        calcVisitor.calculate(Arrays.asList(
                new NumberToken(1),
                new OperationToken(TokenType.PLUS)
        ));
    }
}