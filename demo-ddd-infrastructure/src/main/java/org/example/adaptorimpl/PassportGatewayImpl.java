package org.example.adaptorimpl;

import org.example.adaptor.PassportGateway;
import org.springframework.stereotype.Service;

@Service
public class PassportGatewayImpl implements PassportGateway {

    /**
     * 通过http调用，获取手机号码是否在其余门店是使用状态
     *
     * @param phone
     * @return
     */
    @Override
    public Boolean checkPhoneIsUsed(String phone) {
        return false;
    }
}
