package com.example.sujanproject.Pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPojo {
    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;

//    private List<NovelPojo> novels;
}
