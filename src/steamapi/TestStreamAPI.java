package steamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamAPI {
	public static void main (String[] args) {
		
		Student stu1 = new Student("0093", "Tuan", 22, "Male");
		Student stu2 = new Student("0094", "Tan", 22, "Male");
		Student stu3 = new Student("0095", "Hop", 21, "Female");
		Student stu4 = new Student("0096", "Thu", 21, "Female");
		
		//Create a list of Students
		List<Student> list = Arrays.asList(stu1, stu2, stu3, stu4);
		
		//Print the name of all students in list
		for (Student student : list) {
			System.out.println(student.getName());
		}
		
		//Create a stream has all of students in list
		Stream<Student> streamList = list.stream();

		//Get Students with Gender is Male
		System.out.println("---Get Students with Gender is Male----");
		
		Stream<Student> listGenderIsMale = streamList
				.filter(stu -> stu.getGender().equals("Male"));
		
		listGenderIsMale.forEach(stu -> System.out.println(stu.getName()));
		
		
		//Count students with age > 20
		long count = streamList.filter(stu -> stu.getAge() >= 20)
				.count();
		System.out.print("The number of student with age > 20: " + count);
		
		
		//Using Stream to convert Student -> StudentDTO
		List<StudentDTO> listStudentDTO = list
				.stream().map(stu -> new StudentDTO(stu.getId(), 
						stu.getName(), stu.getAge(), stu.getGender()))
				.collect(Collectors.toList());
		listStudentDTO.forEach(stu -> System.out.println(stu.getName()));
				
	}
}
