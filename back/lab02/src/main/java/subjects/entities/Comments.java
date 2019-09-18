package subjects.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comments {

	@Id
	@GeneratedValue
	private long id;
	private String comment;
	
	public Comments() {
		super();
	}

	public Comments(Long id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

}
