package org.example.group.converter;

import org.example.aggregate.group.entity.AddressValObj;
import org.example.aggregate.group.entity.ContractEntity;
import org.example.aggregate.group.entity.GroupDO;
import org.example.aggregate.group.entity.InvoiceConfigEntity;
import org.example.group.po.ContractPO;
import org.example.group.po.GroupPO;
import org.example.group.po.InvoiceConfigPO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GroupInfraConverter {

    public GroupPO group2Po(GroupDO groupDO) {
        GroupPO groupPO = new GroupPO();
        groupPO.setId(groupDO.getId());
        groupPO.setName(groupDO.getName());
        groupPO.setStatus(groupDO.getStatus());
        groupPO.setProvinceId(groupDO.getAddressValObj().getProvinceId());
        groupPO.setCityId(groupDO.getAddressValObj().getCityId());
        groupPO.setAddressDetail(groupDO.getAddressValObj().getAddressDetail());
        groupPO.setPersonName(groupDO.getPersonName());
        groupPO.setPhone(groupDO.getPhone());
        groupPO.setSaleCode(groupDO.getSaleCode());
        groupPO.setLabel(groupDO.getLabel());
        groupPO.setPayWay(groupDO.getPayWay());
        groupPO.setDayCount(groupDO.getDayCount());
        groupPO.setEstimateOrderAmount(groupDO.getEstimateOrderAmount());
        groupPO.setSettleCycleType(groupDO.getSettleCycleType());
        groupPO.setInvoiceCycleDays(groupDO.getInvoiceCycleDays());
        groupPO.setBackMoneyCycleDays(groupDO.getBackMoneyCycleDays());
        groupPO.setReceiveSmsPhone(groupDO.getReceiveSmsPhone());
        groupPO.setSupportColdChain(groupDO.getSupportColdChain());
        groupPO.setPassportId(groupDO.getPassportId());
        groupPO.setCT(groupDO.getCT());
        groupPO.setUT(groupDO.getUT());
        groupPO.setIsDeleted(groupDO.getIsDeleted());
        return groupPO;
    }

    public ContractPO contract2Po(ContractEntity entity) {
        ContractPO contractPO = new ContractPO();
        contractPO.setId(entity.getId());
        contractPO.setGroupId(entity.getGroupId());
        contractPO.setContractType(entity.getContractType());
        contractPO.setContractStart(entity.getContractStart());
        contractPO.setContractEnd(entity.getContractEnd());
        contractPO.setContractStatus(entity.getContractStatus());
        contractPO.setContractNo(entity.getContractNo());
        contractPO.setImportTime(entity.getImportTime());
        contractPO.setCT(entity.getCT());
        contractPO.setUT(entity.getUT());
        contractPO.setIsDeleted(entity.getIsDeleted());
        return contractPO;
    }

    public InvoiceConfigPO invoiceConfig2Po(InvoiceConfigEntity entity) {
        InvoiceConfigPO iPo = new InvoiceConfigPO();
        iPo.setId(entity.getId());
        iPo.setGroupId(entity.getGroupId());
        iPo.setSaleClassOneId(entity.getSaleClassOneId());
        iPo.setSaleClassOneName(entity.getSaleClassOneName());
        iPo.setInvoiceType(entity.getInvoiceType());
        iPo.setAcceptZeroTax(entity.getAcceptZeroTax());
        iPo.setCT(entity.getCT());
        iPo.setUT(entity.getUT());
        iPo.setIsDeleted(entity.getIsDeleted());
        return iPo;
    }


    public GroupDO group2Do(GroupPO groupPO,
                            List<ContractPO> contractPOList,
                            List<InvoiceConfigPO> invoiceConfigPOList) {
        GroupDO groupDO = new GroupDO();
        groupDO.setId(groupPO.getId());
        groupDO.setName(groupPO.getName());
        groupDO.setStatus(groupPO.getStatus());
        groupDO.setAddressValObj(new AddressValObj(groupPO.getProvinceId(), groupPO.getCityId(), groupPO.getAddressDetail()));
        groupDO.setPersonName(groupPO.getPersonName());
        groupDO.setPhone(groupPO.getPhone());
        groupDO.setSaleCode(groupPO.getSaleCode());
        groupDO.setLabel(groupPO.getLabel());
        groupDO.setPayWay(groupPO.getPayWay());
        groupDO.setDayCount(groupPO.getDayCount());
        groupDO.setEstimateOrderAmount(groupPO.getEstimateOrderAmount());
        groupDO.setSettleCycleType(groupPO.getSettleCycleType());
        groupDO.setInvoiceCycleDays(groupPO.getInvoiceCycleDays());
        groupDO.setBackMoneyCycleDays(groupPO.getBackMoneyCycleDays());
        groupDO.setReceiveSmsPhone(groupPO.getReceiveSmsPhone());
        groupDO.setSupportColdChain(groupPO.getSupportColdChain());
        groupDO.setPassportId(groupPO.getPassportId());
        groupDO.setCT(groupPO.getCT());
        groupDO.setUT(groupPO.getUT());
        groupDO.setIsDeleted(groupPO.getIsDeleted());
        groupDO.setContractList(contractPOList.stream().map(this::contract2Do).collect(Collectors.toList()));
        groupDO.setInvoiceConfigList(invoiceConfigPOList.stream().map(this::invoiceConfig2Do).collect(Collectors.toList()));
        return groupDO;
    }

    public ContractEntity contract2Do(ContractPO po) {
        ContractEntity entity = new ContractEntity();
        entity.setId(po.getId());
        entity.setGroupId(po.getGroupId());
        entity.setContractType(po.getContractType());
        entity.setContractStart(po.getContractStart());
        entity.setContractEnd(po.getContractEnd());
        entity.setContractStatus(po.getContractStatus());
        entity.setContractNo(po.getContractNo());
        entity.setImportTime(po.getImportTime());
        entity.setCT(po.getCT());
        entity.setUT(po.getUT());
        entity.setIsDeleted(po.getIsDeleted());
        return entity;
    }

    public InvoiceConfigEntity invoiceConfig2Do(InvoiceConfigPO po) {
        InvoiceConfigEntity entity = new InvoiceConfigEntity();
        entity.setId(po.getId());
        entity.setGroupId(po.getGroupId());
        entity.setSaleClassOneId(po.getSaleClassOneId());
        entity.setSaleClassOneName(po.getSaleClassOneName());
        entity.setInvoiceType(po.getInvoiceType());
        entity.setAcceptZeroTax(po.getAcceptZeroTax());
        entity.setCT(po.getCT());
        entity.setUT(po.getUT());
        entity.setIsDeleted(po.getIsDeleted());
        return entity;
    }

}
