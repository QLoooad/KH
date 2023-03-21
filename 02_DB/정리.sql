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
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
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

-- MEMBER 테이블에 샘플 데이터 삽입
INSERT INTO MEMBER
VALUES('MEM01', '123ASD', '홍길동', '990123-1234567', SYSDATE);

-- 주민번호, 전화번호와 같은 숫자로만 이루어진 데이터를
-- NUMBER 타입으로 지정할 경우의 문제점

INSERT INTO MEMBER2 VALUES('고길동', 9001011234567, 01012345678);
INSERT INTO MEMBER2 VALUES('김길동', 0001013456789, 01012345678);

-- 9001011234567	1012345678
-- 1013456789	1012345678

-- NUMBER 타입의 컬럼은 값 제일 앞 0을 유지하지 않는 문제 발생
-- 문제 해결 방법 : NUMBER 타입 하지 않고 CHAR, VARCHAR2 타입으로 컬럼 타입 지정

/*********************************************************************************************/
/*********************************************************************************************/
-- 제약 조건(CONSTRAINTS)
/*
    사용자가 원하는 조건의 데이터만 유지하기 위해서 특정 컬럼에 설정하는 제약.
    ******************
    *****데이터 무결성**** 보장을 목적으로 함.
	******************
	--> 데이터 무결성 : 중복, NULL X
	
    + 입력 데이터에 문제가 없는지 자동으로 검사하는 목적
    + 데이터의 수정/삭제 가능여부 검사등을 목적으로 함 
        --> 제약조건을 위배하는 DML 구문은 수행할 수 없음!
    
    제약조건 종류(순서대로 중요도)
    PRIMARY KEY, FOREIGN KEY, NOT NULL, UNIQUE, CHECK 
    
/*********************************************************************************************
	PRIMARY KEY : NULL과 중복 값을 허용하지 않음(컬럼의 고유 식별자로 사용하기 위해)
	
	FOREIGN KEY : 참조되는 테이블의 컬럼의 값이 존재하면 허용
	
	NOT NULL : 데이터에 NULL을 허용하지 않음
	
	UNIQUE : 중복된 값을 허용하지 않음
	
	CHECK : 저장 가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만 허용
*********************************************************************************************/

-- PRIMARY KEY(기본키) 제약조건 

-- 모든 테이블에는 PRIMARY KEY 가 있어야한다

-- 테이블에서 한 행의 정보를 찾기위해 사용할 컬럼을 의미함
-- 테이블에 대한 식별자(IDENTIFIER) 역할을 함
-- NOT NULL + UNIQUE 제약조건의 의미만 같음 (이걸 뜻하는건 아님)
-- 한 테이블당 한 개만 설정할 수 있음
-- 컬럼레벨, 테이블레벨 둘다 설정 가능함
-- 한 개 컬럼에 설정할 수도 있고, 여러개의 컬럼을 묶어서 설정할 수 있음 (복합키 가능)

-- 1.	 1   1 	중복없음, 성공
-- 2.    1   2	아이디 중복이라 실패
-- 3.	 2   2	값이 중복이라 실패
-- 4. NULL   3	NULL 들어가면 실패

CREATE TABLE USER_USED_PK(
	USER_NO NUMBER,
--    USER_NO NUMBER PRIMARY KEY, -- 컬럼 레벨(제약조건명 X)
--    USER_NO NUMBER CONSTRAINT USER_NO_PK PRIMARY KEY, -- 컬럼 레벨(제약조건명 O)
, CONSTRAINT USER_NO_PK PRIMARY KEY(USER_NO) -- 제약조건명 O
);
/*********************************************************************************************/
-- FOREIGN KEY(외부키 / 외래키) 제약조건 

-- 참조(REFERENCES)된 다른 테이블의 컬럼이 제공하는 값만 사용할 수 있음
-- FOREIGN KEY제약조건에 의해서 테이블간의 관계(RELATIONSHIP)가 형성됨
-- 제공되는 값 외에는 NULL만 사용할 수 있음

-- 다른 테이블의 PK 값만 사용
-- 다른 PK가 적용된 테이블.컬럼에 있는 값만을 가져온다(NULL 가능)

-- 컬럼레벨일 경우
-- 컬럼명 자료형(크기) [CONSTRAINT 이름] REFERENCES 참조할 테이블명 [(참조할컬럼)] [삭제룰]

