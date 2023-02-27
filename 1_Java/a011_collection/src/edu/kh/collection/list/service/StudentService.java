package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;

import edu.kh.collection.list.dto.Student;


public class StudentService {
	
	private List<Student> studentList = new ArrayList<Student>();

	public StudentService() {
		
		studentList.add(new Student("홍길동", 3, 5, 28, "서울시 중구", 'M', 75));
		studentList.add(new Student("고순튀", 2, 6, 1, "서울시 종로구", 'F', 60));
		studentList.add(new Student("노진구", 1, 1, 5, "서울시 용산구", 'M', 20));
		studentList.add(new Student("도라에몽", 3, 2, 10, "서울시 용산구", 'M', 100));
		studentList.add(new Student("김미애", 3, 2, 3, "서울시 서대문구", 'F', 95));
		studentList.add(new Student("노병환", 1, 3, 15, "서울시 강남구", 'M', 99));
	
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
	public Student searchName(String name) {
		
		for(Student s : studentList) {
			if(name.equals(s.getName())) {
				return s;
			}
			
		}
		
		return null;
	}
	
	
	public List<Student> searchAddress(String address) {
		int index = 0;
		
		for(Student s : studentList) { //같은 지역 일때 같이 출력 
			if(address.equals(s.getAddress())) {
				index++;
			}
		}
		for(Student s : studentList) {
			if(address.equals(s.getAddress())) {
				return s;
			}
			
		}
		
		return null;
	}
	
}
