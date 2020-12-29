package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
		
		ApplicationContext context = 
				//new ClassPathXmlApplicationContext("spring/di/setting.xml"); // xml방식 호출
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);  // annotation 방식 호출

		//위의 경우는 기본 설정 방법
		
		/* 여러개의 config 파일 설정방법
		 
		  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		  ctx.register( AppConfig.class , OtherConfig.class); //IOC 컨테이너 객체정의 다건
		  ctx.register(NewlecDIConfig.class); //IOC 컨테이너 객체정의 단건  
		  ctx.refresh();  // IOC 컨테이너에 있는 객체 호출 
		  
		 */
		
		/*
		 ApplicationContext 는 XML파일과 Java class 호출 방식이 있다.
		 		-> ClassPathXmlApplicationContext   ->xml 파일 호출 방식
				-> FileSystemXmlApplicationContext  ->xml 파일 호출 방식
				-> XmlWebApplicationContext ->xml 파일 호출 방식
				
				-> AnnotationConfigApplicationContext  --> java class를  annotation으로 하는 방식.	
		 */
		
		
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
