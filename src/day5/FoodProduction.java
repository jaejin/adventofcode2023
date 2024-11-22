package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodProduction {


	Storages seedToSoil = new Storages();
	Storages soilToFertilizer = new Storages();
	Storages fertilizerToWater = new Storages();
	Storages waterToLight = new Storages();
	Storages lightToTemperature = new Storages();
	Storages temperatureToHumidity = new Storages();
	Storages humidityToLocation = new Storages();
	List<Long> seeds = new ArrayList<>();

	FoodProduction() {

	}

	public void setSeeds(String seedString) {
	 	String[] value = 	seedString.substring(seedString.indexOf(": ")+2).split(" ");
		 for (String s : value) {
			 seeds.add(Long.parseLong(s));
		 }
	}

	public void setValue(String keyword, String values) {

		String[] seedToSoilArray = 	values.split(" ");
	 	Long initValue = Long.parseLong(seedToSoilArray[0]);
		Long keyValue = Long.parseLong(seedToSoilArray[1]) ;
		Long space = Long.parseLong(seedToSoilArray[2]);
	 		if ("seed-to-soil map:".equals(keyword)) {
				seedToSoil.addStorage(new Storage(keyValue, space, initValue));

			}
			if ("soil-to-fertilizer map:".equals(keyword)) {
				soilToFertilizer.addStorage(new Storage(keyValue, space, initValue));
			}

			if ("fertilizer-to-water map:".equals(keyword)) {
				fertilizerToWater.addStorage(new Storage(keyValue, space, initValue));

			}

			if ("water-to-light map:".equals(keyword)) {
				waterToLight.addStorage(new Storage(keyValue, space, initValue));

			}

			if ("light-to-temperature map:".equals(keyword)) {
				lightToTemperature.addStorage(new Storage(keyValue, space, initValue));

			}

			if ("temperature-to-humidity map:".equals(keyword)) {
				temperatureToHumidity.addStorage(new Storage(keyValue, space, initValue));
			}

			if ("humidity-to-location map:".equals(keyword)) {
				humidityToLocation.addStorage(new Storage(keyValue, space, initValue));
			}

	}

	public long getValue(Storages map, Long key) {
		return map.getValue(key);
	}

	private Long findLocation(Long key) {
		Long soil = getValue(seedToSoil, key);
		System.out.printf(" soil %s",soil);
		Long fertilizer = getValue(soilToFertilizer, soil);
		System.out.printf(" fertilizer %s",fertilizer);
		Long water = getValue(fertilizerToWater, fertilizer);
		System.out.printf(" water %s",water);
		Long light = getValue(waterToLight, water);
		System.out.printf(" light %s",light);
		Long temperature = getValue(lightToTemperature, light);
		System.out.printf(" temperature %s",temperature);
		Long humidity = getValue(temperatureToHumidity, temperature);
		System.out.printf(" humidity %s",humidity);
		Long location = getValue(humidityToLocation, humidity);
		System.out.printf(" location %s \n",location);
		return location;
	}

	public void printLocation() {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(Long seed : seeds) {
			System.out.printf("seed %s",seed);
			pq.add(findLocation(seed));
		}
		System.out.printf("lowest location %s",pq.poll());
	}
}
