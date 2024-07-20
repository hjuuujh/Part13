package com.zerobase.practice;

import com.zerobase.practice.type.ZerobaseCourseStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class ZerobaseCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ZerobaseCourseStatus status;

    private LocalDate startAt;

    private LocalDate endAt;

    private boolean hidden;

    @Builder
    public ZerobaseCourse(Long courseId, String name, ZerobaseCourseStatus status, LocalDate startAt, LocalDate endAt, boolean hidden) {
        this.courseId = courseId;
        this.name = name;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
        this.hidden = hidden;
    }
}