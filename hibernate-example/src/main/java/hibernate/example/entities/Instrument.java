package hibernate.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {
	@Id
	@Column(name = "instrument_id")
	private String instrumentId;

	@ManyToMany
	@JoinTable(name = "singer_instrument",
		joinColumns = @JoinColumn(name = "instrument_id"),
		inverseJoinColumns = @JoinColumn(name = "singer_id"))
	private Set<Singer> singers = new HashSet<>();

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setSingers(Set<Singer> singers) {
		this.singers = singers;
	}

	public Set<Singer> getSingers() {
		return singers;
	}

	@Override
	public String toString() {
		return "Instrument[" +
			"instrumentId[" + instrumentId + "]" +
			"]";
	}
}
