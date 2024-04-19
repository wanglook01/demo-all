package org.example.test;


import org.example.aggregate.group.entity.AddressValObj;
import org.example.aggregate.group.entity.ContractEntity;
import org.example.aggregate.group.entity.GroupDO;
import org.example.aggregate.group.entity.InvoiceConfigEntity;
import org.example.aggregate.group.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collections;


@SpringBootTest
public class GroupTest {

    @Resource
    private GroupRepository groupRepository;

    @Test
    public void testCreate() {
        //
        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setContractType(0);
        contractEntity.setContractStart(0);
        contractEntity.setContractEnd(0);
        contractEntity.setContractStatus(0);
        contractEntity.setContractNo("");
        contractEntity.setImportTime(0L);
        contractEntity.setCT(0L);
        contractEntity.setUT(0L);
        contractEntity.setIsDeleted(0);
        //
        InvoiceConfigEntity invoiceConfigEntity = new InvoiceConfigEntity();
        invoiceConfigEntity.setSaleClassOneId(0);
        invoiceConfigEntity.setSaleClassOneName("");
        invoiceConfigEntity.setInvoiceType(0);
        invoiceConfigEntity.setAcceptZeroTax(0);
        invoiceConfigEntity.setCT(0L);
        invoiceConfigEntity.setUT(0L);
        invoiceConfigEntity.setIsDeleted(0);
        //
        AddressValObj addressValObj = new AddressValObj();
        addressValObj.setProvinceId(0);
        addressValObj.setCityId(0);
        addressValObj.setAddressDetail("");
        //
        GroupDO groupDO = new GroupDO();
        groupDO.setName("");
        groupDO.setStatus(0);
        groupDO.setAddressValObj(addressValObj);
        groupDO.setPersonName("");
        groupDO.setPhone("");
        groupDO.setSaleCode("");
        groupDO.setLabel(0);
        groupDO.setPayWay(0);
        groupDO.setDayCount(0);
        groupDO.setEstimateOrderAmount(new BigDecimal("0"));
        groupDO.setSettleCycleType(0);
        groupDO.setInvoiceCycleDays(0);
        groupDO.setBackMoneyCycleDays(0);
        groupDO.setReceiveSmsPhone("");
        groupDO.setSupportColdChain(0);
        groupDO.setPassportId(0L);
        groupDO.setCT(0L);
        groupDO.setUT(0L);
        groupDO.setIsDeleted(0);
        groupDO.setContractList(Collections.singletonList(contractEntity));
        groupDO.setInvoiceConfigList(Collections.singletonList(invoiceConfigEntity));
        Long save = groupRepository.save(groupDO);
        System.out.println(save);
    }
}
