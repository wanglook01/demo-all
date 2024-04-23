package org.example.query.converter;

import org.example.group.po.GroupPO;
import org.example.group.query.GroupResDTO;
import org.springframework.stereotype.Service;

@Service
public class GroupQueryConverter {

    public GroupResDTO convert(GroupPO po) {
        GroupResDTO dto = new GroupResDTO();
        dto.setId(po.getId());
        dto.setName(po.getName());
        dto.setStatus(po.getStatus());
        dto.setPersonName(po.getPersonName());
        dto.setPhone(po.getPhone());
        dto.setSaleCode(po.getSaleCode());
        return dto;
    }
}
