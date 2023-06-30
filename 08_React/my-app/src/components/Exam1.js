import React, { Component } from 'react';
// node_modules 폴더에 있는 react 패키지를 가져옴

// 클래스형 컴포턴트 만들기
// 1. Component 상속 받기
// 2. render() 함수 작성하기(필수)
// 3. 만든 class를 export default 를 지정
class Exam1 extends Component {

    constructor(props) {
        super(props);
        this.state = { count: 0 };
    }
    handleClick = () => {
        this.setState({ count: this.state.count + 1 });
    }
        
    // 화면 렌더링 시
    // render() 함수에서 반환된 값이 화면에 출력됨
    render() { // 클래스형 컴포넌트는 render 함수 안에 return 구문을 넣어줘야합니다. 무엇을 렌더링할지
        return (
            <>
                <h2>클래스형 컴포넌트</h2>

                <h1>Count: {this.state.count}</h1>
                <button onClick={this.handleClick}>Increment</button>

            </>
        );
    }
}
export default Exam1;