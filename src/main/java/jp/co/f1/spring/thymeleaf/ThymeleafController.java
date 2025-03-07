package jp.co.f1.spring.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

  // 「/thymeleaf」へアクセスがあった場合
  @GetMapping("/thymeleaf")
  public ModelAndView thymeleaf(ModelAndView mav) {
    // 画面に出力するViewを指定
    mav.setViewName("thymeleaf/howto");
    // ModelとView情報を返す
    return mav;
  }

}