/**
 * 
 */
package in.weq.oneness.tos;



/**
 * @author Paddy
 *
 */
public class MarksheetDataTO extends DependentObjectTO{
	
	private String subject;
	
	private int obtainedMarks;
	
	private int totalMarks;
	
	private MarksheetTO marksheet;

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

	public MarksheetTO getMarksheet() {
		return marksheet;
	}

	public void setMarksheet(MarksheetTO marksheet) {
		this.marksheet = marksheet;
	}
}