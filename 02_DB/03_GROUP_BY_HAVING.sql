SELECT DEPT_CODE -- 23행
FROM EMPLOYEE;

SELECT SUM(SALARY) -- 1행
FROM EMPLOYEE;

-- 부서별 급여 합 조회
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE;

--  ORA-00937: 단일 그룹의 그룹 함수가 아닙니다

SELECT DEPT_CODE, SUM(SALARY) -- 3. 그룹별 SALARY 합계를 조회
FROM EMPLOYEE -- 1. EMPLOYEE 테이블에서
GROUP BY DEPT_CODE; -- 2. DEPT_CODE가 같은 행 끼리 그룹을 지어


---------------------------------------------------------------------------

/* SELECT 문 해석 순서
 * 
 * 5. SELECT 컬럼명, 함수, 계산식, 리터럴 [[AS] 별칭]
 * 1. FROM 테이블명
 * 2. WHERE 조건식
 * 3. GROUP BY 그룹으로 묶을 컬럼명|함수
 * 4. HAVING 그룹함수식을 이용한 조건식 (GROUP BY가 있어야 작성 가능)
 * 6. ORDER BY 컬럼명|별칭|컬럼순서 정렬방식 [NULLS FIRST|LAST] ASC DECSC
 * 
 * */

-- GROUP BY 절 : 같은 값들이 여러개 기록된 행을 하나의 그룹으로 묶음


-- 부서별 급여 평균
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE ;


-- 부서별 급여 합, 평균, 인원 수, 최고참 입사일, 막내 입사일(오름차순)

SELECT DEPT_CODE, SUM(SALARY), ROUND(AVG(SALARY)), COUNT(*), MIN(HIRE_DATE), MAX(HIRE_DATE) 
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE ;



-- 각 직급코드별로 보너스를 받는 사원의 수를 조회
-- 직급코드 오름차순
SELECT JOB_CODE , COUNT(BONUS)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE ;


-- EMPLOYEE 테이블에서 성별과, 성별 별 급여 평균(내림), 급여 합, 인원 수 조회
-- 인원 수 오름차순 정렬

SELECT 	DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', 2, '여자') 성별 
	, FLOOR(AVG(SALARY)) "평균", SUM(SALARY) "급여 합", COUNT(*) "인원 수"  
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', 2, '여자')
ORDER BY "인원 수";



-- WHERE + GROUP BY 
-- WHERE 이 GROUP BY  보다 우선 순위

-- EMPLOYEE 테이블에서 부서코드가 'D5', 'D6' 인 부서의 평균 급여 조회

SELECT DEPT_CODE, AVG(SALARY) 급여평균-- 4. DEPT_CODE 와 급여 평균 조회
FROM EMPLOYEE -- 1. 여기서
WHERE DEPT_CODE IN ('D5', 'D6') -- 2. 부서코드 D5, D6 행만
GROUP BY DEPT_CODE; -- 3. 추려진 결과내 부서별로 그룹을 지어



-- EMPLOYEE 테이블에서 직급별 2000년도(00년 포함) 이후 입사자들의 급여 합 조회
SELECT JOB_CODE, SUM(SALARY) 
FROM EMPLOYEE
WHERE HIRE_DATE >= TO_DATE('2000/01/01') -- TO_DATE() 붙이면 더 좋음 다른 버전, 다른 프로그램에서는 안될수도있음 
--WHERE EXTRACT (YEAR FROM HIRE_DATE) >= 2000
GROUP BY JOB_CODE;

--------------------------------------------------------------------

-- 그룹 내 그룹(소규모 그룹) 만들기

-- EMPLOYEE 테이블에서 부서별로 같은 직급인 사원의 급여합을
-- 부서코드 오른차순으로 조회

SELECT DEPT_CODE ,JOB_CODE ,SUM(SALARY) 
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE  
--        (큰 그룹)   (작은 그룹)
ORDER BY DEPT_CODE;