-- 테이블레벨일 경우
-- [CONSTRAINT 이름] FOREIGN KEY (적용할컬럼명) REFERENCES 참조할테이블명 [(참조할컬럼)] [삭제룰]

-- * 참조될 수 있는 컬럼은 PRIMARY KEY컬럼과, UNIQUE 지정된 컬럼만 외래키로 사용할 수 있음
--참조할 테이블의 참조할 컬럼명이 생략이 되면, PRIMARY KEY로 설정된 컬럼이 자동 참조할 컬럼이 됨

-- 테이블1 을 만들고 그 테이블1을 테이블2에서 참조한다
-- 그때 테이블 2는 1에 있는 값만 참조할수있다 NULL 은 가능

-- 3) ON DELETE CASCADE(종속) : 부모키 삭제시 자식키도 함께 삭제됨
-- 부모키 삭제시 값을 사용하는 자식 테이블의 컬럼에 해당하는 행이 삭제가 됨

CREATE TABLE USER_GRADE(
  GRADE_CODE NUMBER PRIMARY KEY,
  GRADE_NAME VARCHAR2(30) NOT NULL
);
INSERT INTO USER_GRADE VALUES (10, '일반회원');
INSERT INTO USER_GRADE VALUES (20, '우수회원');
INSERT INTO USER_GRADE VALUES (30, '특별회원');

CREATE TABLE USER_USED_FK(
  USER_NO NUMBER PRIMARY KEY,
  USER_ID VARCHAR2(20) UNIQUE,
  USER_PWD VARCHAR2(30) NOT NULL,
  -- 컬럼 레벨로 FK 제약조건 설정
  -- 컬럼명 자료형(크기) [CONSTRAINT 이름] REFERENCES 참조할 테이블명 [(참조할컬럼)] [삭제룰]
  GRADE_CODE NUMBER CONSTRAINT GRADE_CODE_FK1 REFERENCES USER_GRADE(GRADE_CODE) 
  
  /*CONSTRAINT GRADE_CODE_FK2 FOREIGN KEY(GRADE_CODE)
  REFERENCES USER_GRADE2(GRADE_CODE) ON DELETE SET NULL*/
  -- [CONSTRAINT 이름] FOREIGN KEY (적용할컬럼명) REFERENCES 참조할테이블명 [(참조할컬럼)] [삭제룰]
);

/*********************************************************************************************/
/*********************************************************************************************/
-- NOT NULL 
-- 해당 컬럼에 반드시 값이 기록되어야 하는 경우 사용
-- 삽입/수정시 NULL값을 허용하지 않도록 컬럼레벨에서 제한


CREATE TABLE USER_USED_NN(
    USER_NO NUMBER NOT NULL, -- 컬럼레벨 제약조건 설정(컬럼 만들때 제약조건을 줌) 
    			-- > NOT NULL 은 컬럼레벨로만 작성가능
    --> 테이블 레벨 제약조건 설정 (테이블 다 만들고 마지막에 제약조건을 줌)
);

/*********************************************************************************************/
/*********************************************************************************************/
-- UNIQUE 제약조건 
-- 컬럼에 입력 값에 대해서 중복을 제한하는 제약조건
-- 컬럼레벨에서 설정 가능, 테이블 레벨에서 설정 가능
-- 단, UNIQUE 제약 조건이 설정된 컬럼에 NULL 값은 중복 삽입 가능.

--	1.	1 1 중복없음, 성공
--	2.  1 2	아이디 같지만 이름 다름, 성공
--	3.  2 2	이름 같지만 아이디 다름, 성공
--	4.  2 2	이름과 아이디 다 같음, 실패

-- UNIQUE 제약 조건 테이블 생성
CREATE TABLE USER_USED_UK(
    USER_NO NUMBER,
--    USER_ID VARCHAR2(20) UNIQUE, -- 컬럼레벨 제약조건 설정(이름 미지정)
--    USER_ID VARCHAR2(20) CONSTRAINT USER_ID_UK UNIQUE, 
    						-- 컬럼레벨 제약조건 설정(이름 지정)
    
    -- 테이블 레벨 제약조건 설정
--    , UNIQUE(USER_ID) -- 제약조건(컬럼명)(이름 미지정)
    ,CONSTRAINT USER_ID_UK UNIQUE(USER_ID) -- 제약조건(컬럼명)(이름 지정)
);
/*********************************************************************************************/
/*********************************************************************************************/

