package org.example.service;

import org.example.dto.SkuPo;
import org.example.repo.SkuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Override
    public SkuPo getById(Long id) {
        System.out.println("start...");
        SkuPo skuPo = skuMapper.selectById(id);
        System.out.println("end...");
        return skuPo;
    }
}
