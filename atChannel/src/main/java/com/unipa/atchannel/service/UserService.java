package com.unipa.atchannel.service;

import com.unipa.atchannel.dao.CredentialDao;
import com.unipa.atchannel.dao.UserDao;
import com.unipa.atchannel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private CredentialDao credentialDao;

    @Autowired
    private UserDao userDao;

    public void addUser(String firstname, String lastname, String username, String email){

        User user = new User();

        user.setUserId(credentialDao.findByUsername(username).getId());
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setEmail(email);
        user.setNametag("@" + firstname.toLowerCase() + lastname.toLowerCase());
        user.setPic_path("assets/img/pics/user_pic.png");
        user.setCover_path("assets/img/covers/user_cover.png");

        userDao.save(user);
    }
}
