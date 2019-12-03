package life.lsx.mycommunity.service.impl;

import life.lsx.mycommunity.dto.PaginationDTO;
import life.lsx.mycommunity.dto.QuestionDTO;
import life.lsx.mycommunity.mapper.QuestionMapper;
import life.lsx.mycommunity.mapper.UserMapper;
import life.lsx.mycommunity.model.Question;
import life.lsx.mycommunity.model.User;
import life.lsx.mycommunity.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QuestionServiceImpl
 * @Description TODO
 * @Author lsx
 * @Date 2019/12/1 16:57
 * @Version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public PaginationDTO listQuestion(Integer page, Integer size) {
        Integer offset = size * (page - 1);
        List<QuestionDTO> result = new ArrayList<>();
        List<Question> questionList = questionMapper.listQuestion(offset, size);
        PaginationDTO paginationDTO = new PaginationDTO();
        if(questionList != null && questionList.size() > 0){
            for (int i = 0; i < questionList.size(); i++) {
                User user = userMapper.findById(questionList.get(i).getCreator());
                QuestionDTO dto = new QuestionDTO();
                BeanUtils.copyProperties(questionList.get(i), dto);
                dto.setUser(user);
                result.add(dto);
            }
        }
        paginationDTO.setQuestionDTOS(result);
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);
        return paginationDTO;
    }
}
