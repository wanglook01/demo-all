package org.example.aggregate.group.repository;

import org.example.Repository;
import org.example.aggregate.group.entity.GroupDO;

public interface GroupRepository extends Repository<GroupDO, Long> {

    //继承的接口是基于的，其余的，是我们自己使用的接口
    //每个业务需要根据自己的业务场景来定义各种查询逻。

    GroupDO find(String name);

    Integer count(String name);
}
