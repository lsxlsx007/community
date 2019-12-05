package life.lsx.mycommunity.mapper;

import life.lsx.mycommunity.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Demo class
 *
 * @author lsx
 * @date 2019/10/31
 */
@Mapper
public interface QuestionMapper {
    /**
     * 新增问题
     * @param question
     */
    @Insert("insert into question(title,description,gmt_created,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreated},#{gmtModified},#{creator},#{tag})")
    void insertQuestion(Question question);

    /**
     * 分页查询
     * @param offset
     * @param size
     * @return
     */
    @Select("select * from question limit #{offset},#{size}")
    List<Question> listQuestion(@Param("offset") Integer offset, @Param("size") Integer size);

    /**
     * 获取总数
     * @return
     */
    @Select("select count(1) from question")
    Integer count();
}