-- 5. CHECK 제약조건 : 컬럼에 기록되는 값에 조건 설정을 할 수 있음
-- CHECK (컬럼명 비교연산자 비교값)
-- 주의 : 비교값은 리터럴만 사용할 수 있음, 변하는 값이나 함수 사용 못함
CREATE TABLE USER_USED_CHECK(
  USER_NO NUMBER PRIMARY KEY,
  USER_ID VARCHAR2(20) UNIQUE,
  USER_PWD VARCHAR2(30) NOT NULL,
  USER_NAME VARCHAR2(30),
  -- 컬럼 레벨
  GENDER VARCHAR2(10) CONSTRAINT GENDER_CHECK CHECK(GENDER IN ('남', '여')),
  
  PHONE VARCHAR2(30),
  EMAIL VARCHAR2(50)
);

INSERT INTO USER_USED_CHECK
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_CHECK
VALUES(2, 'user02', 'pass02', '홍길동', '남자', '010-1234-5678', 'hong123@kh.or.kr');
-- GENDER 컬럼에 CHECK 제약조건으로 '남' 또는 '여'만 기록 가능한데 
-- '남자'라는 조건 이외의 값이 들어와 에러 발생
-- ORA-02290: 체크 제약조건(KH_CGT.GENDER_CHECK)이 위배되었습니다

-- CHECK 제약 조건은 범위로도 설정 가능.
/*********************************************************************************************/
/*********************************************************************************************/
-- ALTER(바꾸다, 변조하다)
-- 수정 가능한 것 : 컬럼(추가/수정/삭제), 제약조건(추가/삭제)
--                  이름변경(테이블, 컬럼, 제약조건)

-- [작성법]
-- 테이블을 수정하는 경우
-- ALTER TABLE 테이블명 ADD|MODIFY|DROP 수정할 내용;

--------------------------------------------------------------------------------
-- 1. 제약조건 추가 / 삭제
-- 제약조건은 수정 불가능
-- 수정 필요 시 삭제 후 다시 추가

-- * 작성법 중 [] 대괄호 : 생략할 수 도, 안할 수 도 있다.

-- 제약조건 추가 : ALTER TABLE 테이블명 
--                 ADD [CONSTRAINT 제약조건명] 제약조건(컬럼명) [REFERENCES 테이블명[(컬럼명)]];

-- 제약조건 삭제 : ALTER TABLE 테이블명
--                 DROP CONSTRAINT 제약조건명;

-- 서브쿼리를 이용해서 DEPARTMENT 테이블 복사 --> NOT NULL 제약조건만 복사됨
CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;
-- NOT NULL만 카피됨
--> DEPT_ID, LOCATION_ID 에만 NOT NULL 제약조건 설정됨


-- DEPT_COPY 테이블에 PK 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT PK_DEPT_COPY
PRIMARY KEY(DEPT_ID);

-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 UNIQUE 제약조건 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT UK_DEPT_COPY
UNIQUE(DEPT_TITLE);

-- DEPT_COPY 테이블의 LOCATION_ID 컬럼에 CHECK 제약조건 추가
-- 컬럼에 작성할 수 있는 값은 L1, L2, L3, L4, L5 
-- 제약조건명 : LOCATION_ID_CHK
ALTER TABLE DEPT_COPY ADD CONSTRAINT CK_DEPT_COPY
CHECK (LOCATION_ID IN ('L1','L2','L3','L4','L5'));

--------------------------------------------------------------------------------
-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가
-- * NOT NULL 제약조건은 다루는 방법이 다름
-->  NOT NULL을 제외한 제약 조건은 추가적인 조건으로 인식됨.(ADD/DROP)
-->  NOT NULL은 기존 컬럼의 성질을 변경하는 것으로 인식됨.(MODIFY)
ALTER TABLE DEPT_COPY MODIFY
DEPT_TITLE NOT NULL; -- NULL 관련 설정만 MODIFY 사용
--------------------------------------------------------------------------------

-- DEPT_COPY에 추가한 제약조건 중 PK 빼고 모두 삭제
ALTER TABLE DEPT_COPY DROP CONSTRAINT CK_DEPT_COPY;
ALTER TABLE DEPT_COPY DROP CONSTRAINT UK_DEPT_COPY;
ALTER TABLE DEPT_COPY DROP CONSTRAINT SYS_C007522; -- NOT NULL
--NOT NULL 제약조건 ADD는 불가능, DROP는 가능

