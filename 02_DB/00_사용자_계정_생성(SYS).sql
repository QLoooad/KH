-- 주석

/*범위주석*/

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
--ctrl + enter : 선택한 SQL 수행

--사용자 계정 생성
CREATE USER kh_cgt IDENTIFIED BY "oracle_cgt";

--사용자 계정 권한 부여
GRANT RESOURCE, CONNECT TO kh_cgt;

--객체 생성이 가능한 공간 할당량 지정
ALTER USER kh_cgt DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;
