package com.concept.genralprograms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ReadCSVFile {

	public static void main(String[] args) {

		try {

			String csvFile = "/home/iqbal/SampleCSV.csv";

			// create BufferedReader to read csv file
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			String line = "";
			StringTokenizer st = null;

			// read comma separated file line by line
			while ((line = br.readLine()) != null) {
				// use comma as token separator
				st = new StringTokenizer(line, ",");

				while (st.hasMoreTokens()) {
					// display csv values
					System.out.print(st.nextToken() + "  ");
				}

				System.out.println();
			}

		} catch (Exception e) {
			System.err.println("CSV file cannot be read : " + e);
		}
	}

}
