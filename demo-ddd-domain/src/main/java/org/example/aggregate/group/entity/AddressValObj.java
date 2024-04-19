package org.example.aggregate.group.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressValObj {

    private Integer provinceId;

    private Integer cityId;

    private String addressDetail;

    public AddressValObj(Integer provinceId, Integer cityId, String addressDetail) {
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.addressDetail = addressDetail;
    }
}