-- NOT NULL 제거 시 MODIFY 사용
ALTER TABLE DEPT_COPY 
MODIFY DEPT_TITLE CONSTRAINT SYS_C007522 NULL;
/*********************************************************************************************/
/*********************************************************************************************/
-- 2. 컬럼 추가/수정/삭제

-- 컬럼 추가 : ALTER TABLE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT '값']);


-- 컬럼 수정 : ALTER TABLE 테이블명 MOIDFY 컬럼명 데이터타입;   (데이터 타입 변경)
--             ALTER TABLE 테이블명 MOIDFY 컬럼명 DEFAULT '값'; (기본값 변경)

--> ** 데이터 타입 수정 시 컬럼에 저장된 데이터 크기 미만으로 변경할 수 없다.


-- 컬럼 삭제 : ALTER TABLE 테이블명 DROP (삭제할컬럼명);
--             ALTER TABLE 테이블명 DROP COLUMN 삭제할컬럼명;

--> ** 테이블에는 최소 1개 이상의 컬럼이 존재해야 되기 때문에 모든 컬럼 삭제 X

-- 테이블이란? 행과 열로 이루어진 데이터베이스의 가장 기본적인 객체


-- (추가)
-- DEPT_COPY 컬럼에 CNAME VARCHAR2(20) 컬럼 추가
-- ALTER TABLE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT '값']);
ALTER TABLE DEPT_COPY 
ADD(CNAME VARCHAR2(20));

SELECT * FROM DEPT_COPY;

-- (추가)
-- DEPT_COPY 테이블에 LNAME VARCHAR2(30) 기본값 '한국' 컬럼 추가
ALTER TABLE DEPT_COPY 
ADD(LNAME VARCHAR2(20)DEFAULT '한국');
--> 샐 추가된 컬럼 LNAME에 기본값 '한국'이 자동 삽입

SELECT * FROM DEPT_COPY;

-- (수정)
-- DEPT_COPY 테이블의 DEPT_ID 컬럼의 데이터 타입을 CHAR(2) -> VARCHAR2(3)으로 변경
-- ALTER TABLE 테이블명 MOIDFY 컬럼명 데이터타입;
ALTER TABLE DEPT_COPY 
MODIFY DEPT_ID VARCHAR(3);

-- (수정 에러 상황)
-- DEPT_TITLE 컬럼의 데이터타입을 VARCHAR2(10)으로 변경
ALTER TABLE DEPT_COPY 
MODIFY DEPT_TITLE VARCHAR(10);
-- ORA-01441: 일부 값이 너무 커서 열 길이를 줄일 수 없음
-- 이미 저장된 값이 수정하는 데이터 타입의 크기보다 크면 수정 불가능

-- (기본값 수정)
-- LNAME 기본값을 '한국' -> '대한민국' 으로 변경
-- ALTER TABLE 테이블명 MOIDFY 컬럼명 DEFAULT '값'; 
ALTER TABLE DEPT_COPY 
MODIFY LNAME DEFAULT '대한민국';

SELECT * FROM DEPT_COPY;

-- DEPT_COPY의 LNAME 컬럼의 모든 값을 기본값으로 수정
UPDATE DEPT_COPY
SET LNAME = DEFAULT;

-- (삭제)
-- DEPT_COPY에 추가한 컬럼(CNAME, LNAME) 삭제
-->  ALTER TABLE 테이블명 DROP(삭제할컬럼명);
ALTER TABLE DEPT_COPY DROP(CNAME);

SELECT * FROM DEPT_COPY;

-->  ALTER TABLE 테이블명 DROP COLUMN 삭제할컬럼명;
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;

SELECT * FROM DEPT_COPY;

-- 컬럼 삭제의 문제점
-- 테이블은 최소 1개 이상의 컬럼이 존재해야한다
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;
ALTER TABLE DEPT_COPY DROP COLUMN LOCATION_ID;

SELECT * FROM DEPT_COPY;

-- 마지막 남은 DEPT_ID 컬럼 삭제 시도
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;
-- ORA-12983: 테이블에 모든 열들을 삭제할 수 없습니다


-- * DDL / DML을 혼용해서 사용할 경우 발생하는 문제점
-- DML을 수행하여 트랜잭션에 변경사항이 저장된 상태에서
-- COMMIT/ROLLBACK 없이 DDL 구문을 수행하게되면
-- DDL 수행과 동시에 선행 DML이 자동으로 COMMIT 되어버림.

