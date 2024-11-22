package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day52 {


	public void run()  {
		try (BufferedReader fileReader = new BufferedReader(new FileReader("D52.txt"))) {
			String line;

			String seedString = fileReader.readLine();

			FoodProduction2 foodProduction = new FoodProduction2();

			foodProduction.setSeeds(seedString);
			fileReader.readLine();

			String before = "";
			while((line=fileReader.readLine()) != null) {
				if( line.length() > 0) {
					if(Character.isDigit(line.charAt(0))) {
						foodProduction.setValue(before, line);
						//System.out.format("%s %s\n", before,line);
					} else {
						before=line;
					}
				}
			}

			foodProduction.printLocation();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
	public static void main(String[] args) {
		new Day52().run();
	}
}
