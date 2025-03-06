package jp.co.f1.spring.login;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LoginParamController {

	// 「/loginParam1」へアクセスがあった場合
	@GetMapping("/loginParam1")
	// GETパラメータ（必須）を受け取る
	public String loginParam1(@RequestParam String id, @RequestParam String pass) {
		// GETパラメータが空文字だった場合
		if (id.equals("") || pass.equals("")) {
			return "ログインに失敗しました。";
		}
		return "ログインに成功しました（ID：" + id + "、PASS：" + pass + "）";
	}

}