--DML (Data Manipulation Language) 데이터 조작 (테이블의 값을 INSERT, UPDATE, DELETE)
--DDL (Data Definition Language) 데이터 정의 (객체를 CREATE, DROP, ALTER)
--DCL (Data Control Language) 데이터 제어 GRANT, REVOKE
--TCL (Transaction Control Language) 트랜젝션 제어(DML 수행 내용을 COMMIT, ROLLBACK)


--> 결론 : DML/DDL 혼용해서 사용하지 말자!!!

INSERT INTO DEPT_COPY VALUES('D0'); -- 'D0' 삽입
SELECT * FROM DEPT_COPY;
ROLLBACK; -- 트랜잭션에서 'D0' INSERT 내용을 삭제
SELECT * FROM DEPT_COPY;


INSERT INTO DEPT_COPY VALUES('D0'); -- 'D0' 삽입
SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY MODIFY DEPT_ID VARCHAR2(4); -- DDL 수행
ROLLBACK;
SELECT * FROM DEPT_COPY; -- 'D0'가 사라지지 않음

-- 결론 : DML 과 DDL 은 혼용해서 작성 금지
/*********************************************************************************************/
/*********************************************************************************************/
-- 3. 테이블 삭제

-- [작성법]
-- DROP TABLE 테이블명 [CASCADE CONSTRAINTS];

CREATE TABLE TB1(
    TB1_PK NUMBER PRIMARY KEY,
    TB1_COL NUMBER
);

CREATE TABLE TB2(
    TB2_PK NUMBER PRIMARY KEY,
    TB2_COL NUMBER REFERENCES TB1 -- TB1 테이블의 PK 값을 참조
);

-- 일반 삭제(DEPT_COPY)
DROP TABLE DEPT_COPY; -- Table DEPT_COPY이(가) 삭제되었습니다.

-- ** 관계가 형성된 테이블 중 부모테이블(TB1) 삭제 **
DROP TABLE TB1;
-- ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다 
--> 다른 테이블이 TB1 테이블을 참조하고 있어서 삭제 불가능.

-- 해결 방법 1 : 자식 -> 부모 테이블 순서로 삭제하기
-- (참조하는 테이블이 없으면 삭제 가능)
DROP TABLE TB2;
DROP TABLE TB1; -- 삭제 성공

-- 해결 방법 2 : CASCADE CONSTRAINTS 옵션 사용
--> 제약조건까지 모두 삭제 
-- == FK 제약조건으로 인해 삭제가 원래는 불가능 하지만, 제약조건을 없애버려서 FK 관계를 해제
DROP TABLE TB1 CASCADE CONSTRAINTS; -- 삭제 성공
DROP TABLE TB2;     
/*********************************************************************************************/
/*********************************************************************************************/

-- 4. 컬럼, 제약조건, 테이블 이름 변경(RENAME)

-- 테이블 복사
CREATE TABLE DEPT_COPY AS SELECT * FROM DEPARTMENT; 

-- 복사한 테이블에 PK 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT PK_DCOPY PRIMARY KEY(DEPT_ID);

-- 1) 컬럼명 변경 : ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 변경명;
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;
SELECT * FROM DEPT_COPY;

-- 2) 제약조건명 변경 : ALTER TABLE 테이블명 RENAME CONSTRAINT 제약조건명 TO 변경명;
ALTER TABLE DEPT_COPY RENAME CONSTRAINT PK_DCOPY TO DEPT_COPY_PK;

-- 3) 테이블명 변경 : ALTER TABLE 테이블명 RENAME TO 변경명;
ALTER TABLE DEPT_COPY RENAME TO DCOPY;
SELECT * FROM DCOPY;
SELECT * FROM DEPT_COPY; -- 이름이 변경되어 DEPT_COPY 테이블명으로 조회 불가
/*********************************************************************************************/
/*********************************************************************************************/

