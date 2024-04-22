package org.example.adaptor;

import java.util.List;

public interface VerifyGateway {

    /**
     * 合同提交审核
     *
     * @param contractNoList
     * @return
     */
    Boolean submitVerify(List<String> contractNoList);
}
