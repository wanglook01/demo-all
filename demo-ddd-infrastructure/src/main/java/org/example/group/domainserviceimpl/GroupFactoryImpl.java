package org.example.group.domainserviceimpl;

import org.example.aggregate.group.domainservice.GroupFactory;
import org.example.aggregate.group.entity.AddressValObj;
import org.example.aggregate.group.entity.ContractEntity;
import org.example.aggregate.group.entity.GroupDO;
import org.example.aggregate.group.entity.InvoiceConfigEntity;
import org.example.dto.ContractDTO;
import org.example.dto.InvoiceConfigDTO;
import org.example.dto.cmd.GroupCreateCmd;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GroupFactoryImpl implements GroupFactory {

    @Override
    public GroupDO create(Object input) {
        if (input instanceof GroupCreateCmd) {
            GroupCreateCmd cmd = (GroupCreateCmd) input;
            GroupDO groupDO = new GroupDO();
            groupDO.setName(cmd.getName());
            groupDO.setAddressValObj(new AddressValObj(cmd.getProvinceId(), cmd.getCityId(), cmd.getAddressDetail()));
            groupDO.setPersonName(cmd.getPersonName());
            groupDO.setPhone(cmd.getPhone());
            groupDO.setSaleCode(cmd.getSaleCode());
            groupDO.setLabel(cmd.getLabel());
            groupDO.setPayWay(cmd.getPayWay());
            groupDO.setDayCount(cmd.getDayCount());
            groupDO.setEstimateOrderAmount(cmd.getEstimateOrderAmount());
            groupDO.setSettleCycleType(cmd.getSettleCycleType());
            groupDO.setInvoiceCycleDays(cmd.getInvoiceCycleDays());
            groupDO.setBackMoneyCycleDays(cmd.getBackMoneyCycleDays());
            groupDO.setReceiveSmsPhone(cmd.getReceiveSmsPhone());
            groupDO.setSupportColdChain(cmd.getSupportColdChain());
            groupDO.setPassportId(cmd.getPassportId());
            //固定值
            groupDO.setStatus(1);
            groupDO.setCT(System.currentTimeMillis() / 1000);
            groupDO.setUT(System.currentTimeMillis() / 1000);
            groupDO.setIsDeleted(0);
            //校验逻辑
            if (CollectionUtils.isEmpty(cmd.getContractDTOList())
                    || CollectionUtils.isEmpty(cmd.getInvoiceConfigDTOList())) {
                throw new RuntimeException("字段为空");
            }
            List<ContractEntity> contractEntityList = cmd.getContractDTOList().stream().map(this::toContractEntity).collect(Collectors.toList());
            groupDO.setContractList(contractEntityList);
            List<InvoiceConfigEntity> incList = cmd.getInvoiceConfigDTOList().stream().map(this::toInvoiceConfigEntity).collect(Collectors.toList());
            groupDO.setInvoiceConfigList(incList);
            return groupDO;
        }
        return null;
    }


    private ContractEntity toContractEntity(ContractDTO dto) {
        ContractEntity entity = new ContractEntity();
        entity.setId(null);
        entity.setGroupId(null);
        entity.setContractType(dto.getContractType());
        entity.setContractStart(dto.getContractStart());
        entity.setContractEnd(dto.getContractEnd());
        entity.setContractStatus(dto.getContractStatus());
        entity.setContractNo(dto.getContractNo());
        entity.setImportTime(dto.getImportTime());
        entity.setCT(System.currentTimeMillis() / 1000);
        entity.setUT(System.currentTimeMillis() / 1000);
        entity.setIsDeleted(0);
        return entity;
    }

    private InvoiceConfigEntity toInvoiceConfigEntity(InvoiceConfigDTO dto) {
        InvoiceConfigEntity entity = new InvoiceConfigEntity();
        entity.setId(null);
        entity.setGroupId(null);
        entity.setSaleClassOneId(dto.getSaleClassOneId());
        entity.setSaleClassOneName(dto.getSaleClassOneName());
        entity.setInvoiceType(dto.getInvoiceType());
        entity.setAcceptZeroTax(dto.getAcceptZeroTax());
        entity.setCT(System.currentTimeMillis() / 1000);
        entity.setUT(System.currentTimeMillis() / 1000);
        entity.setIsDeleted(0);
        return entity;
    }
}
