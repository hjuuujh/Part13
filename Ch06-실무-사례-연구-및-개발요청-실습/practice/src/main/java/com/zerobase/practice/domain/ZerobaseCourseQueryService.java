package com.zerobase.practice.domain;

import com.zerobase.practice.type.ZerobaseCourseStatus;
import com.zerobase.practice.web.advice.ClientException;
import com.zerobase.practice.web.advice.InternalServerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.zerobase.practice.web.exception.ExceptionCode.*;

@Service
@RequiredArgsConstructor
public class ZerobaseCourseQueryService {
    private final ZerobaseCourseRepository zerobaseCourseRepository;

    public ZerobaseCourse getOrThrow(Long id) {
        return zerobaseCourseRepository.findById(id)
                .filter(it -> !it.isHidden())
                .orElseThrow(()-> new InternalServerException(NOT_FOUND_COURSE)); // TODO 적당히 Exception을 바꿔보세요
    }

    public List<ZerobaseCourse> getZerobaseCourseList(ZerobaseCourseStatus status) {

        checkStatus(status);

        return zerobaseCourseRepository.findAll()
                .stream()
                .filter(it -> !it.isHidden())
                .filter(it -> it.isSameStatus(status))
                .collect(Collectors.toList());
    }

    private void checkStatus(ZerobaseCourseStatus status) {
        if (status.isUnknown())
            throw new ClientException(INVALID_COURSE_STATUS); // TODO 적당히 Exception을 바꿔보세요

        if (status.isClose())
            throw new ClientException(ALREADY_CLOSED); // TODO 적당히 Exception을 바꿔보세요
    }
}