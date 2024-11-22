package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import day4.Card;
import day4.Day41;

public class Day51 {


	public void run()  {
		try (BufferedReader fileReader = new BufferedReader(new FileReader("D51.txt"))) {
			String line;

			String seedString = fileReader.readLine();

			FoodProduction foodProduction = new FoodProduction();

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
		new Day51().run();
	}
}
