package edu.kh.objectarray.Service;

import java.util.Arrays;
import java.util.Random;

import edu.kh.objectarray.dto.Student;

// 기능 제공용 클래스 (비즈니스 로직 처리)
public class StudentService {
	
	// Student 객체 참조변수 5개짜리 배열 생성 studentArr 참조
	private Student[] studentArr = new Student[5]; 

	//StudentService 기본 생성자
	public StudentService() {
		
		//studentArr 배열의 각 요소는 student 참조 변수
		studentArr[0] = new Student(3, 5, 1, "홍길동");
		studentArr[1] = new Student(2, 3, 11, "김철수");
		studentArr[2] = new Student(1, 7, 3, "퉁퉁이");
		studentArr[3] = new Student(2, 7, 3, "1");
		studentArr[4] = new Student(2, 1, 3, "김김김");
		
		 Random random = new Random();
	      for(Student s : studentArr) {
	         
	         if(s == null) break;
	         
	         s.setKor(random.nextInt(101));
	         s.setEng(random.nextInt(101));
	         s.setMath(random.nextInt(101));
	      }
				
	}
	//@param (parameter) 매개변수
	/**	1. 학생 추가 서비스
	 * 	@param grade : int
	 * 	@param classRoom : int
	 * 	@param number : int
	 * 	@param name : String
	 * 
	 * @return result : boolean (학생 추가 성공 시 ture)
	 * */
	public boolean addStudent(int grade, int classRoom, int number, String name) {
		
		//studentArr에서 비어있는 인덱스를 찾아
		//해당 인덱스에 매개변수를 이용해 생성된 Student 객체 주소 대입
		//-> true
		
		for(int i = 0; i < studentArr.length; i++) {
			//배열 요소가 참조하는 주소가 없을 경우 = 비어있다고 판단
			if(studentArr[i] == null) {
				//비어있는 배열 요소에 매개변수를 이용해 새 학생 객체 주소 대입
				studentArr[i] = new Student(grade, classRoom, number, name);
				return true;
			}
		}
		
		//반약 비어있는 인덱스가 없을 경우 = null
		//->false 반환
		return false;
	}
	
	/**	2. 학생 전체 조회 서비스
	 * 	@return studentArr : Student[]
	 * */
	public Student[] selectAll() {
		//studentArr 반환
		return studentArr;
	}
	
	/**3. 학생 정보 조회(인덱스)
	 * @param index : int
	 * 
	 * @return studentArr[index] : Student 참조 변수
	 * */
	public Student selectIndex(int index) {
		
		//index 값이 0~4 사이가 아니면
		//배열 범위를 초과 했다는 ArrayIndexOutOfBoundException 발생
		//해결 방법 : 배열 범위가 넘어선 경우에 대한 별도 처리
//		if(index >= 0 && index <= 4) {
		if(index < 0 || index >= studentArr.length) {
			return null;
		}
		
		return studentArr[index];
	}
	
	/**4.학생 정보 조회(이름) 서비스
	 * @param inputName : String
	 * 
	 * @return resultArr : Student[] (조회된 학생 없을 경우 null)
	 * */
	public Student[] selectName(String inputName) {
		
		//이름이 일치하는 학생 모두를 저장할 객체배열 선언 및 초기화
		Student[] resultArr = new Student[studentArr.length];
		
		int index = 0; //resultArr에 값을 대입할 인덱스를 나타낸 변수
		
		//studentArr에서 이름이 일차하는 학생 찾기
		for(int i = 0; i < studentArr.length; i++) {
			//i번째 요소의 name과 inputName이 같은 경우
			//studentArr[i]가 null인지 검사
			
			if(studentArr[i] == null) {
				break;
			}
			if(studentArr[i].getName().equals(inputName)){
				//resultArr에 studentArr[i]의 주소를 대입 (얕은 복사)
				resultArr[index++] = studentArr[i];
			}
			
			//이름 일치하지 않아 index가 증가하지 않았다면
			
		}
		if(index == 0) {
			return null;
		}
		return resultArr;
	}
	
	/**5. 학생 정보 수정(인덱스) 서비스
	 * @param index : int
	 * @param kor : int
	 * @param eng : int
	 * @param math : int
	 * @return 수정 성공 시 true / 실패 false
	 * */
	public boolean updateStudent(int index, int kor, int eng, int math) {
		
		//예외
		//index범위 초과
		//index번째 요소 null
		
		if((index < 0 || index >= studentArr.length) || studentArr[index] == null) 
			return false;
		
		
		studentArr[index].setKor(kor);
		studentArr[index].setEng(eng);
		studentArr[index].setMath(math);
		return true;
	}
	
	/**6. 학생 총점 합계, 평균, 최고점, 최저점
	 * @return arr : int[] (인덱스 순서대로 총점 합계, 총점 평균, 총점 최고점, 총점 최저점)
	 * */
	public double[] sumAvgMaxMin() {
		
		double[] arr = new double[studentArr.length];
		
		int size = 0;
		int allTotal = 0;
		
		for(int i = 0; i < studentArr.length; i++) {
			if(studentArr[i] != null) {
				size++;
			}
		}
		
		int[] highLowSco = new int[size];
		
		for(int i = 0; i < studentArr.length; i++) {
			
			int studentTotal = 0;
			
			if(studentArr[i] != null) {
				allTotal += studentArr[i].getKor();
				allTotal += studentArr[i].getEng();
				allTotal += studentArr[i].getMath();
				studentTotal += studentArr[i].getKor();
				studentTotal += studentArr[i].getEng();
				studentTotal += studentArr[i].getMath();
				highLowSco[i] = studentTotal;
			}
			
		}
		Arrays.sort(highLowSco);
		
		arr[0] = allTotal;
		arr[1] = allTotal/(double)size;
		arr[2] = highLowSco[highLowSco.length-1];
		arr[3] = highLowSco[0];
		
		return arr;
	}
	
}
