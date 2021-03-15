package ru.itmo.chizhikov.dao;
import ru.itmo.chizhikov.model.Product;
import ru.itmo.chizhikov.model.User;
import rx.Observable;

public interface Reactive {
    Observable<Boolean> registerUser(User user);

    Observable<Boolean> addProduct(Product product);

    Observable<Product> getProductsForUser(long userId);

    Observable<User> getUsers();
}
