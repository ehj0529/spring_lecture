package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {

	private Exam exam;

	public InlineExamConsole() {
	}
	
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d, avg is %f\n",exam.total(), exam.avg());
	}

	@Autowired
	@Qualifier("exam2")//동일유형의 bean을 특젇하여 지정할수 있음.
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
