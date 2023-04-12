// 인라인 이벤트
function test1(el){// el == element == 전달 받음 요소
    el.style.backgroundColor = 'black';
    el.style.color = 'red';

}

// 고전 이벤트 모델 확인하기

// 아이디가 'test2a'인 요소를 얻어오기
console.log(document.getElementById('test2a').onclick);
// -> null 출력 (아직 click 했을 때 동작할 함수(이벤트 헨들러)가 없음)


document.getElementById('test2a').onclick = function (){
    // function (){} : 익명 함수(이름이 없는 함수)
    //                  재사용 목적이 아닌 특정 이벤트에 대한 기능을 만들 때 주로 사용

    alert("고전 이벤트 모델로 출력된 내용입니다");
}

// test2a의 클릭 이벤트 동작 제거
document.getElementById('test2b').onclick = function (){

    document.getElementById('test2a').onclick = null;
    alert("이번트 제거 완료");
}

// 고전 이벤트 모델 단점 확인하기
// 한 요소에 여러 이벤트 핸들러를 연결할 수 없음
// 마지막으로 작성한 핸들러가 앞서 작성된 핸들러를 덮어씌움
const c = document.getElementById("test2c");// 버튼 요소 얻어옴

c.onclick = function(){
    c.style.backgroundColor = 'pink';

}

c.onclick = function(){
    c.style.fontSize = '40px';

}

// 표준 이벤트 모델 확인하기
/*
    [표준 이벤트 모델 작성 방법]
    
    요소.addEventListener(감지할 이벤트, 이벤트 핸들러);

    ex)
    test3.addEventListener("click", function(){} );
                                    익명 함수
*/
const test3 = document.getElementById("test3");

// #test3 클릭 시 width 를 20px 만큼 증가
test3.addEventListener("click", function(){
    console.log("a");
    // 요소.clientWidth : 요소의 너비(CSS로 지정된 값도 읽어옴, readOnly)
    // 요소.clientHeight : 요소의 높이(CSS로 지정된 값도 읽어옴, readOnly)

    test3.style.width = test3.clientWidth + 20 + "px";
})

test3.addEventListener("click", function(){
    console.log("b");
    // this : 이벤트가 발생한 요소(#test3)
    this.style.height = test3.clientHeight + 20 + "px";
});

test3.addEventListener("click", function(e){
    console.log("c");
    // 이벤트 핸들러의 매개변수 e 또는 event
    // -> 현재 발생한 이벤트에 대한 모든 정보를 담고있는 객체
    // == 이벤트 객체

    // e.target : 이벤트가 발생한 현재 요소 (==this)

    console.log(e);

    const currentWidth = e.target.clientWidth;

    // 현재 너비가 500px을 초과하면 너비 높이를 200px로 초기화

    if(currentWidth > 500 -20){
        e.target.style.width = "200px";
        e.target.style.height = "200px";
    }


    
});


const add = document.getElementById("add");

add.addEventListener("click", function(e){

    const op = e.target.innerText;

    console.log(op);

    const num1 = Number(document.getElementById("num1").value);
    const num2 = Number(document.getElementById("num2").value);

    const result = document.getElementById("result");

    result.innerText = num1 + num2;

    // document.getElementById("result").innerText = new Function("return " + num1 + op.innerText + num2)();

});

const num1 = document.getElementById("num1");
const num2 = document.getElementById("num2");
const result = document.getElementById("result");

// 클래스가 op인 요소를 모두 찾아 배열로 반환
const opList = document.getElementsByClassName("cal");

// for of 구문 (향상된 for문)
// -> 배열(Array), 유사 배열 (HTMLCollection, NodeList,...)
// 위와 같이 배열 형태의 요소를 순차 접근하는 용도의 반복문


for(let op of opList){
    // console.log(opList[i]);
    // 배열의 각 요소 == 각각의 버튼에 click 되었을 때의 동작을 추가
    op.addEventListener("click", function(e){
        result.innerText 
        = new Function("return " + Number(num1.value) + e.target.innerText + Number(num2.value))();
    });
}



// document.getElementById("add").addEventListener("click", function(){
//     result.innerText = Number(num1.value) + Number(num2.value);
// })

// document.getElementById("minus").addEventListener("click", function(e){
//     // result.innerText = Number(num1.value) - Number(num2.value);
//     result.innerText 
//     = new Function("return " + Number(num1.value) + e.target.innerText + Number(num2.value))();
// });


const boxList = document.getElementsByClassName("box");
const colorList = document.getElementsByClassName("color");


for(let i = 0; i < colorList.length; i++){

    colorList[i].addEventListener("keyup", function(e){
        // boxList[i].style.backgroundColor = colorList[i].value;
        boxList[i].style.backgroundColor = e.target.value;
    });

}

for(let color of colorList){
    color.addEventListener("keyup", function(e){
        // previousElementSibling : 이전 형제 요소
        e.target.previousElementSibling.style.backgroundColor = e.target.value;
    });
}

// a태그 기본 이벤트 제거
document.getElementById("moveGoogle").addEventListener("click", function(e){
    // e : 이벤트 객체
    e.preventDefault();// 기본이벤트 막음

    // Default : 기본 / 기본값
    // prevent : 막다 / 예방하다
    
});
///////////////////////////////////////////////////////////////////////////////
// form태그 기본 이벤트 제거1
// ->submit 버튼 없애고
//   일반 button이 클릭 되었을 때 조건이 맞으면 submit 하게 만들기

// document.getElementById("btn").addEventListener("click", function(){

//     const id = document.querySelector("[name = 'id']").value;
//     const pw = document.querySelector("[name = 'pw']").value;

//     if(id == 'user01' && pw == 'pass01'){
//         // id, pw가 일치할 때 form 태그 제출
//         document.testForm.submit();
//     }

// })

// form태그 기본 이벤트 제거2
function fnCheck(){
    const id = document.querySelector("[name = 'id']").value;
    const pw = document.querySelector("[name = 'pw']").value;

    if(id == 'user01' && pw == 'pass01'){
        // id, pw가 일치할 때 return true
        return true;
    }
    return false;
}


// form태그 기본 이벤트 제거2(표준 이벤트 모델)
// -> name이 testForm인 form태그에서 submit이벤트가 발생 했을 때
document.testForm.addEventListener("submit", function(e){
    // e : 이벤트 객체(이벤트 발생 객체)
    e.preventDefault();// 기본이벤트 막기
})
