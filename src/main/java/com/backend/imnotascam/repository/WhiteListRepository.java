package com.backend.imnotascam.repository;

import com.backend.imnotascam.entity.TBlackList;
import com.backend.imnotascam.entity.TWhiteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WhiteListRepository extends JpaRepository<TWhiteList, Long> {

    Optional<TWhiteList> findByUrl(String url);
}
