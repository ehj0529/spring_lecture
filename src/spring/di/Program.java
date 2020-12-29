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

		/* ���������� �����ϴ� ������� �ڵ带 ����.
		//Exam exam = new NewlecExam();
		Exam exam = new NewlecExam(10,10,10,10);
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		*/
		
		ApplicationContext context = 
				//new ClassPathXmlApplicationContext("spring/di/setting.xml"); // xml��� ȣ��
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);  // annotation ��� ȣ��

		//���� ���� �⺻ ���� ���
		
		/* �������� config ���� �������
		 
		  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		  ctx.register( AppConfig.class , OtherConfig.class); //IOC �����̳� ��ü���� �ٰ�
		  ctx.register(NewlecDIConfig.class); //IOC �����̳� ��ü���� �ܰ�  
		  ctx.refresh();  // IOC �����̳ʿ� �ִ� ��ü ȣ�� 
		  
		 */
		
		/*
		 ApplicationContext �� XML���ϰ� Java class ȣ�� ����� �ִ�.
		 		-> ClassPathXmlApplicationContext   ->xml ���� ȣ�� ���
				-> FileSystemXmlApplicationContext  ->xml ���� ȣ�� ���
				-> XmlWebApplicationContext ->xml ���� ȣ�� ���
				
				-> AnnotationConfigApplicationContext  --> java class��  annotation���� �ϴ� ���.	
		 */
		
		
		//Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString());
		
		ExamConsole console = (ExamConsole) context.getBean("console");  //obj �������� �����ͼ� ����ȯ�ϴ� ���.
		//ExamConsole console = context.getBean(ExamConsole.class);  //�ڷ������� �������� ���.
		console.print();
		
		//List<Exam> exams = new ArrayList<>();
		//List<Exam> exams = (List<Exam>) context.getBean("exams"); //ArrayList�� DI���� bean���� �����Ͽ� �����.
		//exams.add(new NewlecExam(1,1,1,1)); DI���� ���� ������.
		
		//for(Exam e: exams)
		//	System.out.println(e);
		
		
		
	}

}
