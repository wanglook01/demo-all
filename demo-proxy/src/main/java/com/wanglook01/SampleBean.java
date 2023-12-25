package com.wanglook01;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class SampleBean {

    private Long skuId;

    private Integer class1Id;

    private String skuName;

    private Double price;

    private List<String> pictures;

    private TagDTO tagDTO;

    private List<TagDTO> core_label_list;

    private Map<String, TagDTO> attrMap;

    @Data
    public static class TagDTO implements Serializable {

        private Integer tagId;

        private Integer textSize;

        private String text_color;

        private RemindInfoDTO remindInfoDTO;

        public static TagDTO get(Integer tagId, Integer textSize, String text_color, String tips, String location) {
            TagDTO dto = new TagDTO();
            dto.setTagId(tagId);
            dto.setTextSize(textSize);
            dto.setText_color(text_color);
            RemindInfoDTO remindInfoDTO = new RemindInfoDTO();
            remindInfoDTO.setTips(tips);
            remindInfoDTO.setLocation(location);
            dto.setRemindInfoDTO(remindInfoDTO);
            return dto;
        }
    }

    @Data
    public static class RemindInfoDTO implements Serializable {

        private String tips;
        private String location;
    }

}