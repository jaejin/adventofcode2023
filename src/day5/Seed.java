package day5;

public class Seed {
	public Long getInitValue() {
		return initValue;
	}

	public void setInitValue(Long initValue) {
		this.initValue = initValue;
	}

	public Long getSpace() {
		return space;
	}

	public void setSpace(Long space) {
		this.space = space;
	}

	private Long initValue;
	private Long space;

	public Seed(Long initValue, Long space) {
		this.initValue = initValue;
		this.space = space;
	}
}
