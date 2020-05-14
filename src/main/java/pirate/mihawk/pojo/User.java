package pirate.mihawk.pojo;

import java.io.Serializable;

/**
 * @program: mihawk
 * @description: 用户信息
 * @author: buck
 * @create: 2020-05-14 21:54
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 5237730257103305078L;
    private Long id;
    private String userName;
    private String userSex;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserSex() {
        return userSex;
    }
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

}
