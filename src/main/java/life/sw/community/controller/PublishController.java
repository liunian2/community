package life.sw.community.controller;

import life.sw.community.dto.QuestionDto;
import life.sw.community.mapper.QuestionMapper;
import life.sw.community.mapper.UserMapper;
import life.sw.community.model.Question;
import life.sw.community.model.User;
import life.sw.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id")Integer id,Model model){
        QuestionDto question = questionService.getQuestionByid(id);
        if(question != null){
            model.addAttribute("title",question.getTitle());
            model.addAttribute("description",question.getDescription() );
            model.addAttribute("tag",question.getTag() );
            model.addAttribute("id",question.getId() );
        }
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam("title")String title,
                            @RequestParam("description")String description,
                            @RequestParam("tag")String tag,
                            @RequestParam("id")Integer id,
                            HttpServletRequest request,
                            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description );
        model.addAttribute("tag",tag );
        //model.addAttribute("id",id);
        if(title == null || "".equals(title)){
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if(description == null || "".equals(description)){
            model.addAttribute("error", "内容不能为空");
            return "publish";
        }
        if(tag == null || "".equals(tag)){
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        question.setId(id);
        questionService.createOrUpdate(question);
        return "redirect:/";
    }
}
