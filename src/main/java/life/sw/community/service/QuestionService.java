package life.sw.community.service;

import life.sw.community.dto.PagenationDto;
import life.sw.community.dto.QuestionDto;
import life.sw.community.mapper.QuestionMapper;
import life.sw.community.mapper.UserMapper;
import life.sw.community.model.Question;
import life.sw.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public PagenationDto list(Integer page, Integer size) {
        PagenationDto pagenationDto = new PagenationDto();
        int total = questionMapper.count();
        pagenationDto.setPagenation(total, page, size);
        if(page < 1){
            page = 1;
        }
        if(page > pagenationDto.getTotalPage()){
            page = pagenationDto.getTotalPage();
        }
        Integer offset = size * (page - 1);
        List<QuestionDto> questionDtos = new ArrayList<>();
        List<Question> questionList = questionMapper.list(offset, size);
        for(Question question : questionList){
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto );
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        pagenationDto.setQuestions(questionDtos);
        return pagenationDto;
    }
}
