/*	SELECT(조회, DQL 또는 DML)
 * 
 *  - 데이터 조회 시 조건에 맞는 행들이 조회됨
 *  >> 조회된 행들의 집합을 "RESULT SET" 이라고 함
 * 
 *  - RESULT SET은 0개 이상의 행이 포함될 수 있다
 *  >> 왜 0개 이상? 조건에 맞는 행이 없을 수도 있기 때문에*/
-----------------------------------------------------------------------------------------------
/*
DQL(Data Query Language) 
(SELECT는 DML로도 분류됨)
데이터 검색		SELECT

DML(Data Manipulation Language) 
데이터 조작 	INSERT, UPDATE, DELETE

DDL(Data Definition Language) 
데이터 정의 	CREATE, DROP, ALTER

DCL(Data Control Language) 
데이터 제어 	GRANT, REVOKE

TCL(Transaction Control Language) 
트랜젝션 제어	COMMIT, ROLLBACK
*/
-----------------------------------------------------------------------------------------------
/* SELECT 문 해석 순서
 * 5. SELECT 컬럼명, 함수, 계산식, 리터럴 [[AS] 별칭]
 * 1. FROM 테이블명
 * 2. WHERE 조건식
 * 3. GROUP BY 그룹으로 묶을 컬럼명|함수
 * 4. HAVING 그룹함수식을 이용한 조건식 (GROUP BY가 있어야 작성 가능)
 * 6. ORDER BY 컬럼명|별칭|컬럼순서 정렬방식 [NULLS FIRST|LAST] ASC DECSC
 * */
-----------------------------------------------------------------------------------------------
--(중요) <오늘 날짜 조회>
SELECT SYSDATE/*현재날짜*/ FROM DUAL; 
-- SYSDATE : 시스템상의 현재 날짜(시간)
/* SYSDATE+N : N일 뒤 
 * SYSDATE+1/24/60 : 1분 뒤
 * */
-----------------------------------------------------------------------------------------------
--<컬럼 별칭 지정>
-- 별칭 지정방법
-- 1) 컬럼명 AS 별칭 : 문자ㅇ,  띄어쓰기 X, 특수문자 X
-- 2) 컬럼명 AS "별칭" : 문자ㅇ,  띄어쓰기 ㅇ, 특수문자 ㅇ
-- 3) 컬럼명 별칭 : 문자ㅇ,  띄어쓰기 X, 특수문자 X
-- 4) 컬럼명 "별칭" : 문자ㅇ,  띄어쓰기 ㅇ, 특수문자 ㅇ

--리터럴 : 데이터(값) 그 자체 
--ex) a = 1  : 1 == 리터럴
--DB 에서 리터럴 : 임의로 지정한 값을 기존 테이블에 존재하는 값 처럼 사용
-----------------------------------------------------------------------------------------------
-- <NULL 처리 연산>
-- JAVA에서의 NULL : 참조하는 객체가 없다
-- DB에서의 NULL : 컬럼 값이 없다
-- IS NULL		: 컬럼 값이 NULL인	   경우 TRUE
-- IS NOT NULL	: 컬럼 값이 NULL이 아닌 경우 TRUE
-----------------------------------------------------------------------------------------------
-- 연결 연산자 ( || )
-- 여러 값을 하나의 컬럼 값으로 연결하는 연산자
-- == 자바 문자열(+)처럼 이어쓰기  "가나다" + "라마바", 

-- 000의 급여는 000원 입니다.
SELECT EMP_NAME || '의 급여는' || SALARY || '원 입니다.' AS 결과
FROM EMPLOYEE;
--(선동일의 급여는8000000원 입니다.)
-----------------------------------------------------------------------------------------------
/*LIKE
 * - 비교하려는 값이 특정한 패턴을 만족 시키면(TRUE) 조회하는 연산자
 * 
 * [작성법]
 * WHERE 컬럼명 LIKE '패턴'
 * 
 * -LIKE 패턴 (== 와일드카드)
 * 
 * '%' (포함)
 * - '%A' : 문자열이 앞은 어떤 문자든 포함되고 마지막은 A
 * 			>> A로 끝나는 문자열
 * - 'A%' : >> A로 시작하는 문자열
 * - '%A%' : >> A가 포함된 문자열(위치 상관 X)
 * 
 * '_' (글자수)
 * 'A_' : A 뒤에 아무거나 한 글자만 있는 문자열
 * 			>>(AB,A1,AO,A가)
 * 
 * - '___A' : A 앞에 아무거나 3글자만 있는 문자열  
 * 
 * - '___#_%' ESCAPE '#'
 * --> '#' 뒤에 한 글자(_)를 일반 문자로 벗어나게함
 * --> 앞 아무글자 3개와 문자열 (_) 을 포함하는 것중
 * */
