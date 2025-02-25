<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 프로젝트</title>

</head>
<body>

    <main>
        
        <%-- header.jsp 추가(포함) --%>
        <%-- <jsp:include page="jsp파일 경로"/> 
            - JSP 액션 태그(jsp 기본 내장 태그)
            - 다른 jsp 파일의 코드를 연재 위치에 추가(포함)
            - jsp 파일 경로는 webapp 폴더를 기준으로 작성
        --%>

        <jsp:include page="/WEB-INF/views/common/header.jsp"/>



        <section class="content">
            <section class="content-1">
                <h3>로그인된 회원 정보</h3>

                ${sessionScope.loginMember}

            </section>
            <section class="content-2">

                <c:choose>
                    <%-- 
                        choose 내부에는 c:when, c:otherwise, jsp 주석만 작성 가능

                        c:when, c:otherwise 내부에는 다른 코드 작성 가능
                    --%>

                    <%-- EL empty 연산자 : 비어있거나 null 이면 true --%>
                    <c:when test="${empty sessionScope.loginMember}">
                        <form action="/member/login" method="post" id="loginFrm">
                            <fieldset class="id-fw-area">
                                <section>
                                    <input type="text" name="inputEmail" placeholder="이메일" autocomplete="off">
                                    <input type="password" name="inputPw" placeholder="비밀번호">
                                </section>
                                <section>
                                    <button>로그인</button>
                                </section>
                            </fieldset>

                            <label>
                                <input type="checkbox" name="saveId">아이디 저장
                            </label>

                            <article class="singup-find-area">
                                <a href="#">회원가입</a>
                                <span>|</span>
                                <a href="#">ID/PW 찾기</a>
                            </article>
                        </form>
                    </c:when>

                    <%-- 로그인 성공 시 --%>
                    <c:otherwise>
                        <article class="login-area">
                            <a href="#">
                                <img src="/resources/images/user.png" id="memberProfile">
                            </a>
                            <div class="my-info">
                                <div>
                                    <a href="$" id="nickname">${sessionScope.loginMember.memberNickname}</a>
                                    <a href="/member/logout" id="logoutBtn">로그아웃</a>
                                </div>
                                <p>${loginMember.memberEmail}</p>
                            </div>

                
                        </article>
                    </c:otherwise>


                </c:choose>
            </section>
        </section>

    </main>

    <%-- footer --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    

</body>
</html>