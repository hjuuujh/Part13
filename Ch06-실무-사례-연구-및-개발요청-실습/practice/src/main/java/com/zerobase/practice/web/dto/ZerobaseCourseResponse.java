package com.zerobase.practice.web.dto;

import com.zerobase.practice.domain.ZerobaseCourse;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class ZerobaseCourseResponse {
    private Long id;
    private String name;
    private String logo;
    private String status;
    private LocalDate startAt;
    private LocalDate endAt;

    public static ZerobaseCourseResponse of(ZerobaseCourse zerobaseCourse) {
        return ZerobaseCourseResponse
                .builder()
                .id(zerobaseCourse.getId())
                .name(zerobaseCourse.getName())
//                .logo(zerobaseCourse.getLogo())
                .status(zerobaseCourse.getStatus().name())
                .startAt(zerobaseCourse.getStartAt())
                .endAt(zerobaseCourse.getEndAt())
                .build();
    }
}