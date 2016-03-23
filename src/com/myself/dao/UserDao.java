package com.myself.dao;



import com.myself.model.user.UserInfo;

public interface UserDao {
    public boolean find(UserInfo userInfo);
    public boolean save(UserInfo userInfo);
}
