// ----------------------------------------------- 비밀번호 유효성 검사 시작 -----------------------------------------------
// 비밀번호/비밀번호 확인 유효성 검사
const newMemberPw = document.getElementById("newMemberPw");
const newMemberPwConfirm = document.getElementById("newMemberPwConfirm");
const pwMessage1 = document.getElementById("pwMessage1");
const pwMessage2 = document.getElementById("pwMessage2");

const checkObj1 = {
  "newMemberPw" : false,
  "newMemberPwConfirm" : false
};

if(newMemberPw != null){
    // 비밀번호 입력 시 유효성 검사
    newMemberPw.addEventListener("input", (e) => {

        // 비밀번호가 입력되지 않은 경우
        if(newMemberPw.value.trim().length == 0){
            newMemberPw.value = ""; // 띄어쓰지 못넣게 하기

            pwMessage1.innerText = "8글자 이상의 영어, 숫자, 특수문자를 포함한 비밀번호를 입력해 주세요.";
            pwMessage1.classList.remove("confirm", "error"); // 검정 글씨

            checkObj1.newMemberPw = false; // 빈칸 == 유효 X
            return;
        }

        // 정규 표현식을 이용한 비밀번호 유효성 검사

        // 8~ 영문 소문자, 최소 1개의 숫자 혹은 특수 문자 포함
        const regEx = /^(?=.*[a-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-z\d$@$!%*#?&]{8,}$/;

        // 입력한 비밀번호가 유효한 경우
        if(regEx.test(newMemberPw.value)){
            checkObj1.newMemberPw = true; 
            
            // 비밀번호가 유효하게 작성된 상태에서
            // 비밀번호 확인이 입력되지 않았을 때
            if(newMemberPwConfirm.value.trim().length == 0){

                pwMessage1.innerText = "유효한 비밀번호 형식입니다";
                pwMessage1.classList.add("confirm");
                pwMessage1.classList.remove("error");
            
            }else{
                // 비밀번호가 유효하게 작성된 상태에서
                // 비밀번호 확인이 입력되어 있을 때

                // 비밀번호 == 비밀번호 확인  (같을 경우)
                if(newMemberPw.value == newMemberPwConfirm.value){
                    pwMessage2.innerText = "비밀번호가 일치합니다";
                    pwMessage2.classList.add("confirm");
                    pwMessage2.classList.remove("error");
                    checkObj1.newMemberPwConfirm = true;
                    
                    
                } else{ // 다를 경우
                    pwMessage2.innerText = "비밀번호가 일치하지 않습니다";
                    pwMessage2.classList.add("error");
                    pwMessage2.classList.remove("confirm");
                    checkObj1.newMemberPwConfirm = false;
                }
            }

            
        } else{ // 유효하지 않은 경우
            
            pwMessage1.innerText = "비밀번호 형식이 유효하지 않습니다";
            pwMessage1.classList.add("error");
            pwMessage1.classList.remove("confirm");
            checkObj1.newMemberPw = false; 
        }
    });


    // 비밀번호 확인 유효성 검사
    newMemberPwConfirm.addEventListener('input', ()=>{

        if(checkObj1.newMemberPw){ // 비밀번호가 유효하게 작성된 경우에

            // 비밀번호 == 비밀번호 확인  (같을 경우)
            if(newMemberPw.value == newMemberPwConfirm.value){
                pwMessage2.innerText = "비밀번호가 일치합니다";
                pwMessage2.classList.add("confirm");
                pwMessage2.classList.remove("error");
                checkObj1.newMemberPwConfirm = true;
                
            } else{ // 다를 경우
                pwMessage2.innerText = "비밀번호가 일치하지 않습니다";
                pwMessage2.classList.add("error");
                pwMessage2.classList.remove("confirm");
                checkObj1.newMemberPwConfirm = false;
            }

        } else { // 비밀번호가 유효하지 않은 경우
            checkObj1.newMemberPwConfirm = false;
        }
    });
}
// ----------------------------------------------- 비밀번호 유효성 검사 끝 -----------------------------------------------







































