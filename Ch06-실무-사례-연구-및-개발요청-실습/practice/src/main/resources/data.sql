insert into `user`(`name`, `created_at`, `updated_at`, `deleted_at`)
values ('김제로', now(), now(), null),
       ('박완주', now(), now(), null),
       ('이패캠', now(), now(), null);


insert into `book` (`title`, `sale`, `min_age`, `created_at`, `updated_at`)
values ('리팩토링', 'N', 0, now(), now()),
       ('리팩토링2', 'Y', 0, now(), now()),
       ('엔터프라이즈 애플리케이션 아키텍처 패턴', 'Y', 0, now(), now()),
       ('Clean Code 클린 코드', 'Y', 0, now(), now()),
       ('클린 아키텍처', 'Y', 0, now(), now()),
       ('자바 ORM 표준 JPA 프로그래밍', 'Y', 0, now(), now()),
       ('새로쓴 대용량 데이터베이스 솔루션', 'Y', 0, now(), now()),
       ('테스트 주도 개발', 'Y', 0, now(), now());

insert into `book_stock` (`book_id`, `stock`, `created_at`, `updated_at`)
values (1, 0, now(), now()),
       (2, 5, now(), now()),
       (3, 5, now(), now()),
       (4, 3, now(), now()),
       (5, 1, now(), now()),
       (6, 10, now(), now()),
       (7, 0, now(), now());