package jp.co.f1.spring.login;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LoginParamController {

	// 「/loginParam1」へアクセスがあった場合
	@GetMapping("/loginParam1")
	// GETパラメータ（必須）を受け取る
	public String loginParam1(@RequestParam(required = false) String id, @RequestParam(required = false) String pass) {
		//GETパラメータが指定されていない場合
		if(id == null || pass == null){
			return "ログイン情報を入力してください";
		}
		// GETパラメータが空文字だった場合
		if (id.isEmpty() || pass.isEmpty()) {
			return "ログインに失敗しました。";
		}
		return "ログインに成功しました（ID：" + id + "、PASS：" + pass + "）";
	}

	//「/loginParam2」へアクセスがあったとき
	@GetMapping({"/loginParam2", "/loginParam2/{id}", "/loginParam2/{id}/{pass}"})
	// GETパラメータ(必須)を受け取る
	public String loginParam2(@PathVariable(required = false) String id, @PathVariable(required = false) String pass){
		//GETパラメータが指定されていない場合
		if(id == null || pass == null){
			return "ログイン情報を入力してください";
		}
		//GETパラメータが空文字だった場合
		if(id.isEmpty() || pass.isEmpty()){
			return "ログインに失敗しました";
		}
		return "ログインに成功しました(ID: " + id + "、PASS: " + pass + ")";
	}

}