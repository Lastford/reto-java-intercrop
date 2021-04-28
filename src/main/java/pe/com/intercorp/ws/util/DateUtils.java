package pe.com.intercorp.ws.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	
	public static LocalDate validateFormat(String fecha, String currentFormat) {
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(currentFormat);
		return LocalDate.parse(fecha, customFormatter);
	}
}
