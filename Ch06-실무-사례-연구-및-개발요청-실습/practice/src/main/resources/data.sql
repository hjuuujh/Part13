insert into `zerobase_course`(`course_id`,`name`,`status`,`start_at`,`end_at`,`hidden`)
values  (1, 'Java 백엔드 개발자 취업 (2기)', 'IN_PROGRESS', DATEADD(MONTH, -1, now()), DATEADD(MONTH, 1, now()), false),
        (2, '프론트엔드 개발자되기', 'IN_PROGRESS', DATEADD(MONTH, -2, now()), DATEADD(MONTH, 1, now()), false),
        (3, '바로 써먹는 데이터 분석', 'CLOSE', DATEADD(MONTH, -2, now()), DATEADD(MONTH, 1, now()), false),
        (4, '직접 만드는 파이썬 자동화 48일', 'OPEN', DATEADD(MONTH, -1, now()), DATEADD(MONTH, 1, now()), false),
        (5, 'Java 백엔드 개발자 취업 (1기)', 'OPEN', DATEADD(MONTH, -1, now()), DATEADD(MONTH, 2, now()), false),
        (6, '테스트용 강의', 'OPEN', DATEADD(MONTH, -1, now()), DATEADD(MONTH, 2, now()) ,true);