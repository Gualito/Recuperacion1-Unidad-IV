package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="airplanes")
public class Airplane implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String name;
	@Column(length=45)
	private String color;
	@Temporal(TemporalType.DATE)
	@Column(name="fly_date")
	private Date flydate;
	private boolean active;
	
	public Airplane(){
		this("","",new Date(),false);
	}

	public Airplane(String name, String color, Date flydate, boolean active) {
		super();
		this.name = name;
		this.color = color;
		this.flydate = flydate;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFlydate() {
		return flydate;
	}

	public void setFlydate(Date Flydate) {
		this.flydate = Flydate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Airplane [id=" + id + ", name=" + name + ", color=" + color + ", flydate=" + flydate + ", active="
				+ active + "]";
	}

	
	
	
}