-- EMPLOYEE 테이블에서 부서별로 급여등급(SAL_LEVEL)같은 직원 수
-- 부서코드 오른차순, 급여 등급 내림차순으로 조회

SELECT DEPT_CODE, SAL_LEVEL 
FROM EMPLOYEE
GROUP BY DEPT_CODE, SAL_LEVEL
ORDER BY DEPT_CODE, SAL_LEVEL DESC;


-----------------------------------------------------------------------------------
-----------------------------------------------------------------------------------

-- HAVING 절 : 그룹함수로 조회할 그룹에 대한 조건 설정 시 사용

-- 부서별 평균 급여 300만 이상인 부서 조회
/*4*/SELECT DEPT_CODE , AVG(SALARY) 
/*1*/FROM EMPLOYEE
/*2*/GROUP BY DEPT_CODE
/*3*/HAVING AVG(SALARY) >= 3000000
/*5*/ORDER BY 1;

-- WHERE	: EMPLOYEE 테이블의 모든 행에 조건을 대입	
-- HAVING	: GROUP BY 에서 묶인 그룹에 대한 조건을 대입

-- 부서별 급여가 300만 이상인 사원들의 평균을 조회
SELECT DEPT_CODE , AVG(SALARY) 
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE 
ORDER BY 1;



-- 부서별 급여 합이 900만을 초과하는 부서의
-- 부서코드, 급여합, 인원 수 조회
SELECT  DEPT_CODE , SUM(SALARY), COUNT(*)  
FROM EMPLOYEE
GROUP BY DEPT_CODE 
HAVING SUM(SALARY) > 9000000;


-- EMPLOYEE 테이들에서 
-- 부서별 70년대생의 급여 평균이 300만 이상인 부서를 조회하여
-- 부서코드, 평균 급여(내림)을 부서코드 내림 차순 조회

SELECT DEPT_CODE , FLOOR(AVG(SALARY)) 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,1,2) >= '70' AND SUBSTR(EMP_NO,1,2) <= '79'
--WHERE SUBSTR(EMP_NO,1,2) BETWEEN '70' AND '79'
--WHERE SUBSTR(EMP_NO,1,2) LIKE '7%'
--WHERE SUBSTR(EMP_NO,1,2) = '7;'
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000
ORDER BY DEPT_CODE DESC;


-- 집계 함수
-- GROUP 절에 작성하여
-- 그룹 별로 산출한 결과를 집계하는 함수
-- ROLLUP, CUBE 가 있음

-- ROLLUP : 그룹별로 중간 집계와 전체 합계를 처리하는 함수
-- CUBE : 그룹으로 지정된 모든 그룹에 대한 중간 집계와 총 합계를 처리하는 함수

-- EMPLOYEE 테이블에서
-- 각 부서에 소속된 직급 별 급여 합
-- 부서 별 급여 합
-- 정체 직원의 급여 합을 조회
SELECT DEPT_CODE, JOB_CODE,  SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP (DEPT_CODE , JOB_CODE)
ORDER BY 1;
--+
SELECT JOB_CODE,  SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

SELECT DEPT_CODE, JOB_CODE,  SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE (DEPT_CODE , JOB_CODE)
ORDER BY 1;


------------------------------------------------------------------------------

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


-- UNION 합집합 확인

-- 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
-- 급여가 300만 초과인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;



-- INTERSECT 교집합 확인

-- 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT 
-- 급여가 300만 초과인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;




-- UNION ALL : 합집합 + 교집합

-- 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL 
-- 급여가 300만 초과인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;




-- MINUS : 차집합

-- 부서코드가 'D5'인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
-- 급여가 300만 초과인 사원의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;



-- 집합 연산은 2개 이상의 SELECT 문에 사용 가능
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'

UNION

SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6'

UNION

SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'

UNION

-- SELECT 절의 타입, 개수, 순서 동일해야 한다

SELECT '이름', 'S' FROM DUAL;




