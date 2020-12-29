package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

//@ComponentScan({"spring.di.ui","spring.di.entity"}) //다중 설정이가능함.배열형식으로. 
@ComponentScan("spring.di.ui") //단건 설정방법 
@Configuration
public class NewlecDIConfig {

	@Bean
	public Exam exam() {
		return new NewlecExam();
	}
	@Bean
	public Exam exam1() {
		return new NewlecExam();
	}
	@Bean
	public Exam exam2() {
		return new NewlecExam();
	}
}
