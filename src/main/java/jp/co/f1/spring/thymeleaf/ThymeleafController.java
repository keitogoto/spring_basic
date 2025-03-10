package jp.co.f1.spring.thymeleaf;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

	// 「/thymeleaf」へアクセスがあった場合
	@GetMapping("/thymeleaf")
	public ModelAndView thymeleaf(ModelAndView mav) {
		// リンク用サンプル
		mav.addObject("user_id", 999);
		// 選択オブジェクト用サンプル
		User user = new User("神田太郎", 25);
		mav.addObject("user", user);
		//HTMLコード出力用サンプル
		mav.addObject("html", "<h3>HTMLコードを出力しました。</h3>");
		// 多項分岐用サンプル
		mav.addObject("month", 1);
		//くり返し用サンプル
		ArrayList<User> users = new ArrayList<User>();
		users.add(user);
		users.add(new User("神田次郎", 20));
		users.add(new User("神田花子", 15));
		mav.addObject("users", users);
		// 画面に出力するViewを指定
		mav.setViewName("thymeleaf/howto");
		// ModelとView情報を返す
		return mav;
	}

}

class User {
	//コンストラクタ
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//名前
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//年齢
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}