-----------------------------------------------------------------------------------------------
/* ORDER BY 절
 * SELECT구문 중 제일 마지막 해석
 * 기본값 : ASC(오름차순)
 * DESC(내림차순)
 * [NULLS FIRST || LAST]
 */
-----------------------------------------------------------------------------------------------
-- 'YY'는 2000년대, 'RR'은 1900년대를 포함
-- 'RR'은 50년을 기준으로 50 이상이면 1900년대, 50 미만이면 2000년대
-----------------------------------------------------------------------------------------------
--<NULL 처리 함수>
-- NVL(컬럼명, 컬럼 값이 NULL일 경우 바꿀 값)
-- NVL2(컬럼명, NULL X인 경우 값, NULL O 인 경우 값)
-----------------------------------------------------------------------------------------------
-- Java 의 switch
-- DECODE(계산식 | 컬럼명, 조건1, 결과1, 조건2, 결과2,...[, 아무것도 일치 X 일때])
-- DECODE(계산식 | 컬럼명, 조건1, 결과1, 조건2, 결과2,나머지)
-----------------------------------------------------------------------------------------------
-- Java 의 if
-- CASE
-- 	WHEN 조건1 THEN 결과1
-- 	WHEN 조건2 THEN 결과2
-- 	WHEN 조건3 THEN 결과3
-- 	ELSE 결과
-- END
-----------------------------------------------------------------------------------------------
-- <그룹 함수>
--	N개의 행의 값을 하나의 그룹으로 묶어 
--	그룹 수 만큼의 결과를 반환

-- AVG(숫자가 기록된 컬럼명) : 평균
-- SUM(숫자가 기록된 컬럼명) : 합계

-- MAX(컬럼명) : 해당 컬럼의 최대값
-- MIN(컬럼명) : 해당 컬럼의 최소값
-- 타입 제한 X (숫자 : 대/소, 문자열 : 문자 순서, 날짜 : 과거 < 미래)

-- COUNT(* | 컬럼명) : 조회된 행의 개수 반환
-- COUNT(*) 	: NULL을 **포함한** 모든 행의 개수 반환
-- COUNT(컬럼명) 	: 지정된 컬럼의 값이 NULL인 경우를 제외한 행의 개수를 반환
-- COUNT(DISTINCT 컬럼명)
-- 		지정된 컬럼에서 중복된 값을 제외한 행의 개수를 반한
-- END
-----------------------------------------------------------------------------------------------
-- *** SET OPERATION ***

-- 2개 이상의 SELECT 결과 (RESULT SET)을 이용해
-- 하나의 결과를 조회하는 연산자

-- 조건에 따른 SELECT 결과가 다른 경우 
-- 많은 SELECT를 한번에 조회할 때 유용

-- 주의사항
-- 집합 연산에 사용되는 SELECT문은 
-- SELECT절의 타입, 순서, 개수가 동일해야한다

-- UNION : 합집합
-- INTERSECT : 교집합
-- UNION ALL : 합집합 + 교집합
-- MINUS : 차집합
-----------------------------------------------------------------------------------------------
-- 5. 자체 조인(SELF JOIN)

-- 같은 테이블을 조인.
-- 자기 자신과 조인을 맺음
-- 하나의 테이블만 가지고 생각X
-- 같은 테이블 2개 있다고 생각O

-- EMPLOYEE 테이블에서 사번, 이름, 사수사번, 사수이름 조회

-- ANSI 표준
SELECT EMP.EMP_ID, EMP.EMP_NAME, NVL(EMP.MANAGER_ID, '없음'), NVL(MGR.EMP_NAME, '없음')
FROM EMPLOYEE EMP
LEFT JOIN EMPLOYEE MGR ON (EMP.MANAGER_ID = MGR.EMP_ID);

