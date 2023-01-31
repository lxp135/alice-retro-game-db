package alice.code.retro.game.common.util;

import alice.code.retro.game.common.domain.AbstractEntity;
import alice.code.retro.game.common.domain.Page;
import alice.code.retro.game.common.domain.PageParam;
import alice.code.retro.game.common.domain.Sort;

/**
 * 参数工具类
 */
public class ParamUtil {

    public static <T extends AbstractEntity> Page<T> buildPage(T params, PageParam pageParam) {

        // 设置合理的参数
        // 页码最小是1
        if (pageParam.getPageNum() < 1) {
            pageParam.setPageNum(1);
        }
        // 每页条数最小10，最大200
        if (pageParam.getPageSize() < 1) {
            pageParam.setPageSize(10);
        } else if (pageParam.getPageSize() > 200) {
            pageParam.setPageSize(200);
        }
        // 开始页码
        int pageIndex = pageParam.getPageNum() - 1;
        // 排序
        Sort sort = null;
        if ("desc".equalsIgnoreCase(pageParam.getSortOrder())) {
            sort = Sort.desc(pageParam.getSortName());
        } else {
            sort = Sort.asc(pageParam.getSortName());
        }
        // 创建分页对象
        return new Page<T>(params,pageIndex, pageParam.getPageSize(), sort);
    }

    public static <T extends AbstractEntity> Page<T> buildPage(T params, int pageNum, int pageSize, String sortName, String sortOrder) {

        // 设置合理的参数
        // 页码最小是1
        if (pageNum < 1) {
            pageNum = 1;
        }
        // 每页条数最小10，最大200
        if (pageSize < 1) {
            pageSize = 10;
        } else if (pageSize > 200) {
            pageSize = 200;
        }
        // 开始页码
        int pageIndex = pageNum - 1;
        // 排序
        Sort sort = null;
        if ("desc".equalsIgnoreCase(sortOrder)) {
            sort = Sort.desc(sortName);
        } else {
            sort = Sort.asc(sortName);
        }
        // 创建分页对象
        return new Page<T>(params,pageIndex, pageSize, sort);
    }

    public static <T extends AbstractEntity> Page<T> buildPage(int pageNum, int pageSize, String sortName, String sortOrder) {

        return buildPage(null,pageNum,pageSize,sortName,sortOrder);
    }

}
