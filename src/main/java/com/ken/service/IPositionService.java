package com.ken.service;

import com.ken.entity.Position;
import com.ken.util.tag.PageModel;

import java.util.List;

/**
 * Created by it on 08/04/2017.
 */
public interface IPositionService {

    List<Position> findPosition(Position position, PageModel pageModel);

    List<Position> findAllPosition();

    Integer removePositionById(Integer id);

    Integer addPosition(Position position);

    Position findPositionById(Integer id);

    void modifyPosition(Position position);
}
