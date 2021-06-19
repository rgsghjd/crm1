package cg.software.settings.dao;

import cg.software.settings.domain.User;

import java.util.Map;

public interface UserDao {
    public User login(Map<String,String> map);


}
