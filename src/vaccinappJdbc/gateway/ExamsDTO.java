package vaccinappJdbc.gateway;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ExamsDTO {

	private String exams;
	private int qtdExams;
	private GregorianCalendar examsDate;
	
	public String getExams() {
		return exams;
	}
	public void setExams(String exams) {
		this.exams = exams;
	}
	public int getQtdExams() {
		return qtdExams;
	}
	public void setQtdExams(int qtdExams) {
		this.qtdExams = qtdExams;
	}
	public GregorianCalendar getExamsDate() {
		return examsDate;
	}
	public void setExamsDate(GregorianCalendar examsDate) {
		this.examsDate = examsDate;
	}
	
	public ExamsDTO(String exams, int qtdExams, GregorianCalendar examsDate) {
		super();
		this.exams = exams;
		this.qtdExams = qtdExams;
		this.examsDate = examsDate;
	}
	
	@Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(examsDate.getTime());
        return "Exam Name: " + exams + ", Quantity: " + qtdExams + ", Exam Date: " + formattedDate;
    }

	
	
	
}
