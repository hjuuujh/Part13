package com.zerobase.practice.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZerobaseCourseRepository {

    Optional<ZerobaseCourse> findById(Long id);

    List<ZerobaseCourse> findAll();
}