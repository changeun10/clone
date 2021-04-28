package tododto;

public class TodoDto {
	private long id;
	private String title;
	private String regDate;
	private String name;
	private int sequence;
	private String type;

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getRegDate() {
		return regDate;
	}

	public String getName() {
		return name;
	}

	public int getSequence() {
		return sequence;
	}

	public String getType() {
		return type;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return id + "/" + title + "/" + regDate + "/" + name + "/" + sequence + "/" + type;
	}
}