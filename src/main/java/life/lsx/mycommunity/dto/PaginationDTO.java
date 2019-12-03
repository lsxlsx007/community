package life.lsx.mycommunity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PaginationDTO
 * @Description TODO
 * @Author lsx
 * @Date 2019/12/1 21:51
 * @Version 1.0
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questionDTOS;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private boolean showPrevious;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        totalPage = 0;
        if(totalCount % size == 0){
            totalPage = totalCount / size;
        }else{
            totalPage = totalCount / size + 1;
        }
        pages.add(page);
        for(int i=1;i<=3;i++){
            if(page-i > 0){
                pages.add(0,page-i);
            }
            if(page+i <= totalPage){
                pages.add(page+i);
            }
        }
        if(page.equals(1)){
            showPrevious = false;
        }else{
            showPrevious = true;
        }
        if(page.equals(totalPage)){
            showNext = false;
        }else{
            showNext = true;
        }
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }
    }

}
