package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {

	public static void main(String[] args) {

		// Data local atual
		LocalDate d01 = LocalDate.now();
		System.out.println("LocalDate.now()\t\t" + d01);

		// Data e hora local atual
		LocalDateTime d02 = LocalDateTime.now();
		System.out.println("LocalDateTime.now()\t" + d02);

		// Data e hora local em Londres (Padrão GMT(Z))
		Instant d03 = Instant.now();
		System.out.println("Instant.now()\t\t" + d03);

		// Data em forma de texto (ISO 8601)
		LocalDate d04 = LocalDate.parse("2023-06-30");
		System.out.println("LocalDate.parse()\t" + d04 + "\t\t\t(ISO 8601)");

		// Data e hora em forma de texto (ISO 8601)
		LocalDateTime d05 = LocalDateTime.parse("2023-06-30T14:20:06");
		System.out.println("LocalDateTime.parse()\t" + d05 + "\t\t(ISO 8601)");

		// Data e hora local em Londres (Padrão GMT(Z)) (ISO 8601)
		Instant d06 = Instant.parse("2023-06-30T14:20:06Z");
		System.out.println("Instant.parse()\t\t" + d06 + "\t\t(ISO 8601)");

		// Data e hora local em Londres (Padrão GMT(Z)) convertido para o fuso horário de São Paulo
		Instant d07 = Instant.parse("2023-06-30T14:20:06-03:00");
		System.out.println("Instant.parse()\t\t" + d07 + "\t\t(ISO 8601) -3 horas");

		// Documentação DateFormat:
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/text/SimpleDateFormat.html

		// Formato Customizado Data(ISO 8601)
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d08 = LocalDate.parse("30/06/2023", fmt1);
		// OU LocalDate d08 = LocalDate.parse("30/06/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("DateTimeFormatter()\t" + d08 + "\t\t\t(ISO 8601) Customizado");

		// Formato Customizado Data e Hora(ISO 8601)
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
		LocalDateTime d09 = LocalDateTime.parse("30/06/2023 14:20", fmt2);
		System.out.println("DateTimeFormatter()\t" + d09 + "\t\t(ISO 8601) Customizado");

		// Maneira alternativa de inserção de data (.of) (ISO 8601)
		LocalDate d10 = LocalDate.of(2023, 6, 30); 
		System.out.println("LocalDate.of()\t\t" + d10 + "\t\t\t(ISO 8601)");

		// Maneira alternativa de inserção de data/hora(.of) (ISO 8601)
		LocalDateTime d11 = LocalDateTime.of(2023, 6, 30, 14, 20, 06); 
		System.out.println("LocalDate.of()\t\t" + d11 + "\t\t(ISO 8601)");
	}

}
