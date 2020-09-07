package com.hc.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.mapper.StorageMapper;
import com.hc.domain.Storage;
import com.hc.service.StorageService;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public Storage getById(Integer id) {
        Storage storage = storageMapper.selectById(id);
        return  storage;
    }

    @Override
    public List<Storage> getAll() {
        List<Storage> storageList = storageMapper.selectList(null);
        return storageList;
    }

    @Override
    public boolean removeById(Integer id) {
        int res = storageMapper.deleteById(id);
        return res == 1 ? true : false;
    }
}
