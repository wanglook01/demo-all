package org.example.group.repositoryimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.aggregate.group.entity.GroupDO;
import org.example.aggregate.group.repository.GroupRepository;
import org.example.group.converter.GroupConverter;
import org.example.group.mapper.ContractMapper;
import org.example.group.mapper.GroupMapper;
import org.example.group.mapper.InvoiceConfigMapper;
import org.example.group.po.ContractPO;
import org.example.group.po.GroupPO;
import org.example.group.po.InvoiceConfigPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    @Resource
    private GroupConverter groupConverter;

    @Resource
    private GroupMapper groupMapper;

    @Resource
    private ContractMapper contractMapper;

    @Resource
    private InvoiceConfigMapper invoiceConfigMapper;

    @Override
    public GroupDO get(Long id) {
        GroupPO groupPO = groupMapper.selectById(id);
        QueryWrapper<ContractPO> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("group_id", groupPO.getId());
        wrapper1.eq("is_deleted", 0);
        List<ContractPO> contractList = contractMapper.selectList(wrapper1);
        QueryWrapper<InvoiceConfigPO> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("group_id", groupPO.getId());
        wrapper2.eq("is_deleted", 0);
        List<InvoiceConfigPO> invoiceConfigPOS = invoiceConfigMapper.selectList(wrapper2);
        //转换器
        return groupConverter.group2Do(groupPO, contractList, invoiceConfigPOS);
    }

    @Override
    public Long save(GroupDO entity) {
        GroupPO groupPO = groupConverter.group2Po(entity);
        List<ContractPO> contractPOList = entity.getContractList().stream().map(groupConverter::contract2Po).collect(Collectors.toList());
        List<InvoiceConfigPO> invoiceConfigPOList = entity.getInvoiceConfigList().stream().map(groupConverter::invoiceConfig2Po).collect(Collectors.toList());
        //插入或更新
        if (entity.getId() == null) {
            groupMapper.insert(groupPO);
            contractPOList.forEach(x -> {
                x.setGroupId(groupPO.getId());
                contractMapper.insert(x);
            });
            invoiceConfigPOList.forEach(x -> {
                x.setGroupId(groupPO.getId());
                invoiceConfigMapper.insert(x);
            });
        } else {
            groupMapper.updateById(groupPO);
            for (ContractPO contractPO : contractPOList) {
                if (contractPO.getId() == null) {
                    contractMapper.insert(contractPO);
                } else {
                    contractMapper.updateById(contractPO);
                }

            }
            for (InvoiceConfigPO invoiceConfigPO : invoiceConfigPOList) {
                if (invoiceConfigPO.getId() == null) {
                    invoiceConfigMapper.insert(invoiceConfigPO);
                } else {
                    invoiceConfigMapper.updateById(invoiceConfigPO);
                }
            }
        }
        return groupPO.getId();
    }

    @Override
    public GroupDO find(String name) {
        return null;
    }

    @Override
    public Integer count(String name) {
        QueryWrapper<GroupPO> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        wrapper.eq("is_deleted", 0);
        return groupMapper.selectCount(wrapper).intValue();
    }
}
