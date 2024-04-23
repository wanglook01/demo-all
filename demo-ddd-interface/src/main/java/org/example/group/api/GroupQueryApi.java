package org.example.group.api;

import org.example.common.PageDTO;
import org.example.common.ResponseResult;
import org.example.group.query.GroupPageQuery;
import org.example.group.query.GroupResDTO;

public interface GroupQueryApi {


    ResponseResult<PageDTO<GroupResDTO>> getPage(GroupPageQuery pageQuery);

}
