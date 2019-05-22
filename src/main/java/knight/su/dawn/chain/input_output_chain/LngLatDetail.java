package knight.su.dawn.chain.input_output_chain;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class LngLatDetail {

	private String code;
	private Float lng;
	private Float lat;

	public LngLatDetail(String code, Float lng, Float lat) {
		this.code = code;
		this.lng = lng;
		this.lat = lat;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return String.format("%s-(%s,%s)", this.code, this.lng, this.lat);
	}
}
