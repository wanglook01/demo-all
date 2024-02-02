package com.wanglook01.controller;

import com.wanglook01.constant.ResponseResult;
import com.wanglook01.dto.ProductDTO;
import com.wanglook01.dto.ProductQueryDTO;
import com.wanglook01.service.SkuService;
import com.wanglook01.util.IdUtil;
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

    @RequestMapping("/add")
    public ResponseResult add(@RequestBody ProductDTO dto) {
        if (dto.getSkuId() == null) {
            dto.setSkuId(IdUtil.getId());
        }
        return skuService.add(dto);
    }

    @RequestMapping("/addBatch")
    public ResponseResult addBatch(@RequestBody List<ProductDTO> dtoList) {
        for (int i = 0; i < dtoList.size(); i++) {
            if (dtoList.get(i).getSkuId() == null) {
                dtoList.get(i).setSkuId(Long.parseLong(IdUtil.getId() + "" + i));
            }
        }
        return skuService.addBatch(dtoList);
    }

    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody ProductQueryDTO dto) {
        return skuService.delete(dto);
    }

    @RequestMapping("/update")
    public ResponseResult update(@RequestBody ProductDTO dto) {
        return skuService.update(dto);
    }


    @RequestMapping("/search")
    public ResponseResult search(@RequestBody ProductQueryDTO queryDTO) {
        return skuService.search(queryDTO);
    }


}
