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
        Integer totalPage;
        if(total % size == 0){
            totalPage = total/size;
        }else{
            totalPage = total/size + 1;
        }
        if(page < 1){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        pagenationDto.setPagenation(totalPage, page);
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

    public PagenationDto listByUserId(Integer userId, Integer page, Integer size) {
        PagenationDto pagenationDto = new PagenationDto();
        Integer totalPage;
        int total = questionMapper.countByUserId(userId);
        if(total % size == 0){
            totalPage = total/size;
        }else{
            totalPage = total/size + 1;
        }

        if(page < 1){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        pagenationDto.setPagenation(totalPage, page);
        Integer offset = size * (page - 1);
        List<QuestionDto> questionDtos = new ArrayList<>();
        List<Question> questionList = questionMapper.listByUserId(userId, offset, size);
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

    public QuestionDto getQuestionByid(Integer id) {
        Question question = questionMapper.getQuestionByid(id);
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        User user = userMapper.findById(question.getCreator());
        questionDto.setUser(user);
        return questionDto;
    }

    public void createOrUpdate(Question question) {
        Integer id = question.getId();
        if(id == null){
            //插入
            questionMapper.create(question);
        }else{
            //更新
            questionMapper.update(question);
        }
    }
}
