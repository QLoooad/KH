-- 함수 : 컬럼의 값을 읽어서 연산 결과를 반환

-- 단일행 함수 : N개의 행의 값을 전다라여 N개의 결과를 반환

-- 그룹 함수 : N개의 행의 값을 하나의 그룹으로 묶어 
--			그룹 수 만큼의 결과를 반환

-- 함수는 SELECT절, WHERE절, ORFER BY 절, GROUP BY절, HAVING절 사용 가능
/*********  단일행 함수  ***********/
-- <문자열 관련 함수>
-- LENGTH(문자열 | 컬럼명) : 문자열 길이 반환
SELECT 'HELLO WORLD', LENGTH ('HELLO WORLD') FROM DUAL;

-- EMPLOYEE 테이블에서 이메일이 12글자인 사원의
-- 이름, 이메일 조회
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE LENGTH(EMAIL) = 12;

-- EMPLOYEE 테이블에서 이메일 길이 오름차순 조회
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
ORDER BY LENGTH(EMAIL) ASC;

---------------------------------------------------
--[] << 생략
-- INSTR(문자열 | 컬럼명, '찾을 문자열' [, 찾을 시작 위치[, 순번]])
-- 찾을 시작 위치부터 지정된 순번째에 찾을 문자열의 시작 위치 반환

-- 문자열에서 맨 앞에 있는 B의 위치 조회+
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B') FROM DUAL; --3

-- 문자열을 5번째 부터 검색하여 처음 찾는 B의 위치 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B', 5) FROM DUAL; --9

-- 문자열을 5번째 부터 검색하여 두번째 찾는 B의 위치 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B', 5, 2) FROM DUAL; --10
                            --123456789012
-- EMPLOYEE 테이블에서
-- 사원명, 이메일, 이메일 중 '@' 위치 조회
SELECT EMP_NAME, EMAIL, INSTR(EMAIL, '@')
FROM EMPLOYEE;
----------------------------------------------------

-- SUBSTR(문자열|컬럼명, 시작 위치[, 길이])
-- 문자열을 시작 위치부터 지정된 길이 만큼 잘라내서 반환
-- 길이 미작성 시 시작 위치부터 끝까지 잘라내 반환
SELECT SUBSTR('ABCDEF', 3,3) FROM DUAL; --CDE
SELECT SUBSTR('ABCDEF', 3) FROM DUAL; --CDEF

-- EMPLOYEE 테이블에서
-- 사원명, 사원의 이메일 아이디만 조회
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 아이디
FROM EMPLOYEE
ORDER BY 아이디;
----------------------------------------------------
-- TRIM([[옵션] 문자열 | 컬럼명 FROM ] 문자열 | 컬럼명)
-- 주어진 문자열의 앞|뒤|양쪽에 존재하는 지정된 문자열 제거

-- 옵션 : LEADING(앞), TRAILING(뒤), BOTH(양쪽, 기본값)

SELECT '     K H     ', 
TRIM(LEADING ' ' FROM '     K H     '),	--K H     ;
TRIM(TRAILING ' ' FROM '     K H     '),--     K H;
TRIM(BOTH ' ' FROM '     K H     ')		--K H;
FROM DUAL; --     K H;

SELECT '#####K H#####', 
TRIM(LEADING '#' FROM '#####K H#####'),--K H#####;
TRIM(TRAILING '#' FROM '#####K H#####'),--#####K H;
TRIM(BOTH '#' FROM '#####K H#####')--K H;
FROM DUAL; --     K H;

--문자열 앞뒤 공백 제거(해당 용도로 가장 많이 사용)
SELECT TRIM('     K H     ') FROM DUAL;--K H;
----------------------------------------------------

-- REPLACE(문자열 | 컬럼명, 찾을 문자열, 바꿀 문자열)
-- 찾을 문자열을 바꿀 문자열로 변경하여 문자열 반환

SELECT REPLACE(NATIONAL_NAME, '한국', '대한민국')  
FROM NATIONAL;

SELECT REPLACE(NATIONAL_NAME, '국', '대한민국')  
FROM NATIONAL;
----------------------------------------------------

-- <숫자 관련 함수>

-- MOD(숫자 | 컬럼명, 숫자|컬럼명) 나머지 값 반환
SELECT EMP_NAME, MOD(SALARY, 1000000) 
FROM EMPLOYEE;

-- ABS(숫자 | 컬럼명) : 절대값
SELECT ABS(10), ABS(-10) FROM DUAL;

-- CEIL(숫자 | 컬럼명) : 올림
-- FLOOR(숫자 | 컬럼명) : 내림
-- > 둘 다 소수점 첫째 자리에서 처리 > 정수 결과 반환