-- 오라클 구문
SELECT EMP.EMP_ID, EMP.EMP_NAME, NVL(EMP.MANAGER_ID, '없음'), NVL(MGR.EMP_NAME, '없음')
FROM EMPLOYEE EMP, EMPLOYEE MGR
WHERE EMP.MANAGER_ID = MGR.EMP_ID(+);
-----------------------------------------------------------------------------------------------
-- 6. 자연 조인(NATURAL JOIN)
-- 동일한 타입과 이름을 가진 컬럼이 있는 테이블 간의 조인을 간단히 표현하는 방법
-- 반드시 두 테이블 간의 동일한 컬럼명, 타입을 가진 컬럼이 필요
--> 없을 경우 교차조인이 됨.
SELECT EMP_NAME , JOB_CODE 
FROM EMPLOYEE
--JOIN JOB USING (JOB_CODE);
NATURAL JOIN JOB;

-- NATURAL JOIN이 성립되지 않는 경우
-- 크로스 조인 결과 나타남
SELECT EMP_NAME , DEPT_TITLE 
FROM EMPLOYEE
NATURAL JOIN DEPARTMENT;
-- EMPLOYEE 	: DEPT_CODE CHAR(2) D1 ~ D9, NULL
-- DEPARTMENT 	: DEPT_ID CHAR(2) D1 ~ D9
-----------------------------------------------------------------------------------------------
/*  서브쿼리 유형
    - 단일행 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 1개일 때 (행1, 열1)
					단일행 서브쿼리 앞에는 비교 연산자 사용
					<, >, <=, >=, =, !=/^=/<>
    
    - 다중행 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 여러개일 때 (행 N, 열 1)
    
    - 다중열 서브쿼리 : 서브쿼리의 SELECT 절에 자열된 항목수가 여러개 일 때 (행1, 열 N)
    				(<, >, <=, >=, =, !=/^=/<>)
    - 다중행 다중열 서브쿼리 : 조회 결과 행 수와 열 수가 여러개일 때 (행 N, 열 N)
    					
    - 상관 서브쿼리 : 서브쿼리가 만든 결과 값을 메인 쿼리가 비교 연산할 때 
                     메인 쿼리 테이블의 값이 변경되면 서브쿼리의 결과값도 바뀌는 서브쿼리
                     
    - 스칼라 서브쿼리 : 상관 쿼리이면서 결과 값이 하나인 서브쿼리
    
   * 서브쿼리 유형에 따라 서브쿼리 앞에 붙은 연산자가 다름
*/
-- ROWNUM : 행 번호 출력하는 가상 컬럼
-- (주의사항) ORDER BY 절 해석 전에 행번호 부여됨
/*	일반 비교연산자 : (<, >, <=, >=, =, !=/^=/<>)
    >> *다중행* 서브쿼리 앞에는 일반 비교연산자 사용 XX 단일행에만 사용O  
    
    	
    - IN / NOT IN : 여러 개의 결과값 중에서 한 개라도 일치하는 값이 있다면
                    혹은 없다면 이라는 의미(가장 많이 사용!)
    - > ANY, < ANY : 여러개의 결과값 중에서 한개라도 큰 / 작은 경우
                     가장 작은 값보다 큰가? / 가장 큰 값 보다 작은가?
    - > ALL, < ALL : 여러개의 결과값의 모든 값보다 큰 / 작은 경우
                     가장 큰 값 보다 큰가? / 가장 작은 값 보다 작은가?
    - EXISTS / NOT EXISTS : 값의 존재 유무
*/
-----------------------------------------------------------------------------------------------
-- 5. 상[호연]관 서브쿼리     06_SUBQUERY(452 LINE)
--    상관 쿼리는 메인쿼리가 사용하는 테이블값을 서브쿼리가 이용해서 결과를 만듦
--    메인쿼리의 테이블값이 변경되면 서브쿼리의 결과값도 바뀌게 되는 구조임
						
-- 메인 쿼리 각 행 마다
-- 메인 > 서브 > 메인
						
-- 상관쿼리는 먼저 메인쿼리 한 행을 조회하고
-- 해당 행이 서브쿼리의 조건을 충족하는지 확인하여 SELECT를 진행함


-- 사수가 있는 직원의 사번, 이름, 부서명, 사수사번 조회
-- EXISTS : 서브쿼리에서 조회된 결과와 일치하는 행이 메인쿼리에 하나라도있으면 조회결과에 포함
			--> 서브쿼리 조회 결과가 1행 이상아면 메인쿼리 행을 결과에 포함

