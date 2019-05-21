package knight.su.dawn.chain.part_chain;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class PartialDto {

	private String id;
	private String time; // input HH:mm:ss
	private String city;
	private String content;

	public PartialDto(String id, String time, String content) {
		this.id = id;
		this.time = time;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "id:" + this.id +
			   ",time:" + this.time + 
			   ",city:" + this.city + 
			   ",content:" + this.content;
	}
}
