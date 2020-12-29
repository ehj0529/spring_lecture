package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {

	@Autowired(required = false)  // required 는 객체(bean)이 없어도 사용 가능하도록 옵션을 적용함.
	@Qualifier("exam2")
	private Exam exam;

	public InlineExamConsole() {
	}
	
	
	public InlineExamConsole(@Qualifier("exam1")Exam exam) { //overloaded 생성자에서는 지정자를 설정해야 된다.
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
	@Qualifier("exam2")//동일유형의 bean을 특젇하여 지정할수 있음.
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
