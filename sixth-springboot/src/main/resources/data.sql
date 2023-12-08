INSERT INTO MEMBER(NICKNAME, NAME, AGE, PART, GENERATION)
VALUES ('유난', '최윤한', 20, 'SERVER', 33),
       ('DDD', '정준서', 24, 'SERVER', 33),
       ('멜로니', '김해린', 26, 'PLAN', 33),
       ('티벳여우', '이태희', 25, 'ANDROID', 33);
INSERT INTO POST(TITLE, CATEGORY_ID, CONTENT, MEMBER_ID)
VALUES
    ('안녕하세요 제목1', 1, '안녕하세요 내용1', 1),
    ('안녕하세요 제목2', 2, '안녕하세요 내용2', 1),
    ('안녕하세요 제목3', 1, '안녕하세요 내용3', 1),
    ('반갑습니다 제목4', 2, '반갑습니다', 2),
    ('안녕하세요 제목5', 3, '안녕하세요', 3);
INSERT INTO CATEGORY(CONTENT)
VALUES
    ('일상'),
    ('여행'),
    ('공부');