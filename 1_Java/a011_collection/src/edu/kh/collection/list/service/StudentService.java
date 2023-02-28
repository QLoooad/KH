package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import edu.kh.collection.list.dto.Student;


public class StudentService {
	
//	private List<Student> studentList = new ArrayList<Student>();
	private List<Student> studentList = new LinkedList<Student>();
	//List 구현 클래스마다 장/단점이 있기에 골라 사용

	public StudentService() {
		
		studentList.add(new Student("홍길동", 3, 5, 28, "서울시 중구", 'M', 75));
		studentList.add(new Student("고순튀", 2, 6, 1, "서울시 종로구", 'F', 60));
		studentList.add(new Student("노진구", 1, 1, 5, "서울시 용산구", 'M', 20));
		studentList.add(new Student("도라에몽", 3, 2, 10, "서울시 용산구", 'M', 100));
		studentList.add(new Student("김미애", 3, 2, 3, "서울시 서대문구", 'F', 95));
		studentList.add(new Student("노병환", 1, 1, 17, "서울시 동대문구", 'F', 79));
		studentList.add(new Student("가나다", 2, 2, 19, "서울시 강남구", 'M', 68));
		studentList.add(new Student("라마바", 3, 4, 11, "서울시 강남구", 'F', 87));
		studentList.add(new Student("사아자", 1, 6, 12, "서울시 서초구", 'M', 55));
		studentList.add(new Student("에이비", 4, 4, 9, "서울시 강서구", 'F', 97));
		studentList.add(new Student("씨디이", 2, 5, 8, "서울시 영등포구", 'M', 23));
		studentList.add(new Student("에프지", 3, 4, 25, "서울시 마포구", 'F', 58));
		studentList.add(new Student("에이치", 2, 3, 23, "서울시 강동구", 'M', 47));
		studentList.add(new Student("케이엘", 3, 3, 20, "서울시 강동구", 'F', 69));
		studentList.add(new Student("엠오피", 3, 5, 13, "서울시 영등포구", 'M', 89));
		studentList.add(new Student("아오지", 2, 3, 21, "서울시 강서구", 'M', 87));
	
	}
	
	// shift + alt + j
	/**studentList에 학생 추가
	 * @param std
	 * @return true
	 */
	public boolean addStudent(Student std) {
		
		return studentList.add(std);
	}
	
	
	/**학생 전체 조회 서비스
	 * @return studentList
	 */
	public List<Student> selectAll() {
		return studentList;
	}

	/**학생 정보 수정 서비스
	 * @param index
	 * @param std
	 * @return s : Student(수정되기 전 학생 정보)
	 */
	public Student updateStudent(int index, Student std) {
		
		//e2 set(int index, E e) :  1) index에 위치하는 요소를 e로 변경
		//							2) 기존에 있던 요소 e2를 반환
		return studentList.set(index, std);
	}

	
	/**학생 정보 제거 서비스
	 * @param index
	 * @return s : Student(제거된 학생 정보)
	 */
	public Student removeStudent(int index) {
		
		//E remove(int index) : index번째 요소 List에서 제거 후 반환
		//boolean remove(E e) : List에서 E와 일치하는 요소를 찾아서
		//						있으면 제거 후 true, 없으면 false
		
		
		return studentList.remove(index);
	}
	
	/**학생 이름 검색
	 * @param name
	 * @return s : studentList or null
	 */
//	public Student selectName(String name) {
//		
//		for(Student s : studentList) {
//			if(name.equals(s.getName())) {
//				return s;
//			}
//		}
//		return null;
//	}
	
	
	/**학생 이름 검색
	 * @param name
	 * @return list : List<Student> 이름 일치하는 학생 리스트
	 */
	public List<Student> selectName(String name) {
		
		//1)검색 결과를 저장할 List<Student> 생성
		List<Student> list = new ArrayList<Student>();
		
		//2)studentList의 모든 요소를 순차 접근 후 이름이 일치하는 학생 list 추가
		for(Student s : studentList) {
			if(s.getName().equals(name)) {
				list.add(s);
			}
		}
		//검색 결과 반환
		return list;
	}
	
	/**학생 주소 검색 서비스
	 * @param address
	 * @return list:List<Student> 검색어가 주소에 포함된 학생 리스트
	 */
	public List<Student> selectAddress(String address) {
		
		List<Student> list = new ArrayList<Student>();
		
		for(Student s : studentList) {
			if(s.getAddress().contains(address)) {
				list.add(s);
			}
		}
		
		return list;
	}
	
	
	
	/**학년별 조회
	 * @param address
	 * @return list:List<Student> 학년별 조회
	 */
	public List<Student> selectGrade(int address) {
		
		List<Student> list = new ArrayList<>();
		
		//제네릭의 타입 추론
		//생성되는 컬렉션 객체의 제네릭을 별도로 작성하지 않아도
		//참조변수의 제네릭을 통해 제한되는 타입을 유추(추론)
		
		for(Student s : studentList) {
			if(s.getGrade() == address) {
				list.add(s);
			}
		}
		
		return list;
	}
	
	public List<Student> selectGender(char stdGender) {
		
		List<Student> list = new ArrayList<>();
		
		for(Student s : studentList) {
			if(s.getGender() == stdGender) {
				list.add(s);
			}
		}
		
		return list;
	}

	/**성적 순서 조회
	 * */
	public List<Student> sortScore() {
		
		//	studentList 정렬 (score 내림차순)
		//Collections 클래스 : 컬렉션에 도움되는 유용한 기능을 모은 클래스
		
		//Comparable<T> 인터페이스
		//객체의 기본 정렬 기준을 제공하는 인터페이스
		
		// sort : <?> void java.util.Collections.sort(List<?> list)
		// <?> 어떤 타입이 들어올지 모름 == 아무거나 가능
		
		Collections.sort(studentList);
		//studentList에 저장된 객체 Student의
		//오버라이딩된 CompareTo() 메서드 오른쪽으로 이동
		//현재 오름차순 정렬 으로 오버라이딩
		
		Collections.reverse(studentList);
		//내림차순
		return studentList;
	}
	
	
}
