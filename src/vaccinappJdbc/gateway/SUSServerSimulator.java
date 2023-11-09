package vaccinappJdbc.gateway;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class SUSServerSimulator {

	private VaccinesDTO[] vaccines = new VaccinesDTO[5];
	private ExamsDTO[] exams = new ExamsDTO[5];

	public ExamsDTO[] getExams() {
		return exams;
	}

	public void setExams(ExamsDTO[] exams) {
		this.exams = exams;
	}

	public void setVaccines(VaccinesDTO[] vaccines) {
		this.vaccines = vaccines;
	}

	public void initializationVaccines() {

		vaccines[0] = new VaccinesDTO("Febre Amarela", 10, new GregorianCalendar(2023, 10, 12));
		vaccines[1] = new VaccinesDTO("Gripe", 25, new GregorianCalendar(2023, 10, 12));
		vaccines[2] = new VaccinesDTO("HPV", 30, new GregorianCalendar(2023, 11, 5));
		vaccines[3] = new VaccinesDTO("Tríplice Bacteriana", 40, new GregorianCalendar(2024, 3, 15));
		vaccines[4] = new VaccinesDTO("Hepatite A", 15, new GregorianCalendar(2024, 3, 15));

	}

	public void getVaccines() {

		for (int i = 0; i < 5; i++) {
			System.out.println("Vacina contra: " + vaccines[i].getVaccines());
			System.out.println("quantidade: " + vaccines[i].getQtdVaccines());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data de vacinação: " + dateFormat.format(vaccines[i].getVaccinationDate().getTime()));
			System.out.println();
		}

	}

	public void initializationExam() {
		exams[0] = new ExamsDTO("Hemograma Completo", 2, new GregorianCalendar(2023, 11, 20));
		exams[1] = new ExamsDTO("Colesterol total e Triglicerídeos", 1, new GregorianCalendar(2023, 11, 20));
		exams[2] = new ExamsDTO("Glicemia", 3, new GregorianCalendar(2023, 10, 21));
		exams[3] = new ExamsDTO("Ureia e Creatinina", 1, new GregorianCalendar(2023, 10, 29));
		exams[4] = new ExamsDTO("PCR e VHS", 3, new GregorianCalendar(2023, 10, 25));
	}

	public void getExam() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Nome do exame: " + exams[i].getExams());
			System.out.println("Quantidade de exames disponíveis para a data: " + exams[i].getQtdExams());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data do exame: " + dateFormat.format(exams[i].getExamsDate().getTime()));
			System.out.println();
		}
	}

	public boolean vaccinationSchedule(String vaccine, GregorianCalendar VaccinationDate) {

		for (int i = 0; i < vaccines.length; i++) {
			if (vaccines[i].getVaccines().equalsIgnoreCase(vaccine) && vaccines[i].getQtdVaccines() > 0
					&& vaccines[i].getVaccinationDate().equals(VaccinationDate)) {
				return true;
			}
		}
		return false;
	}

	public boolean examSchedule(String exam, GregorianCalendar examDate) {
		for (int i = 0; i < exams.length; i++) {
			if (exams[i].getExams().equalsIgnoreCase(exam) && exams[i].getQtdExams() > 0
					&& exams[i].getExamsDate().equals(examDate)) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public String toString() {
		return "SUSServerSimulator [vaccines =" + Arrays.toString(vaccines) + ", exams =" + Arrays.toString(exams)
				+ "]";
	}

}
