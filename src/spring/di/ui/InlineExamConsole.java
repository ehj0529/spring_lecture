package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {

	@Autowired(required = false)  // required �� ��ü(bean)�� ��� ��� �����ϵ��� �ɼ��� ������.
	@Qualifier("exam2")
	private Exam exam;

	public InlineExamConsole() {
	}
	
	
	public InlineExamConsole(@Qualifier("exam1")Exam exam) { //overloaded �����ڿ����� �����ڸ� �����ؾ� �ȴ�.
		this.exam = exam;
	}

	@Override
	public void print() {
		if(exam == null)
			System.out.printf("total is %d, avg is %f\n", 0, 0.0);
		else
			System.out.printf("total is %d, avg is %f\n",exam.total(), exam.avg());
	}

	@Autowired
	@Qualifier("exam2")//���������� bean�� Ư���Ͽ� �����Ҽ� ����.
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
