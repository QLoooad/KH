import React, { useState } from 'react';

const SignupContainer = ()=>{

    const [id, setId] = useState('');
    const [pw, setPw] = useState('');
    const [pwCheck, setPwCheck] = useState('');
    const [name, setName] = useState('');
    const [result, setResult] = useState('');

    // id 중복검사
    const [idValidation, setIdValidation] = useState(false);

    const idCheck = (inputId)=>{

        setId(inputId);

        if(inputId.trim().length < 4){
            setIdValidation(false);
            return;
        }

        fetch("idCheck?id=" + inputId)
        .then(resp => resp.text())
        .then(result => {
            console.log(`result : ${result}`);
            if(result == 0){
                setIdValidation(true);
            }else{
                setIdValidation(false);
            }
        })
        .catch(e => console.log(e));

    }

    // 회원 가입 함수
    const signup = ()=>{

        // 1. 비밀번호 불일치 (pw === pwCheck)
        // '비밀번호가 일치하지 않습니다' alert로 출력 return

        // 2. id === 'user01', pw === 'pass01'
        // 맞으면 result에 '회원 가입 성공' 출력
        // + 모든 입력칸(input) 내용 삭제

        // 아니면 result에 
        // '아이디 또는 비밀번호가 일치하지 않습니다' 출력

        // 아이디가 사용 불가 상태(짧거나 중복)
        if(!idValidation){
            alert("아이디를 다시 입력해주세요");
            return;
        }
    
        if(pw !== pwCheck){
            alert("비밀번호가 일치하지 않습니다");
            return;
        }

        // *** 회원가입 요청(비동기, POST) ***
        fetch("/signup", {
            method : "POST",
            headers : {
                "Content-Type" : "application/json"
            },
            // JS Object -> JSON 변환
            body : JSON.stringify({
                id : id,
                pw : pw,
                name : name
            })
        })
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                setResult('회원 가입 성공');
                setId('');
                setPw('');
                setPwCheck('');
                setName('');
            }else{
                setResult('회원가입 실패');
            }
        })
        .catch(e => console.log(e));

        
        

    };

    return(
        <div className='signup-container'>
            <label>
                ID : <input type='text' onChange={(e)=>{
                        //setId(e.target.value)
                        idCheck(e.target.value)
                    }}
                        value={id}
                        className={idValidation ? "" : "id-error"}
                    />
                    
            </label>
            <label>
                PW : <input type='password' onChange={(e)=>{setPw(e.target.value)}}
                        value={pw}></input>
            </label>
            <label>
                PW CHECK : <input type='password' onChange={(e)=>{setPwCheck(e.target.value)}}
                        value={pwCheck}></input>
            </label>
            <label>
                NAME : <input type='text' onChange={(e)=>{setName(e.target.value)}}
                        value={name}></input>
            </label>
            <button onClick={signup}>가입하기</button>

            <hr/>
            <h3>{result}</h3>
        </div>
    );
}

export default SignupContainer;