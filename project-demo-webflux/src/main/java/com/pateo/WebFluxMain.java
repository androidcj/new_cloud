package com.pateo;

import com.pateo.entities.User;
import com.pateo.webflux.UserHandler;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import reactor.ipc.netty.http.server.HttpServer;
import java.io.IOException;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;
/**
 * webflux启动类
 * @创建人 juncao
 * @创建时间 2019/12/12 15:04
 * @描述
 **/
public class WebFluxMain {
    public static void main(String[] args) throws IOException {

        HttpHandler httpHandler = toHttpHandler(
                route(POST("/selectStudent").and(accept(MediaType.APPLICATION_JSON_UTF8)), UserHandler::selectStudent).
                        and(route(GET("/saveStudent"), UserHandler::insertStudent)));
        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);

        HttpServer.create("localhost", 8080).newHandler(httpHandlerAdapter).block();
        System.in.read();
    }


}