
-- 1. 영어영문학과 학생들 학번 이름 입학년도, 입학년도 오름차순 정렬

SELECT STUDENT_NO "학번", STUDENT_NAME "이름", TO_CHAR(ENTRANCE_DATE, 'YYYY-MM-DD') AS "입학년도"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY ENTRANCE_DATE;


-- 2. 춘 대학 교수 이름 3글자 아닌 교수의 이름 주민번호 출력
SELECT PROFESSOR_NAME ,PROFESSOR_SSN 
FROM TB_PROFESSOR
WHERE LENGTH(PROFESSOR_NAME) != 3;

-- 3. 춘 대학 남교수 이름 나이 출력 '만 계산'

SELECT PROFESSOR_NAME "교수이름", TRUNC(ABS(MONTHS_BETWEEN(SYSDATE, TO_DATE('19' || SUBSTR(PROFESSOR_SSN,1,6))) / 12)) "나이"
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = '1'
ORDER BY "나이" ;



-- 4. 교수 이름 만 출력(성 2개 없음)
SELECT SUBSTR(PROFESSOR_NAME,2) "이름"
FROM TB_PROFESSOR;


-- 5. 춘 대학교 재수생 입학자 학번 이름 (19살 입학이면 재수 아님)

SELECT STUDENT_NO , STUDENT_NAME 
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN,1,6))) > 19;


-- 6. 2020년의 크리스마스는 무슨 요일인가
SELECT TO_CHAR(TO_DATE('20201225','YYYYMMDD'),'YYYY/MM/DD(DAY)')
FROM DUAL;


/* 7. 	TO_DATE('99/10/11', 'YY/MM/DD') 몇년 몇월 몇일
		TO_DATE('49/10/11', 'YY/MM/DD')	몇년 몇월 몇일
		TO_DATE('99/10/11', 'RR/MM/DD')	몇년 몇월 몇일
		TO_DATE('49/10/11', 'RR/MM/DD')	몇년 몇월 몇일
*/
SELECT TO_DATE('99/10/11', 'YY/MM/DD') "99/10/11  YY/MM/DD",
		TO_DATE('49/10/11', 'YY/MM/DD')	"49/10/11  YY/MM/DD",
		TO_DATE('99/10/11', 'RR/MM/DD')	"99/10/11  RR/MM/DD",
		TO_DATE('49/10/11', 'RR/MM/DD')	"49/10/11  RR/MM/DD"
FROM DUAL;




























































































































































