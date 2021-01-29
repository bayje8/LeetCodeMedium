package com.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StreamsTest streamsTest = new StreamsTest();
		streamsTest.testStream();
	}

	void testStream() {
		System.out.println(
		getStudents().stream()
		.filter(s->s.getGender().equals("M"))
		.map(Student::getGender)
		.map(StreamsTest::getGenderFromCode)
		.collect(Collectors.toList())
		
		);
	}
	
	private static String getGenderFromCode(String s) {
		return s.equals("M")?"MALE":"FEMALE";
	}

	private List<Student> getStudents() {
		List<Student> list = new ArrayList<StreamsTest.Student>();
		list.add(new Student("Ammu", "F", 70));
		list.add(new Student("Bava", "M", 80));
		list.add(new Student("Amma", "F", 70));
		list.add(new Student("Nana", "M", 80));
		list.add(new Student("Akka", "F", 65));
		return list;
	}

	class Student {
		private String name;
		private String gender;
		private int marks;

		public Student(String name, String gender, int marks) {
			super();
			this.name = name;
			this.gender = gender;
			this.marks = marks;
		}

		Student() {

		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getMarks() {
			return marks;
		}

		public void setMarks(int marks) {
			this.marks = marks;
		}

	}
}