-- 6. 스칼라 서브쿼리     06_SUBQUERY(518 LINE)
--    "SELECT절에 사용되는 (단일행)서브쿼리 결과"로 1행만 반환
--    SQL에서 단일 값을 가르켜 '스칼라'라고 함
-- 

-- 7. 인라인 뷰(INLINE-VIEW)     06_SUBQUERY(554 LINE)
--    FROM 절에서 서브쿼리를 사용하는 경우로
--    서브쿼리가 만든 결과의 집합(RESULT SET)을 테이블 대신에 사용한다.
--	  SELECT 에서는 인라인 뷰 안에 있는 SELECT만 조회 가능
-- VIEW : 조회 목적의 가상 테이블
-----------------------------------------------------------------------------------------------
-- 8. WITH     06_SUBQUERY(642 LINE)
--    서브쿼리에 이름을 붙여주고 사용시 이름을 사용하게 함
--    인라인뷰로 사용될 서브쿼리에 주로 사용됨
--    실행 속도도 빨라진다는 장점이 있다. 
-- 전 직원의 급여 순위 
-- 순위, 이름, 급여 조회
SELECT ROWNUM, EMP_NAME , SALARY
FROM (SELECT EMP_NAME, SALARY 
		FROM EMPLOYEE
		ORDER BY SALARY DESC);

-- WITH 를 이용해 MAIN 쿼리를 깔끔하게 정리
WITH TOP_SALARY AS (SELECT EMP_NAME, SALARY 
					FROM EMPLOYEE
					ORDER BY SALARY DESC)
SELECT ROWNUM, EMP_NAME , SALARY 
FROM TOP_SALARY;
-----------------------------------------------------------------------------------------------
-- 9. RANK() OVER / DENSE_RANK() OVER

-- RANK() OVER : 동일한 순위 이후의 등수를 동일한 인원 수 만큼 건너뛰고 순위 계산
--               EX) 공동 1위가 2명이면 다음 순위는 2위가 아니라 3위

-- 급여 높은 순서
SELECT EMP_NAME , SALARY , RANK() OVER(ORDER BY SALARY DESC) 순위
FROM EMPLOYEE;
	
SELECT * FROM(
	SELECT EMP_NAME , SALARY , RANK() OVER(ORDER BY SALARY DESC) 순위
	FROM EMPLOYEE)
WHERE 순위 <= 5;
--WHERE RANK() OVER(ORDER BY SALARY DESC) <= 5;
--ORA-30483: 윈도우 함수를 여기에 사용할 수 없습니다

-- DENSE_RANK() OVER : 동일한 순위 이후의 등수를 이후의 순위로 계산
--                     EX) 공동 1위가 2명이어도 다음 순위는 2위

SELECT EMP_NAME , SALARY , DENSE_RANK() OVER(ORDER BY SALARY DESC) 순위
FROM EMPLOYEE;
-----------------------------------------------------------------------------------------------
--- *** DML(Data Manipulation Language) : 데이터 조작 언어

-- 테이블에 값을 삽입하거나(INSERT), 수정하거나(UPDATE), 삭제(DELETE)하는 구문
--****************************************
-- CRUD
-- C CREATE	(INSERT)
-- R READ	(SELECT)
-- U UPDATE	(UPDATE)
-- D DELETE	(DELETE)
--****************************************
-----------------------------------------------------------------------------------------------
-- 1. INSERT

-- 테이블에 새로운 행을 추가하는 구문


-- 1)  INSERT INTO 테이블명 VALUES(데이터, 데이터, ...)
-- 테이블에 모든 컬럼에 대한 값을 INSERT할 때 사용
-- INSERT하고자 하는 컬럼이 모든 컬럼인 경우 컬럼명 생략 가능. 단, 컬럼의 순서를 지켜서 VALUES에 값을 기입해야 함
INSERT INTO EMPLOYEE2 
VALUES(900, '장채현', '901123-2345678', 'jang_ch@kh.or.kr', '01012341234',
		'D1', 'J7', 'S3', 4300000, 0.2, 200, SYSDATE, NULL, 'N');
	
