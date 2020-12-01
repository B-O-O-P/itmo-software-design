package ru.itmo.chizhikov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

import ru.itmo.chizhikov.token.Token;
import ru.itmo.chizhikov.token.Tokenizer;
import ru.itmo.chizhikov.visitor.CalcVisitor;
import ru.itmo.chizhikov.visitor.ParserVisitor;
import ru.itmo.chizhikov.visitor.PrintVisitor;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Tokenizer tokenizer = new Tokenizer();
        PrintVisitor printVisitor = new PrintVisitor();
        CalcVisitor calcVisitor = new CalcVisitor();

        String rpn = reader.readLine();
        ParserVisitor parserVisitor = new ParserVisitor();

        List<Token> tokens = tokenizer.parse(rpn);
        System.out.println(printVisitor.print(tokens));

        List<Token> rpnTokens = parserVisitor.parse(tokens);
        System.out.println(printVisitor.print(rpnTokens));

        System.out.println(calcVisitor.calculate(rpnTokens));
    }
}