/*	VIEW
 * 
 * - 논리적 가상 테이블(행과 열로 이루어진 데이터 저장 장소)
 * 		-> 테이블 모양을 하고있지만, 실제로 값을 저장하고 있지는 않다.
 * - SELECT문의 실행 결과(RESULT SET)를 저장하는 객체
 *
 * 
 * ** VIEW 사용 목적 **
 * 1. 복잡한 SELECT 문을 쉽게 재사용하기 위해
 * 2. 테이블의 진짜 모습을 감출 수 있어 보안상 유리
 * 
 * ** VIEW 사용 시 주의 사항 **
 * 1. 가상의 테이블(실체X)이기 때문에 ALTER 구문 사용 불가
 * 2. VIEW를 이용한 DML(INSERT, UPDATE, DELETE)이 가능한 경우도 있지만 
 * 	  제약이 많이 따르기 때문에 조회(SELECT) 용도로 대부분 사용
 * 
 * ** VIEW 작성법 **
 * CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름[컬럼 별칭]
 * AS 서브쿼리(SELECT문)
 * [WITH CHECK OPTION]
 * [WITH READ ONLY]
 * 
 * 1. OR REPLACE : 기존 동일한 이름의 VIEW 존재 시 이를 변경,
 * 				   없으면 새로 생성
 * 
 * 2. FORCE | NOFORCE 
 * 		FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성
 * 		NOFORCE(기본값) : 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성
 * 
 * 3. 컬럼 별칭 옵션 : 조회되는 VIEW의 컬럼명 지정
 * 
 * 4. WITH CHECK OPTION : 옵션을 지정한 컬럼의 값을 수정 불가능하게 함
 * 
 * 5. WITH READ ONLY : 뷰에 대해 SELECT만 가능하도록 지정
 * 
 * */

-- EMPLOYEE 테이블에서 모든사원의
-- 사번, 이름, 부서명, 직급명 조회
SELECT EMP_ID ,EMP_NAME ,DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);
--> VIEW 생성

CREATE VIEW V_EMP
AS  SELECT EMP_ID ,EMP_NAME ,DEPT_TITLE, JOB_NAME
	FROM EMPLOYEE
	LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
	JOIN JOB USING (JOB_CODE);

-- ORA-01031 : 권한이 불충분합니다
-->SYS 계정으로 접속

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

--> 각자 계정에 CREATE VIEW 권한 부여
GRANT CREATE VIEW TO KH_CGT;

-- 생성된 VIEW V_EMP 조회
SELECT * FROM V_EMP;

-- V_EMP 수정 (OR REPLACE)
CREATE OR REPLACE VIEW V_EMP
AS  SELECT EMP_ID 사번,EMP_NAME 이름,DEPT_TITLE 부서명, JOB_NAME 직급명
	FROM EMPLOYEE
	LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
	JOIN JOB USING (JOB_CODE);

SELECT * FROM V_EMP;

-- V_EMP에서 직급 대리인 사원의 정보 조회
SELECT * FROM V_EMP
WHERE 직급명 = '대리 ';

-------------------------------------------------------------------------
/* VIEW 를 이용한 DML */

--테이블 복사
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY2;

-- DEPT_COPY2에서
-- DEPT_ID, LOCATION_ID 컬럼만 조회하는
-- VIEW 생성

CREATE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID
	FROM DEPT_COPY2;

SELECT * FROM V_DCOPY2;

-- VIEW 를 이용한 INSERT

INSERT INTO V_DCOPY2
VALUES('D0', 'L3');

SELECT * FROM V_DCOPY2;
-- VIEW는 값을 저장하지 않는다(?)
-- 저장된것처럼 보임

-- 실제 VIEW에 저장된것 아님
-- VIEW 생성 시 사용한 서브쿼리의 테이블(DEPT_COPY2)에
-- 값이 삽입되어있다

-- 원본 테이블(DEPT_COPY2) 확인
SELECT * FROM DEPT_COPY2;
-- D0	NULL	L3
-- 원본 테이블 삽입 확인
-- INSERT 구문에 포함되지 않은 DEPT_TITLE 컬럼은
-- NULL삽입되어 있다.

ROLLBACK;

SELECT * FROM V_DCOPY2;

-- 복사한 테이블(DEPT_COPY2)의
-- DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가

ALTER TABLE DEPT_COPY2 MODIFY
DEPT_TITLE CONSTRAINT TITLE_NN NOT NULL;

-- 다시 VIEW를 이용해 INSERT
INSERT INTO V_DCOPY2
VALUES('D0', 'L3');
-- > 원본 테이블 DEPT_COPY2에 DEPT_ID, LOCATION_ID 컬럼에 ('D0', 'L3')를 삽입
-- > DEPT_TITLE 컬럼에는 NULL 삽입
-- > BUT DEPT_TITLE에는 NOT NULL 제약조건 설정이 되어
-- > NULL 값 삽입 불가능

-- ORA-01400: NULL을 ("KH_CGT"."DEPT_COPY2"."DEPT_TITLE") 
-- 안에 삽입할 수 없습니다

