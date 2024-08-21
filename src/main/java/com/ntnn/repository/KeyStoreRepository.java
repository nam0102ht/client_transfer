package com.ntnn.repository;

import com.ntnn.entity.KeyStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyStoreRepository extends JpaRepository<KeyStorage, String> {
}
