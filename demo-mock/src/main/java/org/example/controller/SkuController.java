package org.example.controller;

import org.example.dto.SkuPo;
import org.example.service.SkuService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@ResponseBody
@RequestMapping("/sku")
public class SkuController {

    @Resource
    private SkuService skuService;

    @RequestMapping("/getById/{id}")
    public SkuPo getById(@PathVariable Long id) {
        return skuService.getById(id);
    }
}
