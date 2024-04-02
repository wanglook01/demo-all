package com.wanglook01.controller;

import com.wanglook01.constant.ResponseResult;
import com.wanglook01.dto.ProductQueryDTO;
import com.wanglook01.dto.SkuDTO;
import com.wanglook01.dto.SkuQueryDTO;
import com.wanglook01.service.SkuSearchService;
import com.wanglook01.service.SkuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Resource
    private SkuService skuService;

    @Resource
    private SkuSearchService skuSearchService;

    @RequestMapping("/add")
    public ResponseResult add(@RequestBody SkuDTO dto) {
        return skuService.add(dto);
    }

    @RequestMapping("/addBatch")
    public ResponseResult addBatch(@RequestBody List<SkuDTO> dtoList) {
        return skuService.addBatch(dtoList);
    }

    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody SkuQueryDTO dto) {
        return skuService.delete(dto);
    }

    @RequestMapping("/updateAll")
    public ResponseResult updateAll(@RequestBody SkuDTO dto) {
        return skuService.updateAll(dto);
    }

    @RequestMapping("/updateSingle")
    public ResponseResult updateSingle(@RequestBody SkuDTO dto) {
        return skuService.updateSingle(dto);
    }


    @RequestMapping("/search")
    public ResponseResult search(@RequestBody SkuQueryDTO queryDTO) {
        return skuSearchService.search(queryDTO);
    }


}
