/**
 * 
 */
package in.weq.oneness.tos;


/**
 * @author Paddy
 *
 */
public class IndividualDonorTO extends DonorTO {

	private String occupation;

	private String nationality;

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}