package ru.itmo.chizhikov.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.bson.Document;

@Data
@AllArgsConstructor
public class User {
    private final long id;
    private final String login;
    private final Currency currency;

    public User(Document document) {
        this(
                document.getLong("id"),
                document.getString("login"),
                Currency.valueOf(document.getString("currency"))
        );
    }

    public Document toDocument() {
        return new Document()
                .append("id", id)
                .append("login", login)
                .append("currency", currency.toString());
    }

    @Override
    public String toString() {
        return "User {\n" +
                "  id : " + id + ",\n" +
                "  login : " + login + ",\n" +
                "  currency : " + currency + "\n" +
                "}";
    }
}