SELECT 123.5, CEIL(123.5), FLOOR(123.5) FROM DUAL; 

-- ROUND(숫자 | 컬럼명 [, 소수점 위치]) : 반올림
-- 소수점 위치 지정 X : 첫째 자리에서 반올림 > 정수 반환
-- 소수점 위치 지정 O : 
-- 지정위치
-- 1) 양수 : 지정된 위치의 소수점 까지 표현
-- 2) 음수 : 지정된 위치의 정수 자리수 까지 표현

SELECT 123.456,
ROUND(123.456),		--소수점 첫째 자리
ROUND(123.456, 1),	--소수점 첫째 자리까지 표현
ROUND(123.456, 2),	--소수점 둘째 자리까지 표현
ROUND(123.456, 0),	--소수점 제로 자리까지 표현 > 정수
ROUND(123.456, -1),	--소수점 -1번째 자리까지 표현 == 정수 1의 자리 반올림
ROUND(123.456, -2)	--소수점 -2번째 자리까지 표현 == 정수 10의 자리 반올림
FROM DUAL;

----------------------------------------------------------

-- TRUNC(숫자 | 컬럼명 [, 소수점 위치]) : 잘라내기, 버림, 절삭

SELECT TRUNC(123.456),
TRUNC(123.456, 1),
TRUNC(123.456, -1)
FROM DUAL;

SELECT FLOOR(-123.5), TRUNC(-123.5)
FROM DUAL;

SELECT EMP_NAME, TRUNC(SALARY, -6) || '이상' 급여
FROM EMPLOYEE;

---------------------------------------------------------------------
---------------------------------------------------------------------

-- <날짜 관련 함수>
-- SYSDATE : 시스템에 현재 시간(년월일시분초)반환
-- SYSTIMESTAMP : SYSDATE 반환값 +  MS 단위 추가
SELECT SYSDATE, SYSTIMESTAMP  FROM DUAL;
-- 2023-03-07 12:22:45.000	 2023-03-07 12:22:45.144 +0900

---------------------------------------------------------------------
-- MONTH_BETWEEN(날짜, 날짜) : 두 날짜의 개월 수 차이 반환
SELECT '약 ' || ROUND(MONTHS_BETWEEN('20230714', '20230206'), 3) || '개월' 훈련기간
FROM DUAL;

--EMPLOYEE 테이블에서 사원 이름, 입사일, 근무 n년차, 근속 개월 수
SELECT EMP_NAME, HIRE_DATE
	, CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12) "근무 N년차"
	, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) "근속 개월 수"
FROM EMPLOYEE;

---------------------------------------------------------------------
-- ADD_MONTHS(날짜, 숫자) : 날짜에 숫자 만큼의 개월 수를 더하여 반환

SELECT ADD_MONTHS(SYSDATE, -1), SYSDATE , ADD_MONTHS(SYSDATE, 1)
FROM DUAL;

-- LAST_DAY(날짜) : 해당 월의 마지막 날짜를 반환
SELECT LAST_DAY(SYSDATE), LAST_DAY('20230401') 
FROM DUAL;
---------------------------------------------------------------------
-- EXTRACT(YEAR|MONTH|DAY FROM 날짜)
--- 날짜에서 년|월|일 추출 후 정수 반환 

--EMPLOYEE 테이블에서 각 사원의 이름, 입사 년, 월, 일 조회
--단 2000년 이상 입사 사원만 조회
SELECT EMP_NAME 이름, 
		EXTRACT (YEAR FROM HIRE_DATE) 년,
		EXTRACT (MONTH FROM HIRE_DATE) 월,
		EXTRACT (DAY FROM HIRE_DATE) 일
FROM EMPLOYEE
WHERE EXTRACT (YEAR FROM HIRE_DATE) >= 2000;

---------------------------------------------------------------------

-- <형변환 함수>
-- 문자열(CHAR) <-> 숫자(NUMBER)
-- 문자열(CHAR) <-> 날짜(DATE)

-- 숫자(NUMBER) -> 날짜(DATE)

/* TO_CHAR(날짜 | 숫자[, 포맷]) : 문자열로 변환
 * 
 * 숫자 -> 문자열
 * 1) 9 : 숫자 한 칸을 의미, 오른쪽 정렬 9999(4칸) 100
 * 2) 0 : 숫자 한 칸을 의미, 오른쪽 정렬, 빈 칸에 0을 추가
 * 3) L : 현재 시스템이나 DB에 설정된 나라의 화폐 기호
 * 4) , : 숫자의 자릿수 구분
 * */

SELECT 1234, 
TO_CHAR(1234, '99999'),	-- 1234  
TO_CHAR(1234, '00000')  --01234
FROM DUAL;

