package com.hc.service;

import com.hc.domain.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface StorageService extends IService<Storage>{

    Storage getById(Integer id);
    List<Storage> getAll();
    boolean removeById(Integer id);

}
