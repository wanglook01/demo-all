package org.example.aggregate.group.domainservice;

import org.example.aggregate.group.entity.GroupDO;

public interface GroupFactory {

    GroupDO create(Object input);
}
