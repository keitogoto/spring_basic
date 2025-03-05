package jp.co.f1.spring.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    // 「/hello」へアクセスがあった場合
    @GetMapping("/hello")
    public String helloWorld() {
        // 文字列を返す
        return "Hello Spring-Boot World!!";
    }

}