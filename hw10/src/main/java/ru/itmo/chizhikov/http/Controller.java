package ru.itmo.chizhikov.http;

import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

public interface Controller {
    <T> Observable<String> getResponse(HttpServerRequest<T> request);
}