const container = document.getElementById("container");

document.getElementById("createBtn").addEventListener("click", ()=>{
    const arr = new Array();

    while(arr.length < 6){//랜덤 + 중복검사
        const random = Math.floor(Math.random() * 45)+1;
        if(arr.indexOf(random) == -1){//indexOf 값이 일치하는 요소의 index 반환(없으면 -1)
            arr.push(random);
        }
    }
///////////////////////////////////////////////////////////////////////
    // for(let i = 0; i < 6; i++){//랜덤 배치
    //     arr[i] = Math.floor(Math.random() * 45)+1;
    // }

    // for(let i = 0; i < 6; i++){//중복 변경(함수 안쓰고)
    //     for(let j = 0; j < i; j++){
    //         if (arr[i] == arr[j]/* && i != j*/) {
    //             arr[i] = Math.floor(Math.random() * 45)+1;
    //         }
    //     }
    // }
    
    arr.sort((a,b) => a-b);

    for(let i = 0; i < 6; i++){
        container.children[i].innerHTML = arr[i];
    }
});