-- 데이터 무결성 : 중복 X, NULL X --> 신뢰도 높은 데이터
-- 대부분의 컬럼에 NOT NULL 제약조건이 추가되어 있음
-- NOT NULL이 설정된 테이블을 이용해서 VIEW를 만들면
-- INSERT 거의 불가능

-- 결론 : VIEW 가지고 DML 수행하는 행동 지양

---------------------------------------------

/* WITH READ ONLY 추가*/

-- 읽기전용 X, VIEW 변경
CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID
FROM DEPT_COPY2;

INSERT INTO V_DCOPY2
VALUES ('D0', '기획팀', 'L3');

ROLLBACK;

-- 읽기전용 O, VIEW 변경
CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID
FROM DEPT_COPY2
WITH READ ONLY;


INSERT INTO V_DCOPY2
VALUES ('D0', '기획팀', 'L3');
-- ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.

-----------------------------------------------------------------------

/* SEQUENCE(순서, 연속)
 * - 순차적으로 일정한 간격의 숫자(번호)를 발생시키는 객체
 * EX)게시글 번호
 * *** SEQUENCE 왜 사용하나 ***
 * PRIMARY KEY(기본키) : 테이블 내 각 행을 구별하는 식별자 역할
 * 						NOT NULL && UNIQUE의 의미를 가짐 
 * 
 * PK 가 지정된 컬럼에 삽입될 값을 생성할때 SEQUENCE를 이용하면 좋다
 * 
 *******************************************************************
  [작성법]
  
  CREATE SEQUENCE 시퀀스이름
  [STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트

-- 시퀀스의 캐시 메모리는 할당된 크기만큼 미리 다음 값들을 생성해 저장해둠
-- --> 시퀀스 호출 시 미리 저장되어진 값들을 가져와 반환하므로 
--     매번 시퀀스를 생성해서 반환하는 것보다 DB속도가 향상됨.

 ********************************************************************
 * 
 * ** 사용법 **
 * 
 * 1. 시퀀스명.NEXTVAL : 다음 시퀀스 번호를 얻어옴
 * 					  (INCREMENT BY 만큼 증가된 수)
 * 					  단, 생성 후 처음 호출된 시퀀스인 경우
 * 					  START WITH에 작선된 값이 반환됨
 * 
 * 2. 시퀀스명.CURRVAL : 현재 시퀀스 번호를 얻어옴
 * 					  단, 시퀀스가 생성 되자마자 호출할 경우 오류 발생
 * 					  == 마지막으로 호출한 NEXTVAL 값을 반환
 * */

-- 테이블 생성
CREATE TABLE TB_TEST(
	TEST_NO NUMBER PRIMARY KEY,
	TEST_NAME VARCHAR2(30) NOT NULL
);

-- 시퀀스 생성
CREATE SEQUENCE SEQ_TEST_NO
START WITH 100 -- 100번부터 시작
INCREMENT BY 5 -- 5씩 증가
MAXVALUE 150   -- 최대값 150
NOMINVALUE	   -- 최소값 없음
NOCYCLE		   -- 반복X
NOCACHE;       -- 미리 만들어두는 숫자 없음


-- 시퀀스 생성 확인
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL;

SELECT SEQ_TEST_NO.CURRVAL FROM DUAL;
-- ORA-08002: 시퀀스 SEQ_TEST_NO.CURRVAL은 이 세션에서는 정의 되어 있지 않습니다


-- 다시 NEXTVAL 호출
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL;
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL;
SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL;

-- TB_TEST에 값 삽입
INSERT INTO TB_TEST VALUES(SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL);


SELECT * FROM TB_TEST;

-- INSERT 추가 수행
INSERT INTO TB_TEST VALUES(SEQ_TEST_NO.NEXTVAL, '홍길동' || SEQ_TEST_NO.CURRVAL);

SELECT * FROM TB_TEST;


-- UPDATE에 시퀀스 사용
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);

-- UPDATE 확인
SELECT * FROM TB_TEST;

-- UPDATE 추가수행
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);
-- 시퀀스 SEQ_TEST_NO.NEXTVAL exceeds MAXVALUE은 사례로 될 수 없습니다
-- SEQUENCE MAXVALUE 초과 (MAXVALUE 150)



-- 가장 마지막 TEST_NO를 조회하는 SELECT 
SELECT MAX(TEST_NO)
FROM TB_TEST;

SELECT * FROM
	(SELECT TEST_NO
	FROM TB_TEST
	ORDER BY TEST_NO DESC)
WHERE ROWNUM = 1;

