package com.backend.imnotascam.repository;

import com.backend.imnotascam.entity.TBlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlackListRepository extends JpaRepository<TBlackList, Long> {

    Optional<TBlackList> findByUrl(String url);
}