INSERT INTO EMPLOYEE2(EMP_NAME, EMP_ID, EMP_NO, EMAIL, PHONE, 
                      DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY)
VALUES('장채현', 900, '901123-2345678', 'jang_ch@kh.or.kr', '01012341234',
       'D1', 'J7', 'S3', 4300000);
      
SELECT * FROM EMPLOYEE2
ORDER BY EMP_ID DESC;

ROLLBACK; -- 마지막 COMMIT 시점으로 돌아감

COMMIT; -- 수행된 DML의 결과를 DB에 반영(저장)
-----------------------------------------------------------------------------------------------
-- 2. UPDATE	테이블에 기록된 컬럼의 값을 수정하는 구문

-- [작성법]
-- UPDATE 테이블명 SET 컬럼명 = 바꿀값 [WHERE 컬럼명 비교연산자 비교값];
-- 단일
UPDATE DEPARTMENT2 
SET DEPT_TITLE = '전략기회팀'
WHERE DEPT_ID = 'D9';
-- 복수
UPDATE DEPARTMENT2 
SET DEPT_ID = 'D0', DEPT_TITLE = '전략기획2팀'
WHERE DEPT_ID = 'D9';

SELECT * FROM EMPLOYEE2; -- 수정 확인
ROLLBACK;

--> 조건 미설정 시 지정된 테이블의 모든 행 수정됨
---> ***WHERE 작성 필수***

-- ** UPDATE시에도 서브쿼리를 사용 가능**

-- [작성법]
-- UPDATE 테이블명
-- SET 컬럼명 = (서브쿼리)
UPDATE EMPLOYEE2 
SET SALARY = (SELECT SALARY FROM EMPLOYEE2 WHERE EMP_NAME = '유재식'), 
	BONUS = (SELECT BONUS FROM EMPLOYEE2 WHERE EMP_NAME = '유재식')
WHERE EMP_NAME = '방명수';
-- 2) 아시아 지역 근무 직원 보너스 0.3으로 변경
UPDATE EMPLOYEE2 
SET BONUS = 0.3
WHERE EMP_ID IN (SELECT EMP_ID
				FROM EMPLOYEE2
				JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
				JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
				WHERE LOCAL_NAME LIKE 'ASIA%'); 
-----------------------------------------------------------------------------------------------
-- 4. DELETE
-- 테이블의 행을 삭제하는 구문


-- [작성법]
-- DELTE FROM 테이블명 WHERE 조건설정
-- 만약 WHERE 조건을 설정하지 않으면 모든 행이 다 삭제됨
-- EMPLOYEE2 테이블에서 '장채현'사원 정보 조회
SELECT * FROM EMPLOYEE2 WHERE EMP_NAME = '장채현';

-- EMPLOYEE2 테이블에서 이름이 '장채현'인 사원 정보 삭제
DELETE FROM EMPLOYEE2 WHERE EMP_NAME = '장채현';

-- SELECT 와 거의 같음, SELECT를 DELETE로 치환
-----------------------------------------------------------------------------------------------
-- 5. TRUNCATE (DDL)
-- 테이블의 전체 행을 삭제하는 DDL
-- DELETE보다 수행속도가 더 빠르다.
-- ROLLBACK을 통해 복구할 수 없다.

-- TRUNCATE 테스트용 테이블 생성
CREATE TABLE EMPLOYEE3
AS SELECT * FROM EMPLOYEE2;
-- 생성 확인
SELECT * FROM EMPLOYEE3;
-- DELETE로 모든 데이터 삭제
DELETE FROM EMPLOYEE3;
-- 삭제 확인
SELECT * FROM EMPLOYEE3;

ROLLBACK;
-- 롤백 후 복구 확인
SELECT * FROM EMPLOYEE3;
-- TRUNCATE로 삭제
TRUNCATE TABLE EMPLOYEE3;
-- 삭제 확인
SELECT * FROM EMPLOYEE3;

ROLLBACK;
-- 롤백 후 복구 확인 -> 복구 안됨을 확인!
SELECT * FROM EMPLOYEE3;
-----------------------------------------------------------------------------------------------
-- TCL(TRANSACTION CONTROL LANGUAGE) : 트랜잭션 제어 언어
-- COMMIT(트랜잭션 종료 후 저장), ROLLBACK(트랜잭션 취소), SAVEPOINT(임시저장)

