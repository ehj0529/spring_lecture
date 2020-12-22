package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {

		/* 스프링에게 지시하는 방법으로 코드를 변경.
		//Exam exam = new NewlecExam();
		Exam exam = new NewlecExam(10,10,10,10);
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		//Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString());
		
		ExamConsole console = (ExamConsole) context.getBean("console");  //obj 형식으로 가져와서 형변환하는 방식.
		//ExamConsole console = context.getBean(ExamConsole.class);  //자료형으로 가져오는 방식.
		console.print();
		
		//List<Exam> exams = new ArrayList<>();
		//List<Exam> exams = (List<Exam>) context.getBean("exams"); //ArrayList를 DI에서 bean으로 설정하여 사용함.
		//exams.add(new NewlecExam(1,1,1,1)); DI에서 설정 가능함.
		
		//for(Exam e: exams)
		//	System.out.println(e);
		
		
		
	}

}
