-- 재 생성 --
DROP SEQUENCE SEQ_MEMBER_NO;
DROP SEQUENCE SEQ_BOARD_NO;
DROP SEQUENCE SEQ_COMMENT_NO;

CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE;
-- 시퀀스 초기화
-- 시퀀스 현황
SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_MEMBER_NO';
SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_BOARD_NO';
SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_COMMENT_NO';
-- 시퀀스 빼기
ALTER SEQUENCE SEQ_MEMBER_NO INCREMENT BY -23;
ALTER SEQUENCE SEQ_BOARD_NO INCREMENT BY -19;
ALTER SEQUENCE SEQ_COMMENT_NO INCREMENT BY -18;
-- 시퀀스의 NEXTVAL값을 조회
SELECT SEQ_MEMBER_NO.NEXTVAL FROM DUAL;
SELECT SEQ_BOARD_NO.NEXTVAL FROM DUAL;
SELECT SEQ_COMMENT_NO.NEXTVAL FROM DUAL;

SELECT SEQ_MEMBER_NO.CURRVAL FROM DUAL;
SELECT SEQ_BOARD_NO.CURRVAL FROM DUAL;
SELECT SEQ_COMMENT_NO.CURRVAL FROM DUAL;
-- 시퀀스 1로 변경
ALTER SEQUENCE SEQ_MEMBER_NO INCREMENT BY 1;
ALTER SEQUENCE SEQ_BOARD_NO INCREMENT BY 1;
ALTER SEQUENCE SEQ_COMMENT_NO INCREMENT BY 1;

-----------------------------------------------------------------------------------


DROP TABLE "MEMBER" CASCADE CONSTRAINTS;
DROP TABLE "BOARD" CASCADE CONSTRAINTS;
DROP TABLE "COMMENT" CASCADE CONSTRAINTS;

-- 회원(MEMBER) 테이블 생성
CREATE TABLE "MEMBER"(
	MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL,
	MEMBER_NM VARCHAR2(30) NOT NULL,
	MEMBER_GENDER CHAR(1) CONSTRAINT GENDER_CHK CHECK(MEMBER_GENDER IN('M','F')),
	ENROLL_DT DATE DEFAULT SYSDATE NOT NULL,
	UNREGISTER_FL CHAR(1) DEFAULT 'N'
	CONSTRAINT UNREGISTER_CHECK CHECK(UNREGISTER_FL IN('Y','N'))
);

COMMENT ON COLUMN "MEMBER".MEMBER_NO IS '회원번호(시퀀스 SEQ_MEMBER_NO)';
COMMENT ON COLUMN "MEMBER".MEMBER_ID IS '회원 아이디';
COMMENT ON COLUMN "MEMBER".MEMBER_PW IS '회원 비밀번호';
COMMENT ON COLUMN "MEMBER".MEMBER_NM IS '회원 이름';
COMMENT ON COLUMN "MEMBER".MEMBER_GENDER IS '성별(M/F)';
COMMENT ON COLUMN "MEMBER".ENROLL_DT IS '가입일';
COMMENT ON COLUMN "MEMBER".UNREGISTER_FL  IS '탈퇴여부(Y/N)';

-- 게시판(BOARD) 테이블
CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(600)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"DELETE_FL"	CHAR(1)	DEFAULT 'N'	CHECK("DELETE_FL" IN ('Y','N')),
	"MEMBER_NO"	NUMBER	NOT NULL,
	CONSTRAINT BOARD_MEMBER_FK
	FOREIGN KEY("MEMBER_NO") REFERENCES "MEMBER"(MEMBER_NO)
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호 (시퀀스 SEQ_BOARD_NO)';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';
COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '작성일';
COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "BOARD"."DELETE_FL" IS '삭제여부(Y/N)';
COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원번호(FK)';

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

