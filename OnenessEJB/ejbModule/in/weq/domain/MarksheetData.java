/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.MarksheetDataTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Paddy
 *
 */
@Entity
@Table(name="marksheet_data")
public class MarksheetData extends DependentObject{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7705091924193438715L;

	@Column(name="subject")
	private String subject;
	
	@Column(name="obtainedMarks")
	private int obtainedMarks;
	
	@Column(name="totalMarks")
	private int totalMarks;
	
	@ManyToOne
	@JoinColumn(name="marksheet_id",referencedColumnName="id")
	private Marksheet marksheet;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Marksheet getMarksheet() {
		return marksheet;
	}

	public void setMarksheet(Marksheet marksheet) {
		this.marksheet = marksheet;
	}
	
	@Override
	public MarksheetDataTO convertToTO() {
		MarksheetDataTO marksheetDataTO = new MarksheetDataTO();
		
		marksheetDataTO.setObtainedMarks(obtainedMarks);
		marksheetDataTO.setResourceId(getId());
		marksheetDataTO.setSubject(subject);
		marksheetDataTO.setTotalMarks(totalMarks);
		
		return marksheetDataTO;
	}
}