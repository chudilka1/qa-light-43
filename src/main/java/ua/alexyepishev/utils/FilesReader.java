package ua.alexyepishev.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*@Slf4j
@UtilityClass
public class FilesReader {
	public List<List<String>> parseFile(String pathToFile, String splitter) {
		List<List<String>> parsedData = new ArrayList<>(); // list to be populated with parsed data
		try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
			fillListWithParsedData(reader, parsedData, splitter);
		}
		catch (IOException exception) {
			log.error("File was not found", exception);
		}
		return parsedData;
	}

	private static void fillListWithParsedData(BufferedReader reader, List<List<String>> listToBeFilled, String splitter) throws IOException {
		int lineIndex = 0; // each next row must be populated as a new element in the list
		String line; // parsed line from the file
		while ((line = reader.readLine()) != null) {
			String[] data = line.split(splitter); // splits string into parts by splitter (regexp)
			listToBeFilled.add(new ArrayList<>());
			addLineElementsToList(listToBeFilled, lineIndex, data);
			log.info("Line {}: {}", lineIndex, listToBeFilled.get(lineIndex).toString());
			lineIndex++;
		}
	}

	private static void addLineElementsToList(List<List<String>> listToBeFilled, int lineIndex, String[] data) {
		for (String datum : data) {
			listToBeFilled.get(lineIndex).add(datum);
		}
	}

	public static void main(String[] args) {
		List<List<String>> csv = FilesReader.parseFile("src/main/java/com/masteringselenium/utils/DataCSV.csv", ",");
		log.info("My parsed scv: {}", csv.toString());

		int rowNumber = 1;
		for (List<String> row : csv) {
			String userName = row.get(0);
			log.info("Client {}\n"
							+ "\tVersion: {}\n"
							+ "\tPatch: {}\n"
							+ "\tClient ID: {}\n"
							+ "\tAccount ID: {}\n"
							+ "\tLanguage: {}\n"
							+ "\tCountry: {}",
					rowNumber, userName, row.get(1), row.get(2), row.get(3), row.get(4), row.get(5));
			rowNumber++;
		}
	}
}*/