SELECT 1000000, 
	TO_CHAR(1000000, 'L9999999'),	--￦1000000
	TO_CHAR(1000000, '$9999999'),	--$1000000
	TO_CHAR(1000000, '$9,999,999') 	-- $1,000,000
FROM DUAL;

-- EMPLOYEE 테이블에서
-- 사번, 이름, 연봉 조회(￦100,000,000 형식으로 조회)

SELECT EMP_ID, EMP_NAME,
	TO_CHAR(SALARY * 12, 'L999,999,999') 연봉
FROM EMPLOYEE;
--> 숫자를 문자열로 바꿀 때 칸 수가 충분하지 않으면 '#'으로 채워짐

/* 날짜 -> 문자열
 * YY	: 년도(짧게) EX) 23
 * YYYY : 년도(길게) EX) 2023
 * 
 * RR	: 년도(짧게) EX) 23
 * RRRR : 년도(길게) EX) 2023
 * 
 * MM 	: 월
 * DD	: 일
 * 
 * AM/PM: 오전/오후
 * HH	: 시간(12시간)
 * HH24	: 시간(24시간)
 * MI	: 분
 * SS	: 초
 * 
 * DAY 	: 요일(전체) EX) 월요일, MONDAY
 * DY 	: 요일(짧게) EX) 월, MON
 * */

SELECT SYSDATE , TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
SELECT SYSDATE , TO_CHAR(SYSDATE, 'YY-MM-DD DAY HH:MI:SS') FROM DUAL;

-- * 포맷에 포함되지 않는 글자는 "" 내부에 작성
-- 2023년 03월 07일 화요일

SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" DAY') FROM DUAL; 

--SELECT TO_CHAR(SYSDATE, 'YYYY년') FROM DUAL; 
-- SQL Error [1821] [22008]: ORA-01821: 날짜 형식이 부적합합니다
-- ORA-01821 << 에러코드

-- EMPLOYEE 테이블에서 모든 사원 입사일
-- '2023년 03월 07일 (화)' 형식으로 조회

SELECT EMP_NAME , HIRE_DATE ,
	TO_CHAR(HIRE_DATE, 'RRRR"년" MM"월" DD"일" (DY)') 입사일
FROM EMPLOYEE;

---------------------------------------------------------------

-- TO_DATE(문자열, 숫자 [, 포맷])
-- 문자열, 숫자 > 지정된 포팻의 날짜 형식으로 해석 후 DATE 타입 반환

SELECT '2023년 03월 07일', TO_DATE('2023-03-07') FROM DUAL ; 
SELECT TO_DATE('2023년 03월 07일', 'YYYY"년" MM"월" DD"일"') FROM DUAL; 

-- 숫자 > 날짜
SELECT 20230307, TO_DATE(20230307)  FROM DUAL;

/* 날짜 패턴 Y, R 의 차이점 */
-- 년도를 짧게 해석하는 경우 앞부분의 현재 세기를 적용
-- 50 미만 : Y, R 둘다 앞부분에 현재 세기(21C 2000년대) 적용
-- 50 이상 : Y == 현재 세기(2000) 
--			R == 이전 세기(1900)

-- 1949-01-15
-- 1950-01-15
SELECT  TO_DATE('490115', 'YYMMDD'), 
		TO_DATE('490115', 'RRMMDD'), 
		
		TO_DATE('500115', 'YYMMDD'), 
		TO_DATE('500115', 'RRMMDD') 
FROM DUAL; 

-------------------------------------------------------------------

--문자열 > 숫자

SELECT TO_NUMBER('$1,500', '$9,999') FROM DUAL; 

-------------------------------------------------------------------

--<NULL 처리 함수>

-- NVL(컬럼명, 컬럼 값이 NULL일 경우 바꿀 값)
-- 컬럼 값이 NULL 일 경우 지정된 값으로 변경

-- EMPLOYEE 테이블에서 이름, 급여, 보너스, 급여 * 보너스 조회
-- DB에서 NULL과 연산 시 결과값은 모두 NULL
SELECT EMP_NAME , SALARY , NVL(BONUS, 0) , SALARY * NVL(BONUS, 0) 
FROM EMPLOYEE;



-- NVL2(컬럼명, NULL X인 경우 값, NULL O 인 경우 값)

-- EMPLOYEE 테이블에서 
-- 기존에 보너스를 받은 사원 == 0.3
-- 기존에 받았던 사원은 += 0.2

SELECT EMP_NAME , SALARY , NVL2(BONUS, BONUS + 0.2, 0.3) "BONUS", SALARY * NVL2(BONUS, BONUS + 0.2, 0.3) 
FROM EMPLOYEE;
















































































































