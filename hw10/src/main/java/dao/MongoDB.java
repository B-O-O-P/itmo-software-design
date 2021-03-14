package dao;

import com.mongodb.rx.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;

import rx.Observable;

import model.Product;
import model.Currency;
import model.User;

public class MongoDB implements Reactive {
    private final MongoCollection<Document> users;
    private final MongoCollection<Document> products;

    public MongoDB(MongoCollection<Document> users, MongoCollection<Document> products) {
        this.users = users;
        this.products = products;
    }

    @Override
    public Observable<Boolean> registerUser(User user) {
        return insertToCollection(user.toDocument(), users);
    }

    public Observable<Boolean> addProduct(Product product) {
        return insertToCollection(product.toDocument(), products);
    }

    @Override
    public Observable<Product> getProductsForUser(long userId) {
        return users
                .find(Filters.eq("id", userId))
                .toObservable()
                .map(doc -> Currency.valueOf(doc.getString("currency")))
                .flatMap(userCurrency -> products
                        .find()
                        .toObservable()
                        .map(doc -> new Product(doc).convertCurrency(userCurrency)));
    }

    @Override
    public Observable<User> getUsers() {
        return users
                .find()
                .toObservable()
                .map(User::new);
    }

    private Observable<Boolean> insertToCollection(Document document, MongoCollection<Document> collection) {
        return collection
                .find(Filters.eq("id", document.getLong("id")))
                .toObservable()
                .singleOrDefault(null)
                .flatMap(foundDoc -> {
                    if (foundDoc == null) {
                        return collection
                                .insertOne(document)
                                .asObservable()
                                .isEmpty()
                                .map(f -> !f);
                    } else {
                        return Observable.just(false);
                    }
                });
    }
}
