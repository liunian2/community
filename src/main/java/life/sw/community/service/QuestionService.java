package life.sw.community.service;

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

    public List<QuestionDto> list() {
        List<QuestionDto> questionDtos = new ArrayList<>();
        List<Question> questionList = questionMapper.list();
        for(Question question : questionList){
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto );
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        return questionDtos;
    }
}
