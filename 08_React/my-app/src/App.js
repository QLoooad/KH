import './App.css';

// components 폴더의 Exam1.js를 가져와 사용
// 사용 시 이름 Ex1으로 지정
import Ex1 from './components/Exam1';

import Ex2 from './components/Exam2';
function App() {
  // 리액트의 컴포넌트는 딱 하나의 요소만을 반활할 수 있다
  // 여러 요소를 반환하고 싶을 때는 부모 요소로 묶어준다
  return (
    /* <></> << fragment 감싸는 부모요소 해석x */
    <>
      {/* jsx 주석 */}
      <h1>hello react</h1>
      <div>안녕 리엑트</div>
      <Ex1/>
      <Ex2/>
    </>
  );
}

export default App;
