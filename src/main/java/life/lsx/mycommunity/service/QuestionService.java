package life.lsx.mycommunity.service;

import life.lsx.mycommunity.dto.PaginationDTO;

/**
 * Demo class
 *
 * @author lsx
 * @date 2019/10/31
 */
public interface QuestionService {
    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    PaginationDTO listQuestion(Integer page, Integer size);
}
