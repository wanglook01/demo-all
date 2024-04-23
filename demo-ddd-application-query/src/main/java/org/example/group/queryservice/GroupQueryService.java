package org.example.group.queryservice;

import org.example.common.PageDTO;
import org.example.group.query.GroupPageQuery;
import org.example.group.query.GroupResDTO;

public interface GroupQueryService {

    PageDTO<GroupResDTO> getPage(GroupPageQuery pageQuery);
}
