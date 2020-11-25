package top.alvinsite.chat.common.model.entity;

import lombok.Data;

import java.util.List;

/**
 * 用户实体
 * @author Alvin
 */
@Data
public class User {

    private String id;

    private String username;

    private String password;

    /**
     * 好友列表
     */
    private List<String> friends;
}