----------------------------------------------------------

-- SEQUENCE 변경(ALTER)
/*
  *[STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본*
  *변경 불가 (처음 만들때만 설정 가능)
  
  
  [작성법]
  
  ALTER SEQUENCE 시퀀스이름
  
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
*/


-- SEQ_TEST_NO의 증가값을 1, 최대값 155로 수정
ALTER SEQUENCE SEQ_TEST_NO
INCREMENT BY 1
MAXVALUE 155;

--UPDATE 구문 재 실행
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL,
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);

-- UPDATE 확인
SELECT * FROM TB_TEST;

----------------------------------------------------------------------------------

--VIEW, SEQUENCE 삭제

DROP VIEW V_DCOPY2; -- VIEW 삭제
DROP SEQUENCE SEQ_TEST_NO; -- SEQUENCE 삭제
-- 시퀀스는 START WITH 를 변경하고 싶을때 삭제 후 다시 생성해야됨
-- 수정도 마찬가지
----------------------------------------------------------------------------------

/* INDEX(색인)
 * - SQL 구문 중 SELECT 처리 속도를 향상 시키기 위해 
 * 	 컬럼에 대하여 생성하는 객체
 * 
 * - 인덱스 내부 구조는 B* 트리 형식으로 되어있음.
 * B : BINARY
 * 
 * ** INDEX의 장점 **
 * - 이진 트리 형식으로 구성되어 자동 정렬 및 검색 속도 증가.
 * - 조회 시 테이블의 전체 내용을 확인하며 조회하는 것이 아닌
 * 	 인덱스가 지정된 컬럼만을 이용해서 조회하기 때문에 
 * 	 시스템의 부하가 낮아짐
 * 
 * ** INDEX의 단점 **
 * - 데이터 변경(INSERT, UPDATE, DELETE) 작업 시
 * 	 이진 트리 구조에 변형이 일어남
 * 	 -> DML 작업이 빈번한 경우 시스템 부하가 늘어 성능 저하
 * 
 * - 인덱스도 하나의 객체, 별도 저장공간이 필요(메모리 소비)
 * - 인덱스 생성 시간이 필요함.
 * 
 * 
 * [작성법]
 * CREATE [UNIQUE] INDEX 인덱스명
 * ON 테이블명(컬럼명[, 컬럼명 | 함수명]);
 * 
 * DROP INDEX 인덱스명;
 *
 * ** 인덱스 자동 생성 되는 경우 **
 * -> PK 또는 UNIQUE 제약조건이 설정된 컬럼에 대해
 * 	  UNIQUE INDEX가 자동으로 생성된다
 * */

--INDEX를 사용X 검색
SELECT * FROM EMPLOYEE
WHERE EMP_NAME != '0';


--INDEX를 사용O 검색
--> WHERE에 INDEX가 설정된 컬럼을 언급
SELECT * FROM EMPLOYEE
WHERE EMP_ID != '0';
--> 데이터 적어서 차이 식별 불가


-- 인덱스 확인용 테이블 생성
CREATE TABLE TB_INDEX_TEST(
	TEST_NO NUMBER PRIMARY KEY, -- UNIQUE INDEX 자동생성
	TEST_ID VARCHAR(20) NOT NULL
);

-- TB_INDEX_TEST 테이블에 샘플데이터 100만개 삽입
-- (PL/SQL 사용)

BEGIN
	FOR I IN 1..1000000
	LOOP
		INSERT INTO TB_INDEX_TEST
		VALUES (I, 'TEST' || I);
	END LOOP;

	COMMIT;
END;

--INDEX를 사용X 검색
SELECT * FROM TB_INDEX_TEST
WHERE TEST_ID = 'TEST500000'; -- 20 ~ 30


--INDEX를 사용O 검색
--> WHERE에 INDEX가 설정된 컬럼을 언급
SELECT * FROM TB_INDEX_TEST
WHERE TEST_NO = 500000; -- 0 ~ 3

-- TEST_ID 컬럼에 대한 인덱스 생성
CREATE INDEX IDX_TEST_ID
ON TB_INDEX_TEST(TEST_ID);

-- 인덱스 생성 후 조회
SELECT * FROM TB_INDEX_TEST
WHERE TEST_ID = 'TEST500000'; -- 26/1/0/1/0/0

----------------------------------------------

-- 인덱스 삭제
DROP INDEX IDX_TEST_ID;
-- 테이블 삭제
DROP TABLE TB_INDEX_TEST;

