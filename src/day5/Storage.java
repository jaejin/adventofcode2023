package day5;


public class Storage implements Comparable<Storage> {
	public Long getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(Long keyValue) {
		this.keyValue = keyValue;
	}

	public Long getSpace() {
		return space;
	}

	public void setSpace(Long space) {
		this.space = space;
	}

	public Long getInitValue() {
		return initValue;
	}

	public void setInitValue(Long initValue) {
		this.initValue = initValue;
	}

	public Storage(Long keyValue, Long space, Long initValue) {
		this.keyValue = keyValue;
		this.space = space;
		this.initValue = initValue;
	}

	private Long keyValue;
	private Long space;
	private Long initValue;

	@Override
	public int compareTo(Storage o) {
		return this.keyValue.compareTo(o.getKeyValue());
	}
}
