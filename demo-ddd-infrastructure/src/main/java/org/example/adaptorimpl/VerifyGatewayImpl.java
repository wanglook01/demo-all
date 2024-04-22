package org.example.adaptorimpl;

import lombok.extern.slf4j.Slf4j;
import org.example.adaptor.VerifyGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VerifyGatewayImpl implements VerifyGateway {

    /**
     * 提交合同审核给公司的审核流程
     *
     * @param contractNoList
     * @return
     */
    @Override
    public Boolean submitVerify(List<String> contractNoList) {
        log.info("submitVerify:{},success", contractNoList);
        return true;
    }
}
