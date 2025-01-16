package com.unipa.atchannel.service;

import com.unipa.atchannel.dao.CredentialDao;
import com.unipa.atchannel.dao.UserDao;
import com.unipa.atchannel.model.Credential;
import com.unipa.atchannel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CredentialService {

    @Autowired
    private CredentialDao credentialDao;

    public void addCredential(String username, String password) {

        Credential credential = new Credential();

        credential.setUsername(username);
        credential.setPassword(password);
        credential.setRole("USER");
        credential.setEnabled(true);

        credentialDao.save(credential);
    }
}
