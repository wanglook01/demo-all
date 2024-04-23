package org.example.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.PageDTO;
import org.example.group.mapper.GroupMapper;
import org.example.group.po.GroupPO;
import org.example.group.query.GroupPageQuery;
import org.example.group.query.GroupResDTO;
import org.example.group.queryservice.GroupQueryService;
import org.example.query.converter.GroupQueryConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupQueryServiceImpl implements GroupQueryService {

    @Resource
    private GroupMapper groupMapper;

    @Resource
    private GroupQueryConverter groupQueryConverter;

    @Override
    public PageDTO<GroupResDTO> getPage(GroupPageQuery pageQuery) {
        Page<GroupPO> rowPage = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //queryWrapper组装查询where条件
        QueryWrapper<GroupPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", pageQuery.getName());
        //select & convert
        Page<GroupPO> page = groupMapper.selectPage(rowPage, queryWrapper);
        List<GroupResDTO> records = page.getRecords().stream().map(groupQueryConverter::convert).collect(Collectors.toList());
        return new PageDTO<>(pageQuery.getPageNum(), pageQuery.getPageSize(), page.getTotal(), records);
    }
}
