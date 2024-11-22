package day5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FoodProduction2 {


	Storages seedToSoil = new Storages();
	Storages soilToFertilizer = new Storages();
	Storages fertilizerToWater = new Storages();
	Storages waterToLight = new Storages();
	Storages lightToTemperature = new Storages();
	Storages temperatureToHumidity = new Storages();
	Storages humidityToLocation = new Storages();
	List<Seed> seeds = new ArrayList<>();

	FoodProduction2() {

	}

	public void setSeeds(String seedString) {
	 	String[] value = 	seedString.substring(seedString.indexOf(": ")+2).split(" ");
		 for (int i = 0; i < value.length; i=i+2) {
			seeds.add(new Seed(Long.parseLong(value[i]) , Long.parseLong(value[i+1])))  ;
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
		// System.out.printf(" seed %s",key);
		Long soil = getValue(seedToSoil, key);
		// System.out.printf(" soil %s",soil);
		Long fertilizer = getValue(soilToFertilizer, soil);
		// System.out.printf(" fertilizer %s",fertilizer);
		Long water = getValue(fertilizerToWater, fertilizer);
		// System.out.printf(" water %s",water);
		Long light = getValue(waterToLight, water);
		// System.out.printf(" light %s",light);
		Long temperature = getValue(lightToTemperature, light);
		// System.out.printf(" temperature %s",temperature);
		Long humidity = getValue(temperatureToHumidity, temperature);
		// System.out.printf(" humidity %s",humidity);
		Long location = getValue(humidityToLocation, humidity);
		// System.out.printf(" location %s \n",location);
		return location;
	}

	class Pair implements Comparable<Pair> {

		long from;
		long to;
		Seed seed;
		public Pair(Seed seed, long from, long to) {
			this.seed = seed;
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Pair o) {
			return Math.min(o.from, o.to) < Math.min(from, to) ? 1 : -1;
		}
	}
	public void printLocation() {
		long min = Long.MAX_VALUE;
		for(Seed seed : seeds) {
			long from = findLocation(seed.getInitValue());
			long to = findLocation(seed.getInitValue() + seed.getSpace());
			long seadMin = Math.min(from, to);
			min = Math.min(min, seadMin);
			long first = findLocation(seed.getInitValue());
			long last = findLocation(seed.getInitValue() + seed.getSpace());

			long start = Math.min(first, last);
			long end = Math.max(first, last);
			for (long i = start; i <= end; i++) {
				min = Math.min(min, findLocation(i));
			}


		}

		System.out.printf("mi %s",min);
	}
}
