package com.unipa.atchannel.dao;

import com.unipa.atchannel.model.Credential;
import org.springframework.data.repository.CrudRepository;

public interface CredentialDao extends CrudRepository<Credential, Integer> {
    Credential findByUsername(String username);
}