-- 댓글(COMMENT) 테이블
CREATE TABLE "COMMENT" (
	"COMMENT_NO"	NUMBER		NOT NULL,
	"COMMENT_CONTENT"	VARCHAR2(2000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NULL,
	
	"DELETE_FL"	CHAR(1)	DEFAULT 'N'	CHECK("DELETE_FL" IN ('Y','N')),
	
	"MEMBER_NO"	NUMBER	NOT NULL 
	CONSTRAINT COMMENT_MEMBER_FK REFERENCES "MEMBER"(MEMBER_NO),
	
	"BOARD_NO"	NUMBER	NOT NULL
	CONSTRAINT COMMENT_BOARD_FK REFERENCES "BOARD"(BOARD_NO)
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글 번호 (시퀀스 SEQ_COMMENT_NO)';
COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';
COMMENT ON COLUMN "COMMENT"."CREATE_DT" IS '댓글 작성일';
COMMENT ON COLUMN "COMMENT"."DELETE_FL" IS '삭제여부(Y/N)';
COMMENT ON COLUMN "COMMENT"."MEMBER_NO" IS '회원번호(FK)';
COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '게시글번호(FK)';

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"COMMENT_NO"
);

-- 회원 샘플 4개 INSERT 
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01', 'pass01', '유저일', 'F', DEFAULT, DEFAULT);
	
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user02', 'pass02', '유저이', 'M', DEFAULT, DEFAULT);
	
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user03', 'pass03', '유저삼', 'F', DEFAULT, DEFAULT);

INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user99', 'pass99', '유저구구', 'F', DEFAULT, DEFAULT);

SELECT * FROM "MEMBER";

COMMIT;


-- BOARD 테이블 샘플데이터 3개 삽입

INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 1', "내용1 입니다\n안녕하세요", DEFAULT, DEFAULT, DEFAULT, 1);

INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 2', '내용2 입니다\n안녕하세요', DEFAULT, DEFAULT, DEFAULT, 1);

INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 3', '내용3 입니다\n안녕하세요', DEFAULT, DEFAULT, DEFAULT, 2);

SELECT * FROM "BOARD";

COMMIT;

-- 댓글 샘플 데이터 삽입
INSERT INTO "COMMENT"
VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 샘플1', DEFAULT, DEFAULT, 1,1);

INSERT INTO "COMMENT"
VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 샘플1', DEFAULT, DEFAULT, 2,2);

INSERT INTO "COMMENT"
VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 샘플1', DEFAULT, DEFAULT, 3,3);


SELECT * FROM "MEMBER";

COMMIT;
--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
-- 회원(MEMBER) 테이블
CREATE TABLE "MEMBER"(
	MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL,
	MEMBER_NM VARCHAR2(30) NOT NULL,
	MEMBER_GENDER CHAR(1) CONSTRAINT GENDER_CHK CHECK(MEMBER_GENDER IN('M','F')),
	ENROLL_DT DATE DEFAULT SYSDATE NOT NULL,
	UNREGISTER_FL CHAR(1) DEFAULT 'N'
	CONSTRAINT UNREGISTER_CHECK CHECK(UNREGISTER_FL IN('Y','N'))
);

COMMENT ON COLUMN "MEMBER".MEMBER_NO IS '회원번호(시퀀스 SEQ_MEMBER_NO)';
COMMENT ON COLUMN "MEMBER".MEMBER_ID IS '회원 아이디';
COMMENT ON COLUMN "MEMBER".MEMBER_PW IS '회원 비밀번호';
COMMENT ON COLUMN "MEMBER".MEMBER_NM IS '회원 이름';
COMMENT ON COLUMN "MEMBER".MEMBER_GENDER IS '성별(M/F)';
COMMENT ON COLUMN "MEMBER".ENROLL_DT IS '가입일';
COMMENT ON COLUMN "MEMBER".UNREGISTER_FL  IS '탈퇴여부(Y/N)';

-- 게시판(BOARD) 테이블
CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(600)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"DELETE_FL"	CHAR(1)	DEFAULT 'N'	CHECK("DELETE_FL" IN ('Y','N')),
	"MEMBER_NO"	NUMBER	NOT NULL,
	CONSTRAINT BOARD_MEMBER_FK
	FOREIGN KEY("MEMBER_NO") REFERENCES "MEMBER"(MEMBER_NO)
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호 (시퀀스 SEQ_BOARD_NO)';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';
COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '작성일';
COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "BOARD"."DELETE_FL" IS '삭제여부(Y/N)';
COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원번호(FK)';

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

-- 댓글(COMMENT) 테이블
CREATE TABLE "COMMENT" (
	"COMMENT_NO"	NUMBER		NOT NULL,
	"COMMENT_CONTENT"	VARCHAR2(2000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NULL,
	
	"DELETE_FL"	CHAR(1)	DEFAULT 'N'	CHECK("DELETE_FL" IN ('Y','N')),
	
	"MEMBER_NO"	NUMBER	NOT NULL 
	CONSTRAINT COMMENT_MEMBER_FK REFERENCES "MEMBER"(MEMBER_NO),
	
	"BOARD_NO"	NUMBER	NOT NULL
	CONSTRAINT COMMENT_BOARD_FK REFERENCES "BOARD"(BOARD_NO)
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글 번호 (시퀀스 SEQ_COMMENT_NO)';
COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';
COMMENT ON COLUMN "COMMENT"."CREATE_DT" IS '댓글 작성일';
COMMENT ON COLUMN "COMMENT"."DELETE_FL" IS '삭제여부(Y/N)';
COMMENT ON COLUMN "COMMENT"."MEMBER_NO" IS '회원번호(FK)';
COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '게시글번호(FK)';

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"COMMENT_NO"
);




-- SEQUENCE 생성 (MEMBER, BOARD, COMMENT)
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE;

-- 회원 샘플 3개 INSERT 
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01', 'pass01', 
	 '유저일', 'F', DEFAULT, DEFAULT);
	
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user02', 'pass02', 
	 '유저이', 'M', DEFAULT, DEFAULT);
	
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user03', 'pass03', 
	 '유저삼', 'F', DEFAULT, DEFAULT);

