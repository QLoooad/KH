document.getElementById("content").addEventListener("input",()=>{

    // input : 입력과 관련된 "모든" 행동
    // input, textarea 등 입력 가능한 요소에 값이 입력되면 인식

    document.getElementById("count").innerText = document.getElementById("content").value.length;

    if(document.getElementById("content").value.length > 100){
        document.getElementById("count").classList.add("error");
    }else{
        document.getElementById("count").classList.remove("error");
    }

    // 요소.classList.toggle("클래스 명")
    // - 요소 클래스 있으면 false, 없으면 true

});

