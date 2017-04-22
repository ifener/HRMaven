package com.ken.mapper;


import java.util.List;
import java.util.Map;

/**
 * Created by it on 13/04/2017.
 */
public interface BaseMapper<T> {
    Integer add(T t);

    T selectById(Integer id);

    List<T> selectByPage(Map<String, Object> params);

    List<T> selectAll();

    Integer count(Map<String, Object> params);

    Integer update(T t);

    Integer delete(Integer id);
}
