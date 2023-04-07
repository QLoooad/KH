// 파일 전체가 script 태그

// 한줄 주석
/* 범위 주석 */

function btnClick2(){
    alert("external 버튼 클릭");
}

function darkMode(){
    const body = document.querySelector("body");

    // JS는 카멜 표기법
    body.style.backgroundColor = 'rgb(75,75,75)';
    body.style.color = 'white';
}

function lightMode(){
    const body = document.querySelector("body");

    // JS는 카멜 표기법
    body.style.backgroundColor = 'white';
    body.style.color = 'black';
}