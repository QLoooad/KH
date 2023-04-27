const loginFrm = document.getElementById("loginFrm");

const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']");
const memberPw = document.querySelector("#loginFrm input[name='memberPw']");

// 로그인 시도를 할 때
loginFrm.addEventListener("submit", e =>{

    // form태그 기본 이벤트 제거
    // e.preventDefault();

    // 이메일이 입력되지 않은 경우
    // 문자열.trim() : 문자열 좌우 공백 제거
    if(memberEmail.value.trim().length == 0){
        alert("이메일을 입력해주세요.")

        memberEmail.value="";
        memberEmail.focus(); // 이메일 input 태그에 초점을 맞춤

        e.preventDefault(); // 제출 못하게 하기
        return;
    }
    if(memberPw.value.trim().length == 0){
        alert("비밀번호를 입력해주세요.")

        memberPw.value="";
        memberPw.focus(); // 이메일 input 태그에 초점을 맞춤

        e.preventDefault(); // 제출 못하게 하기
        return;
    }

});