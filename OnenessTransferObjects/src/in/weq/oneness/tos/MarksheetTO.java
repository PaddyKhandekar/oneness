/**
 * 
 */
package in.weq.oneness.tos;

import java.util.List;

/**
 * @author Paddy
 *
 */
public class MarksheetTO extends DependentObjectTO {
	
	private String standard;
	
	private String examType;
	
	private List<MarksheetDataTO> marksheetDatas;
	
	private StudentTO student;

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public List<MarksheetDataTO> getMarksheetDatas() {
		return marksheetDatas;
	}

	public void setMarksheetDatas(List<MarksheetDataTO> marksheetDatas) {
		this.marksheetDatas = marksheetDatas;
	}

	public StudentTO getStudent() {
		return student;
	}

	public void setStudent(StudentTO student) {
		this.student = student;
	}
}