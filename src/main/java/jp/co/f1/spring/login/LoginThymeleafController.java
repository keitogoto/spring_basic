package jp.co.f1.spring.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginThymeleafController {

    // 「/loginForm」へアクセスがあった場合
    @GetMapping("/loginForm")
    public ModelAndView loginForm(ModelAndView mav) {
        // 画面に出力するViewを指定
        mav.setViewName("login/form");
        // ModelとView情報を返す
        return mav;
    }

    // 「/login」へPOST送信された場合
    @PostMapping(value = "/login")
    // POSTデータ（必須）を受け取る
    public ModelAndView login(@RequestParam String id, @RequestParam String pass, ModelAndView mav) {
        // Viewに渡す変数をModelに格納
        mav.addObject("id", "Your ID is " + id + ".");
        mav.addObject("pass", "PASS is " + pass + ".");
        // 画面に出力するViewを指定
        mav.setViewName("login/success");
        // ModelとView情報を返す
        return mav;
    }

}