package com.ken.service.impl;

import com.ken.entity.Notice;
import com.ken.mapper.NoticeMapper;
import com.ken.service.INoticeService;
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
 * Created by it on 09/04/2017.
 */
@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> findNotice(Notice notice, PageModel pageModel) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("notice",notice);
        Integer recordCount = noticeMapper.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0){
            params.put("pageModel",pageModel);
        }
        return noticeMapper.selectByPage(params);
    }

    @Override
    public Notice findNoticeById(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public void modifyNotice(Notice notice) {
        noticeMapper.update(notice);
    }

    @Override
    public Integer addNotice(Notice notice) {
        return noticeMapper.add(notice);
    }

    @Override
    public Integer removeNoticeById(Integer id) {
        return noticeMapper.delete(id);
    }
}
