package code_sys.LayerControl;

import code_sys.Aop.Pager;
import code_sys.Aop.Protector;
import code_sys.Po.Api.Result;
import code_sys.Po.Dto.query.sons.EvaluationsQueryDto;
import code_sys.Po.Entity.Evaluations;
import code_sys.LayerService.EvaluationsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论 Controller
 */
@RestController
@RequestMapping("/evaluations")
public class LayerEvaluationsController {

    @Resource
    private EvaluationsService evaluationsService;

    /**
     * 评论
     *
     * @return Result<String>
     */
    @Protector
    @PostMapping(value = "/insert")
    public Result<Object> insert(@RequestBody Evaluations evaluations) {
        return evaluationsService.insert(evaluations);
    }

    /**
     * 评论修改
     *
     * @return Result<String>
     */
    @Protector
    @PutMapping("/update")
    public Result<Void> update(@RequestBody Evaluations evaluations) {
        return evaluationsService.update(evaluations);
    }

    /**
     * 查询内容下的全部评论
     *
     * @return Result<String>
     */
    @Protector
    @GetMapping("/list/{contentId}/{contentType}")
    public Result<Object> list(@PathVariable Integer contentId,
            @PathVariable String contentType) {
        return evaluationsService.list(contentId, contentType);
    }

    /**
     * 分页查询评论
     *
     * @return Result<String>
     */
    @Pager
    @PostMapping("/query")
    public Result<Object> query(@RequestBody EvaluationsQueryDto evaluationsQueryDto) {
        return evaluationsService.query(evaluationsQueryDto);
    }

    /**
     * 批量删除评论数据
     *
     * @return Result<String>
     */
    @PostMapping("/batchDelete")
    public Result<Object> batchDelete(@RequestBody List<Integer> ids) {
        return evaluationsService.batchDelete(ids);
    }

    /**
     * 通过ID删除评论信息
     *
     * @return Result<String>
     */
    @Protector
    @DeleteMapping("/delete/{id}")
    public Result<String> delete(@PathVariable Integer id) {
        return evaluationsService.delete(id);
    }

}
