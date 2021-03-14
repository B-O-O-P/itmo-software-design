package dao;
import rx.Observable;

import model.Product;
import model.User;

public interface Reactive {
    Observable<Boolean> registerUser(User user);

    Observable<Boolean> addProduct(Product product);

    Observable<Product> getProductsForUser(long userId);

    Observable<User> getUsers();
}
