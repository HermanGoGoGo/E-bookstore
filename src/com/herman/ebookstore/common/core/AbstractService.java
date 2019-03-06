package com.herman.ebookstore.common.core;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;

import com.herman.ebookstore.common.model.BaseEntity;

import tk.mybatis.mapper.entity.Condition;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */

public abstract class AbstractService<T extends BaseEntity<T>> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class 


    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }    


    public void save(T model) {
    	model.preInsert();
        mapper.insertSelective(model);
    }

    public void save(List<T> models) {
    	for(T model:models) {
    		model.preInsert();
    	}
        mapper.insertList(models);
    }
    
    @Override
    public void delete(T model) {
        mapper.delete(model);        
    }

    
    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);        
    }

    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    public void update(T model) {
    	model.preUpdate();
        mapper.updateByPrimaryKeySelective(model);
    }

    public T findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }
    
    public List<T> findList(T entity) {
        return mapper.select(entity);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }
    
}
