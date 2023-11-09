package vaccinappJdbc;

import java.util.GregorianCalendar;
import java.util.Scanner;

import vaccinappJdbc.gateway.SUSServerSimulator;

public class App {

	private static String DB_URL = "jdbc:mysql://localhost/vaccinapp";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "mysql";

	public static void main(String[] args) {

		SUSServerSimulator SUSServer = new SUSServerSimulator();
		Users user = new Users();
		Scanner scan = new Scanner(System.in);
		UserManager userManager = new UserManager();

		SUSServer.initializationExam();
		SUSServer.initializationVaccines();

		int op = 0;

		do {
			System.out.println("Escolha uma das opções abaixo: ");
			System.out.println("1- Exibir vacinas disponíveis para agendamento!");
			System.out.println("2- Exibir exames disponíveis para agendamento!");
			System.out.println("3- Agendar Vacinação!");
			System.out.println("4- Agendar exames!");
			System.out.println("0- Encerrar programa");
			op = scan.nextInt();

			switch (op) {
			case 1:
				System.out.println(" ");
				SUSServer.getVaccines();
				System.out.println(" ");
				break;
			case 2:
				System.out.println(" ");
				SUSServer.getExam();
				System.out.println(" ");
				break;
			case 3:

				System.out.println("----- Tela de Agendamento de Vacinação -----");
				String name = "ab";
				do {

					System.out.println("Digite seu nome: ");
					name = scan.nextLine();

					if (scan.hasNextLine()) { // pra pegar o enter do buffer
						scan.nextLine();
					}

					if (userManager.isValidName(name)) {
						System.out.println("Nome inválido. Tente novamente.");
					}

				} while (userManager.isValidName(name));

				System.out.println("Digite qual vacina você quer agendar: ");
				String vaccine = scan.nextLine();

				if (scan.hasNextLine()) { // pra pegar o enter do buffer
					scan.nextLine();
				}

				GregorianCalendar date;
				int dia1;
				int mes1;
				int ano1;
				do {
					System.out.println("Digite a data para agendamento: ");
					System.out.println("Dia: ");
					dia1 = scan.nextInt();
					System.out.println("Mês: ");
					mes1 = scan.nextInt();
					System.out.println("Ano: ");
					ano1 = scan.nextInt();
					date = (new GregorianCalendar(ano1, mes1 - 1, dia1));
					if (!userManager.isValidDate(date)) {
						System.out.println("Data inválida. Tente novamente.");
					}
				} while (!userManager.isValidDate(date));

				if (SUSServer.vaccinationSchedule(vaccine, date)) {
					System.out.println("Agendamento da vacina contra " + vaccine + " para " + name + " na data " + dia1
							+ "/" + mes1 + "/" + ano1 + " adicionado com sucesso!");
				} else {
					System.out.println(" ");
					System.out.println("Ocorreu um erro! Não foi possível realizar o agendamento!");
					System.out.println(" ");
					System.out.println(
							"nome: " + name + "Vacina: " + vaccine + "Dia: " + dia1 + "mes:" + mes1 + "ano: " + ano1);
				}

				break;
			case 4:
				System.out.println("----- Tela de Agendamento de Exames -----");

				String name2 = "ab";
				do {

					System.out.println("Digite seu nome: ");
					name2 = scan.nextLine();

					if (scan.hasNextLine()) { // pra pegar o enter do buffer
						scan.nextLine();
					}

					if (userManager.isValidName(name2)) {
						System.out.println("Nome inválido. Tente novamente.");
					}

				} while (userManager.isValidName(name2));

				System.out.println("Digite qual exame você quer agendar: ");
				String exam = scan.nextLine();

				if (scan.hasNextLine()) { // pra pegar o enter do buffer
					scan.nextLine();
				}

				GregorianCalendar dateExam;
				int dia2;
				int mes2;
				int ano2;
				do {
					System.out.println("Digite a data para agendamento: ");
					System.out.println("Dia: ");
					dia2 = scan.nextInt();
					System.out.println("Mês: ");
					mes2 = scan.nextInt();
					System.out.println("Ano: ");
					ano2 = scan.nextInt();
					dateExam = (new GregorianCalendar(ano2, mes2 - 1, dia2));
					if (!userManager.isValidDate(dateExam)) {
						System.out.println("Data inválida. Tente novamente.");
					}
				} while (!userManager.isValidDate(dateExam));

				if (SUSServer.examSchedule(exam, dateExam)) {
					System.out.println("Agendamento  do exame de " + exam + " para " + name2 + " na data" + dia2 + "/"
							+ mes2 + "/" + ano2 + " realizado com sucesso!");
				} else {
					System.out.println("Ocorreu um erro! Não foi possível realizar o agendamento!");
					System.out.println(
							"nome: " + name2 + "exam: " + exam + "Dia: " + dia2 + "mes:" + mes2 + "ano: " + ano2);

				}
				break;

			}

		} while (op != 0);

	}

}
