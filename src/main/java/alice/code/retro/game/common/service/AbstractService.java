package alice.code.retro.game.common.service;

import alice.code.retro.game.common.dao.IDao;
import alice.code.retro.game.common.domain.AbstractEntity;
import alice.code.retro.game.common.domain.Page;
import alice.code.retro.game.common.domain.Sort;

import java.util.List;

/**
 * Service通用实现
 * @author contact@liuxp.me
 */
public abstract class AbstractService implements IService {

	// Dao对象
	protected IDao iDao;

	@Override
	public <S extends AbstractEntity> S insert(S entityInsert) {
		if (entityInsert == null) {
			throw new IllegalArgumentException("参数entityInsert不能为null");
		}

		return this.iDao.insert(entityInsert);
	}

	@Override
	public <S extends AbstractEntity> Iterable<S> insert(Iterable<S> entitiesInsert) {
		if (entitiesInsert == null) {
			throw new IllegalArgumentException("参数entitiesInsert不能为null");
		}

		return this.iDao.insert(entitiesInsert);
	}

	@Override
	public <S extends AbstractEntity> int update(S entityUpdate) {
		if (entityUpdate == null) {
			throw new IllegalArgumentException("参数entityUpdate不能为null");
		} else if (entityUpdate.getId() == null) {
			throw new IllegalArgumentException("参数entityUpdate的id不能为null");
		}
		return this.iDao.update(entityUpdate);
	}

	@Override
	public <S extends AbstractEntity> int update(String statementKey, S entityUpdate) {
		if (entityUpdate == null) {
			throw new IllegalArgumentException("参数entityUpdate不能为null");
		}
		return this.iDao.update(statementKey,entityUpdate);
	}

	@Override
	public <T extends AbstractEntity> T selectOne(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("参数id不能为null");
		}
		return this.iDao.selectOne(id);
	}

	@Override
	public <T extends AbstractEntity> T selectOne(T entityQuery) {
		return this.iDao.selectOne(entityQuery);
	}

	@Override
	public <T extends AbstractEntity> T selectOne(String statementKey, T entityQuery) {
		return this.iDao.selectOne(statementKey,entityQuery);
	}

	@Override
	public <T extends AbstractEntity> List<T> selectAll() {
		return this.iDao.selectAll();
	}

	@Override
	public <T extends AbstractEntity> List<T> selectList(Iterable<Long> ids) {
		if (ids == null) {
			throw new IllegalArgumentException("参数ids不能为null");
		}
		return this.iDao.selectList(ids);
	}

	@Override
	public <T extends AbstractEntity> List<T> selectList(T entityQuery) {
		return this.iDao.selectList(entityQuery);
	}

	@Override
	public <T extends AbstractEntity> List<T> selectList(T entityQuery, Integer rowOffset, Integer rowLimit, Sort... sorts) {
		if (rowOffset == null || rowOffset < 0) {
			throw new IllegalArgumentException("参数rowOffset不能小于0");
		}
		if (rowLimit == null || rowLimit < 1) {
			throw new IllegalArgumentException("参数rowLimit不能小于1");
		}
		return this.iDao.selectList(entityQuery, rowOffset, rowLimit, sorts);
	}

	@Override
	public <T extends AbstractEntity> List<T> selectList(String statementKey, T entityQuery) {
		return this.iDao.selectList(statementKey,entityQuery);
	}

	@Override
	public <T extends AbstractEntity> List<T> selectList(String statementKey, T entityQuery, Integer rowOffset, Integer rowLimit, Sort... sorts) {
		if (rowOffset == null || rowOffset < 0) {
			throw new IllegalArgumentException("参数rowOffset不能小于0");
		}
		if (rowLimit == null || rowLimit < 1) {
			throw new IllegalArgumentException("参数rowLimit不能小于1");
		}
		return this.iDao.selectList(statementKey,entityQuery, rowOffset, rowLimit, sorts);
	}

	@Override
	public long count() {
		return this.iDao.count();
	}

	@Override
	public <T extends AbstractEntity> long count(T entityQuery) {
		return this.iDao.count(entityQuery);
	}

	@Override
	public boolean exists(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("参数id不能为null");
		}
		return this.iDao.exists(id);
	}

	@Override
	public <T extends AbstractEntity> boolean exists(T entityQuery) {
		return this.iDao.exists(entityQuery);
	}

	@Override
	public int delete(Long id) {
		return this.iDao.delete(id);
	}

	@Override
	public int delete(Iterable<Long> ids) {
		return this.iDao.delete(ids);
	}
	
	@Override
	public <T extends AbstractEntity> Page<T> selectPage(Page<T> page) {

		if (page == null) {
			throw new IllegalArgumentException("参数page不能为null");
		}

		T entityQuery = page.getParams(); // 查询条件

		int pageIndex = page.getPageIndex();
		int pageSize = page.getPageSize();

		int rowOffset = pageIndex * pageSize;
		int rowLimit = pageSize;
		Sort[] sorts = page.getSorts().toArray(new Sort[0]);

		long count = this.iDao.count(entityQuery);
		List<T> resultList = this.iDao.selectList(entityQuery, rowOffset, rowLimit, sorts);

		return new Page<T>(page.getParams(),resultList, count, pageIndex, pageSize, sorts);
	}

	@Override
	public <T extends AbstractEntity> Page<T> selectPage(String statementKey, Page<T> page) {

		if (page == null) {
			throw new IllegalArgumentException("参数page不能为null");
		}

		T entityQuery = page.getParams(); // 查询条件

		int pageIndex = page.getPageIndex();
		int pageSize = page.getPageSize();

		int rowOffset = pageIndex * pageSize;
		int rowLimit = pageSize;
		Sort[] sorts = page.getSorts().toArray(new Sort[0]);

		long count = this.iDao.count(statementKey,entityQuery);
		List<T> resultList = this.iDao.selectList(statementKey,entityQuery, rowOffset, rowLimit, sorts);

		return new Page<T>(page.getParams(),resultList, count, pageIndex, pageSize, sorts);
	}

	/**
	 * 创建一个继承抽象实体的匿名类对象
	 * 
	 * @return 数据实体
	 */
	private AbstractEntity createEntity() {
		return new AbstractEntity(){};
	}
	
}