-- 삽입 확인
SELECT * FROM "MEMBER";

COMMIT;

-- BOARD 테이블 샘플데이터 3개 삽입

INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 1', '내용1 입니다\n안녕하세요',
	DEFAULT, DEFAULT, DEFAULT, 1);

INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 2', '내용2 입니다\n안녕하세요',
	DEFAULT, DEFAULT, DEFAULT, 1);

INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 3', '내용3 입니다\n안녕하세요',
	DEFAULT, DEFAULT, DEFAULT, 2);


SELECT * FROM "BOARD";

COMMIT;

-- 게시글 목록 조회
-- 게시글번호, 제목, 작성자(이름), 작성일, 조회수
-- 최신 게시글이 위쪽으로 오도록 정렬
SELECT BOARD_NO, BOARD_TITLE, MEMBER_NM, CREATE_DT, READ_COUNT
FROM "BOARD"
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_NO != 0 -- INDEX 사용
ORDER BY BOARD_NO DESC;

-- 댓글 샘플 데이터 삽입 (6 = 1)
INSERT INTO "COMMENT"
VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 샘플1', DEFAULT, DEFAULT, 1,1);

INSERT INTO "COMMENT"
VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 샘플1', DEFAULT, DEFAULT, 2,2);

INSERT INTO "COMMENT"
VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 샘플1', DEFAULT, DEFAULT, 3,3);


SELECT * FROM "COMMENT";

COMMIT;



-- 게시글 목록 조회
-- 게시글번호, 제목, 작성자(이름), 작성일, 조회수, 댓글 수(COMMENT_COUNT)
-- 최신 게시글이 위쪽으로 오도록 정렬
SELECT BOARD_NO, BOARD_TITLE, MEMBER_NM, CREATE_DT, READ_COUNT, 
		(SELECT COUNT(*) FROM "COMMENT" SUB 
		WHERE SUB.BOARD_NO = MAIN.BOARD_NO
		AND DELETE_FL = 'N')COMMENT_COUNT
FROM "BOARD" MAIN
JOIN "MEMBER" USING(MEMBER_NO)
WHERE DELETE_FL = 'N'
ORDER BY BOARD_NO DESC;

SELECT * FROM "COMMENT";
SELECT * FROM "BOARD";

-- 특정 게시글 별 댓글 수

SELECT COUNT(*) FROM "COMMENT" 
WHERE BOARD_NO = 8;


-- 회원 정보(이름, 성별) 수정
UPDATE "MEMBER"
SET MEMBER_NM = ?,
MEMBER_GENDER = ?
WHERE MEMBER_NO = ?;

