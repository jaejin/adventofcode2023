package day5;

import java.util.PriorityQueue;

public class Storages {
	PriorityQueue<Storage> storages = new PriorityQueue<>();

	public Long getValue(Long value) {
		for (Storage storage: storages) {

			 // System.out.printf("\nkey %s end %s \n" ,storage.getKeyValue(), (storage.getKeyValue() + storage.getInitValue()));
			if (value >= storage.getKeyValue() && value <= (storage.getKeyValue() + storage.getSpace())) {
				 // System.out.println(" 범위 " +value + " " + (value - storage.getKeyValue()));
				return storage.getInitValue() + (value - storage.getKeyValue());
			}
		}
		return value;
	}

	public void addStorage(Storage storage) {
		storages.add(storage);
	}
}
