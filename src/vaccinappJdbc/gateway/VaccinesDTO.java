package vaccinappJdbc.gateway;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class VaccinesDTO {

	private String vaccines;
	private int qtdVaccines;
	private GregorianCalendar vaccinationDate;

	public String getVaccines() {
		return vaccines;
	}

	public void setVaccines(String vaccines) {
		this.vaccines = vaccines;
	}

	public int getQtdVaccines() {
		return qtdVaccines;
	}

	public void setQtdVaccines(int qtdVaccines) {
		this.qtdVaccines = qtdVaccines;
	}

	public GregorianCalendar getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(GregorianCalendar vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public VaccinesDTO(String vaccines, int qtdVaccines, GregorianCalendar vaccinationDate) {
		this.vaccines = vaccines;
		this.qtdVaccines = qtdVaccines;
		this.vaccinationDate = vaccinationDate;
	}

	 @Override
	    public String toString() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        String formattedDate = dateFormat.format(vaccinationDate.getTime());
	        return "Vaccine Name: " + vaccines + ", Quantity: " + qtdVaccines + ", Vaccination Date: " + formattedDate;
	    }

}