-- 비번 변경
UPDATE "MEMBER"
SET MEMBER_PW = ?
WHERE ? = ?
AND MEMBER_NO = ?;-- 비번과 입력된 비번
/*
UPDATE "MEMBER"
SET MEMBER_PW = newPw
WHERE Session.loginMember.getMemberPw() = nowPw
AND MEMBER_NO = memberNo;
*/
SELECT MEMBER_PW
FROM "MEMBER";

UPDATE "MEMBER"
SET MEMBER_PW = 'pass99'
WHERE MEMBER_PW = 'pass999'
AND MEMBER_NO = 4;

COMMIT;

-- 탈퇴
UPDATE "MEMBER"
SET UNREGISTER_FL = 'Y'
WHERE MEMBER_NO = ?
AND MEMBER_PW = ?;



-- 게시글 상세 조회

SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT, MEMBER_NO,
		MEMBER_NM , READ_COUNT, CREATE_DT
FROM "BOARD"
JOIN "MEMBER" USING(MEMBER_NO)
WHERE DELETE_FL = 'N'
AND BOARD_NO = ?;

-- 조회수 증가(BOARD 테이블 READ_COUNT 컬럼 겂 수정)
UPDATE "BOARD"
SET READ_COUNT = READ_COUNT + 1 -- 이전 조회수 +1
WHERE BOARD_NO = 1;

SELECT * FROM "BOARD" WHERE BOARD_NO = 1;

ROLLBACK;




-- 게시글 수정
UPDATE "BOARD"
SET BOARD_TITLE = ?,
	BOARD_CONTENT = ?
WHERE BOARD_NO = ?

-- 게시글 삭제처리 (UPDATE)
UPDATE "BOARD"
SET DELETE_FL  = 'Y'
WHERE BOARD_NO = ?

-- 게시글 삽입
INSERT INTO "BOARD"
VALUES (?, ?, ?, DEFAULT, DEFAULT, DEFAULT, ?);


-- 다음 게시글 시퀀스 번호 생성
SELECT SEQ_BOARD_NO.NEXTVAL FROM DUAL;

-- 다음 댓글 시퀀스 번호 확인/생성
SELECT SEQ_COMMENT_NO.CURRVAL FROM DUAL;
SELECT SEQ_COMMENT_NO.NEXTVAL FROM DUAL;

-- 특정 게시글에 대한 댓글 목록 조회
SELECT COMMENT_NO, COMMENT_CONTENT, MEMBER_NO, MEMBER_NM, CREATE_DT
FROM "COMMENT"
JOIN "MEMBER" USING(MEMBER_NO)
WHERE DELETE_FL = 'N'
AND BOARD_NO = 1
ORDER BY COMMENT_NO;

-- 댓글 삽입
INSERT INTO "COMMENT"
VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 삽입 테스트 샘플1', DEFAULT, DEFAULT, 1,3);
--VALUES(SEQ_COMMENT_NO.NEXTVAL, '댓글 삽입 테스트 샘플1', DEFAULT, DEFAULT, 1,3);

--VALUES(?, ?(댓글), DEFAULT, DEFAULT, ?(로그인 멤버),?(게시글 번호));

SELECT * FROM "COMMENT";


-- 특정 댓글 넘버에 대한 댓글 멤버 넘버 조회

SELECT MEMBER_NO
FROM "COMMENT"
JOIN "MEMBER" USING(MEMBER_NO)
WHERE DELETE_FL = 'N'
AND COMMENT_NO = 13;

-- 댓글 수정
UPDATE "COMMENT"
SET COMMENT_CONTENT = '댓글 수정'
WHERE COMMENT_NO = 13;

/*
// 댓글 번호를 입력 받아서
// 1. 해당 댓글이 현재 게시글의 댓글이며
//		로그인한 회원이 쓴 댓글이 맞는지 확인하는 서비스 호출
*/

-- 댓글 번호 입력 받은 후 해당 
-- 게시글에 지우려는 댓글 존재 유무 확인
-- 1이상이면 존재 
-- 0이면 존재X
SELECT COUNT(COMMENT_NO)
FROM "COMMENT"
JOIN "MEMBER" USING(MEMBER_NO)
WHERE DELETE_FL = 'N'
AND BOARD_NO = 1
AND COMMENT_NO = 13;

-- 댓글 삭제
DELETE FROM "COMMENT"
WHERE COMMENT_NO = 13;

SELECT * FROM "COMMENT";

ROLLBACK;





















































































































































