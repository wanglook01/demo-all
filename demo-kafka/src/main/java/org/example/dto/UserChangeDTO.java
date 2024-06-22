package org.example.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserChangeDTO {

    private Integer userId;

    private String userName;

    private Integer phone;

    public UserChangeDTO(Integer userId, String userName, Integer phone) {
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
    }
}
