package com.example.facebookClone.repository;

import com.example.facebookClone.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostEntityRepository extends JpaRepository<PostEntity,Long> {
}
