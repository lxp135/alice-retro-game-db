package alice.code.retro.game.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 分页查询入参实体类
 * @author contact@liuxp.me
 */
@Getter
@Setter
public class PageParam {

	// 页码，从1开始
	private int pageNum = 1;
	// 每页显示条数
	private int pageSize = 10;
	// 排序字段
	private String sortName = "updateTime";
	// 排序方式
	private String sortOrder ="desc";


}