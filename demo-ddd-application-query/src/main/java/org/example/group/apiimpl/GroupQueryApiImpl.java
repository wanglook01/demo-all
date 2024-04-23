package org.example.group.apiimpl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.common.PageDTO;
import org.example.common.ResponseResult;
import org.example.group.api.GroupQueryApi;
import org.example.group.query.GroupPageQuery;
import org.example.group.query.GroupResDTO;
import org.example.group.queryservice.GroupQueryService;

import javax.annotation.Resource;

@DubboService
@Slf4j
public class GroupQueryApiImpl implements GroupQueryApi {

    @Resource
    private GroupQueryService groupQueryService;

    @Override
    public ResponseResult<PageDTO<GroupResDTO>> getPage(GroupPageQuery pageQuery) {
        PageDTO<GroupResDTO> page = groupQueryService.getPage(pageQuery);
        return ResponseResult.success(page);
    }
}
