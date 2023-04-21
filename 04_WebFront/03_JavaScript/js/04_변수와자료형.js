
// 전역 변수
var str = "JS코드를 함수 내부가 아닌 JS파일 또는 script태그에 바로 작성하면 "
            + "HTML 랜더링 시 바로 수행된다.";

// clg 자동완성
console.log(str);

// 변수 선언 위치에 따른 구분
var num1 = 1;
num2 = 2;
// 둘다 전역변수(function 안에 안써서)

console.log("(전)num1 " + num1);
console.log("(전) num2 " + num2);

function testFn(){
    var num3 = 3;   // function 지역 변수
    num4 = 4;       // 전역 변수
    
    console.log("함수 내부에서 선언됨 (함)num3 : " + num3);
    console.log("함수 내부에서 선언됨 (전)num4 : " + num4);

    if(1 == 1){// 무조건 if문 수행
        var num5 = 5;   // function 지역 변수
        num6 = 6;       // 전역 변수
    }
    console.log("if문 종료 후 num5 : " + num5);
    console.log("if문 종료 후 num6 : " + num6);
}

// 함수 호출
testFn();
console.log("num6 : " + num6);

// num3 is not defined(정의 되지 않음 == 존재하지 않거나 접근 불가능)
// console.log("함수 외부에서 선언됨 (함)num3 : " + num3);
// JS 코드 중간에 에러 발생 시 
// 같은 파일/함수 내 에러 이후 부분 코드가 해석되지 않는다.
console.log("함수 외부에서 선언됨 (전)num4 : " + num4);

// 에러 발생
// console.log("if문 종료 후 함수 밖에서 num5 : " + num5);
console.log("if문 종료 후 함수 밖에서 num6 : " + num6);


// var 변수명 중복 확인
var testValue = 10;
console.log(testValue);

var testValue = 20;
console.log(testValue);

// let/const 확인

let let1 = 10;
// let let1 =20; 변수명 중복 x

// const는 let이랑 똑같은데 상수인 점만 다름
const temp = 999;
//tmep = 1000;// TypeError: Cannot read properties of undefined

function testFn2(){
    let let1 = 20;
    let let2 = 200;

    if(1 == 1){
        let let1 = 30;
        let let3 = 300;
    }
    // console.log("if문 내부 let3 : " + let3);
}

testFn2();
// console.log("함수 내부에 선언한 let2" + let2);


// var의 호이스팅(hoisting)
// 변수가 선언되기 전에 사용 가능하게 하는 기술
// error가 발생하지 않고 undefined 발생
console.log("test  " + test);
var test = 10;
console.log("test  " + test);



// 자료형 확인

function typeTest(){

    // typeof 연산자 : 타입 구분용

    const box = document.getElementById("typeBox");
    
    // undefined
    let temp; // 선언 후 값 초기화 X -> undefined
    box.innerHTML = "temp : " + typeof temp;

    // String
    const name = "홍길동";
    box.innerHTML += "<br>name : " + name + " / " + typeof name;
    
    const gender = 'M';
    box.innerHTML += "<br>gender : " + gender + " / " + typeof gender;

    const phone = "01012341234";
    box.innerHTML += "<br>phone : " + phone + " / " + typeof phone;

    // number
    const age = 20;
    const height = 178.9;
    box.innerHTML += "<br>age : " + age + " / " + typeof age;
    box.innerHTML += "<br>height : " + height + " / " + typeof height;

    // boolean
    const isTrue = true;
    box.innerHTML += "<br>isTrue : " + isTrue + " / " + typeof isTrue;


    // object
    // JS의 배열(== Object) [] 사용
    const arr = [10, 20, 30, 40, 50];
    box.innerHTML += "<br>arr : " + arr + " / " + typeof arr;
    // Java -> int[] arr = {10, 20, 30, 40};

    // Java 객체 --> class에 작성된 내용대로, new 연산자로 메모리(heap)에 할당

    // JS 객체 --> {K:V} Map형식으로 작성
    // ** Key는 무조껀 String **
    const user = {"id" : "user01", 'pw':"pass01", address:'서울시 중구' }
    box.innerHTML += "<br>user : " + user + " / " + typeof user;

    console.log(user);// 콘솔로 객체 출력 시
                    //브라우저가 파악하기 쉽게 바꿔서 출력

    // 객체 V 출력 방법(1)
    box.innerHTML += "<br>user.id : " + user.id;                
    box.innerHTML += "<br>user.pw : " + user.pw;                
    box.innerHTML += "<br>user.address : " + user.address;                

    // 객체 V 출력 방법(2)
    box.innerHTML += "<br>user['id'] : " + user['id'];                
    box.innerHTML += "<br>user['pw'] : " + user['pw'];                
    box.innerHTML += "<br>user['address'] : " + user['address'];      


    // function(* 함수 == 자료형 *)
    const sumFn = function(n1, n2){return n1 + n2}

    box.innerHTML += "<br>sumFn : " + sumFn + " / " + typeof sumFn;  

    // 함수명만 작성 : 함수에 작성된 코드가 그대로 출력
    // 함수명() 작성 : 함수 실행(함수 호출)

    box.innerHTML += "<br>sumFn(1, 2) : " + sumFn(1, 2);  

    // doubleFn 함수 호출
    box.innerHTML += "<br>doubleFn(sumFn) : " + doubleFn(sumFn);  
}

function doubleFn(fn){// 전달 받은 함수 결과를 2배로 반환 함수
                //const sumFn = function(n1, n2){return n1 + n2}
    return fn(1, 2) * 2;
}

