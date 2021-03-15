package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.bson.Document;

@Data
@AllArgsConstructor
public class Product {
    private final long id;
    private final String name;
    private final Currency currency;
    private final double price;

    public Product(Document document) {
        this(
                document.getLong("id"),
                document.getString("name"),
                Currency.valueOf(document.getString("currency")),
                document.getDouble("price")
        );
    }

    public Document toDocument() {
        return new Document()
                .append("id", id)
                .append("name", name)
                .append("currency", currency.toString())
                .append("price", price);
    }

    public Product convertCurrency(Currency otherCurrency) {
        return new Product(id, name, otherCurrency, price * currency.getCourse(otherCurrency));
    }

    @Override
    public String toString() {
        return "Product {\n" +
                "  id : " + id + ",\n" +
                "  name : " + name + ",\n" +
                "  currency : " + currency + ",\n" +
                "  price : " + price + "\n" +
                "}";
    }
}