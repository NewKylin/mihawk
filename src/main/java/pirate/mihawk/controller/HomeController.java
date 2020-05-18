package pirate.mihawk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: mihawk
 * @description: 主页控制器
 * @author: buck
 * @create: 2020-05-18 21:44
 **/
@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
}
