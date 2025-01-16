package com.unipa.atchannel.security;

import com.unipa.atchannel.dao.CredentialDao;
import com.unipa.atchannel.model.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.logging.Logger;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredentialDao credentialDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Logger logger = Logger.getLogger(getClass().toString());
        logger.info("LOOKING FOR USER:" + username);
        Credential user = credentialDao.findByUsername(username);

        if (user == null) {
            logger.info("USER NOT FOUND");
            throw new UsernameNotFoundException("Could not find user");
        } else {
            logger.info("USER FOUND");
        }

        return new MyUserDetails(user);
    }

}