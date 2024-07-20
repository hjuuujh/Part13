package com.zerobase.practice;


import java.util.List;

public interface ZerobaseCourseRepository {

    ZerobaseCourse findById(Long id);

    List<ZerobaseCourse> findAll();
}