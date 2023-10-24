package com.wanglook01.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryInfoDTO implements Serializable {

    private Integer is_show;

    private String promise_text;

    private String delivery_text;

    private List<String> text;

    public static DeliveryInfoDTO get() {
        DeliveryInfoDTO dto = new DeliveryInfoDTO();
        dto.setIs_show(0);
        dto.setPromise_text("112");
        dto.setDelivery_text("2222");
        dto.setText(new ArrayList<>());
        return dto;
    }

}