-- DML : 데이터 조작 언어로 데이터의 삽입(INSERT), 수정(UPDATE), 삭제(DELETE)
--> 트랜잭션은 DML과 관련되어 있음.

/* TRANSACTION이란?
 
 - 데이터베이스의 논리적 연산 단위
 - 데이터 변경 사항을 묶어 하나의 트랜잭션에 담아 처리함.
 - 트랜잭션의 대상이 되는 데이터 변경 사항 : INSERT, UPDATE, DELETE (DML)
 
 EX) INSERT 수행 --------------------------------> DB 반영(X)
   
     INSERT 수행 --> 트랜잭션에 추가 --> COMMIT --> DB 반영(O)
     
     INSERT 10번 수행 --> 1개 트랜잭션에 10개 추가 --> ROLLBACK --> DB 반영 안됨

    1) COMMIT : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 DB에 반영
    
    2) ROLLBACK : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 삭제하고
                 마지막 COMMIT 상태로 돌아감.
                
    3) SAVEPOINT : 메모리 버퍼(트랜잭션)에 저장 지점을 정의하여
                   ROLLBACK 수행 시 전체 작업을 삭제하는 것이 아닌
                   저장 지점까지만 일부 ROLLBACK 
    
    [SAVEPOINT 사용법]		(07_TCL 86 LINE)
    
    SAVEPOINT 포인트명1;
    ...
    SAVEPOINT 포인트명2;
    ...
    ROLLBACK TO 포인트명1; -- 포인트1 지점 까지 데이터 변경사항 삭제

*/
-----------------------------------------------------------------------------------------------
-- DDL(DATA DEFINITION LANGUAGE) : 데이터 정의 언어
CREATE ALTER DROP
-- 객체(OBJECT)를 만들고(CREATE), 수정(ALTER)하고, 삭제(DROP) 등
-- 데이터의 전체 구조를 정의하는 언어로 주로 DB관리자, 설계자가 사용함

-- 오라클에서의 객체 : 테이블(TABLE), 뷰(VIEW), 시퀀스(SEQUENCE),
--                   인덱스(INDEX), 패키지(PACKAGE), 트리거(TRIGGER)
--                   프로시져(PROCEDURE), 함수(FUNCTION),
--                   동의어(SYNONYM), 사용자(USER)
-----------------------------------------------------------------------------------------------
-- CREATE

-- 테이블이나 인덱스, 뷰 등 다양한 데이터베이스 객체를 생성하는 구문
-- 테이블로 생성된 객체는 DROP 구문을 통해 제거 할 수 있음 

-- 1. 테이블 생성하기
-- 테이블이란?
-- 행(row)과 열(column)으로 구성되는 가장 기본적인 데이터베이스 객체
-- 데이터 배이스 내에서 모든 데이터는 테이블을 통해서 저장된다.

-- [표현식] 
/*
    CREATE TABLE 테이블명 (
        컬럼명 자료형(크기), 
        컬럼명 자료형(크기),
        ...);

	자료형
    NUMBER : 숫자형(정수, 실수)
    CHAR(크기) : 고정길이 문자형 (2000BYTE) 
        -> ex) CHAR(10) 컬럼에 'ABC' 3BYTE 문자열만 저장해도 10BYTE 저장공간을 모두 사용. 
    
    영어 숫자 특수문자 띄어쓰기 : 1BYTE
    그 이외 모든것 : 3BYTE    
    
    VARCHAR2(크기) : 가변길이 문자형 (4000 BYTE)
        -> ex) VARCHAR2(10) 컬럼에 'ABC' 3BYTE 문자열만 저장하면 나머지 7BYTE를 반환함.
        
    DATE : 날짜 타입
    BLOB : 대용량 이진 데이터 (4GB)
    CLOB : 대용량 문자 데이터 (4GB)
*/
CREATE TABLE MEMBER(
	MEMBER_ID VARCHAR2(20),
	MEMBER_PW VARCHAR(20),
	MEMBER_NAME VARCHAR(15), -- 이름 한글 2~5글자 (3BYTE)
	MEMBER_SSN CHAR(14), -- 990123-1234567(항상 14글자)
	ENROLL_DATE DATE DEFAULT SYSDATE -- 가입일
);
-- 2. 컬럼에 주석 달기
-- [표현식]
-- COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원 아이디';









































































































































