package life.sw.community.controller;

import life.sw.community.dto.PagenationDto;
import life.sw.community.mapper.UserMapper;
import life.sw.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "name", required=false)String name , Model model,
                        HttpServletRequest request,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "2")Integer size){
        model.addAttribute("name",name);
        PagenationDto pagenation = questionService.list(page,size);
        model.addAttribute("pagenation", pagenation);
        return "index";
    }
}
