package knight.su.dawn.chain.part_chain;

/**
 *
 * Date: 2019年5月21日<br/>
 * 
 * @author sugengbin
 */
public class PartialContext {

	private String globalCity;
	private boolean trim;
	private String blankTo;

	public PartialContext(String globalCity, boolean trim, String blankTo) {
		this.globalCity = globalCity;
		this.trim = trim;
		this.blankTo = blankTo;
	}

	public String getGlobalCity() {
		return globalCity;
	}

	public void setGlobalCity(String globalCity) {
		this.globalCity = globalCity;
	}

	public boolean isTrim() {
		return trim;
	}

	public void setTrim(boolean trim) {
		this.trim = trim;
	}

	public String getBlankTo() {
		return blankTo;
	}

	public void setBlankTo(String blankTo) {
		this.blankTo = blankTo;
	}

}
