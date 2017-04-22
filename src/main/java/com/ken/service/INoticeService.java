package com.ken.service;

import com.ken.entity.Notice;
import com.ken.util.tag.PageModel;

import java.util.List;

/**
 * Created by it on 08/04/2017.
 */
public interface INoticeService {
    List<Notice> findNotice(Notice notice, PageModel pageModel);

    Notice findNoticeById(Integer id);

    void modifyNotice(Notice notice);

    Integer addNotice(Notice notice);

    Integer removeNoticeById(Integer id);
}
