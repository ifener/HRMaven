package com.ken.service.impl;

import com.ken.entity.Position;
import com.ken.mapper.PositionMapper;
import com.ken.service.IPositionService;
import com.ken.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by it on 08/04/2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class PositionServiceImpl implements IPositionService {

    @Autowired
    PositionMapper positionMapper;

    @Override
    public List<Position> findPosition(Position position, PageModel pageModel) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("position",position);
        params.put("pageModel",pageModel);
        Integer recordCount = positionMapper.count(params);
        pageModel.setRecordCount(recordCount);
        return positionMapper.selectByPage(params);
    }

    @Override
    public Integer removePositionById(Integer id) {
        return positionMapper.delete(id);
    }

    @Override
    public Integer addPosition(Position position) {
        return positionMapper.add(position);
    }

    @Override
    public Position findPositionById(Integer id) {
        return positionMapper.selectById(id);
    }

    @Override
    public void modifyPosition(Position position) {
        positionMapper.update(position);
    }

    @Override
    public List<Position> findAllPosition() {
        return positionMapper.selectAll();
    }
}
