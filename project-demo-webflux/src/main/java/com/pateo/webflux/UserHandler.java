package com.pateo.webflux;

import com.pateo.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @创建人 juncao
 * @创建时间 2019/12/12 14:49
 * @描述
 **/
public class UserHandler {

    public static Mono<ServerResponse> selectStudent(ServerRequest request) {
        User user = new User();
        user.setId(1);
        user.setName("aaa");
        request.bodyToMono(User.class).subscribe(student -> BeanUtils.copyProperties(student, studentBody));
        return ok().contentType(APPLICATION_JSON_UTF8).body(fromObject(user));
    }


    public static Mono<ServerResponse> insertStudent(ServerRequest request){
        return ok().contentType(TEXT_PLAIN).body(fromObject("success"));
    }


}