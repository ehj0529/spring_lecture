package spring.aop.entity;

public class NewlecExam implements Exam {

	private int kor ;
	private int eng ;
	private int math ;
	private int com;
	
	public NewlecExam() {
		System.out.println("기본 생성자를 만들다");
	}
		
	public NewlecExam(int kor, int eng, int math, int com) {
		System.out.println("생성자를 만들다");
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getCom() {
		return com;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		
		//long startTime = System.currentTimeMillis();
		
		int result = kor+eng+math+com;
		
		if(kor > 100)
			throw new IllegalArgumentException("유효하지 않은 국어점수");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		//long endTime = System.currentTimeMillis();
		
		//String message = (endTime - startTime) +" ms 시간 소요 됨";
		//System.out.println(message);
		
		return result;
	}

	@Override
	public float avg() {
		float result = total() / 4.0f ; 
		return result;
	}

	@Override
	public String toString() {
		return "NewlecExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}

}
