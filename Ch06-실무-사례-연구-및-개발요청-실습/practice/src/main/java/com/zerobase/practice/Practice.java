package com.zerobase.practice;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Practice {
    private final ZerobaseCourseRepository repository;

    // TODO: 테스트가 통과할 수 있도록 아래 메서드 들을 작성하세요.

    public Optional<ZerobaseCourse> getZerobaseCourse(Long id) {
        // TODO: id 가 일치하며, hidden = false 인 강의만 조회되어야 함
        ZerobaseCourse course = repository.findById(id);

        if (course == null || course.isHidden()) {
            return Optional.empty();
        } else {
            return Optional.of(course);
        }

    }

    public List<ZerobaseCourse> getZerobaseCourse(String status, List<ZerobaseCourse> courses) {
        // TODO: status가 일치하고, hidden = false 인 강의들이 조회되어야 함
        List<ZerobaseCourse> courses = repository.findAll().stream()
                .filter(c -> !c.isHidden() && status.equalsIgnoreCase(String.valueOf(c.getStatus())))
                .collect(Collectors.toList());
        return courses;
    }

    public List<ZerobaseCourse> getOpenZerobaseCourse(LocalDate targetDt) {
        // TODO: status = "OPEN" 이고, hidden = false 이며,
        //  startAt <= targetDt && targetDt <= endAt 인 강의만 조회되어야함.
        List<ZerobaseCourse> courses = repository.findAll().stream()
                .filter(c -> !c.isHidden() && "OPEN".equalsIgnoreCase(String.valueOf(c.getStatus())))
                .filter(c -> c.getStartAt().isBefore(targetDt) && c.getEndAt().isAfter(targetDt))
                .collect(Collectors.toList());
        return courses;
    }
}
