/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.MarksheetDataTO;
import in.weq.oneness.tos.MarksheetTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="marksheet")
public class Marksheet extends DependentObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3252461937567079309L;

	@Column(name="standard")
	private String standard;
	
	@Column(name="examType")
	private String examType;
	
	@OneToMany(mappedBy="marksheet",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<MarksheetData> marksheetDatas;
	
	@ManyToOne
	@JoinColumn(name="student_id",referencedColumnName="id")
	private Student student;

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

	public List<MarksheetData> getMarksheetDatas() {
		return marksheetDatas;
	}

	public void setMarksheetDatas(List<MarksheetData> marksheetDatas) {
		this.marksheetDatas = marksheetDatas;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public MarksheetTO convertToTO() {
		
		MarksheetTO marksheetTO = new MarksheetTO();
		
		marksheetTO.setExamType(examType);
		marksheetTO.setResourceId(getId());
		marksheetTO.setStandard(standard);
		
		if(marksheetDatas != null){
			List<MarksheetDataTO> marksheetDataTOs = new ArrayList<MarksheetDataTO>();
			for (Iterator<MarksheetData> iData = marksheetDatas.iterator(); iData.hasNext();) {
				MarksheetDataTO marksheetDataTO = iData.next().convertToTO();
				marksheetDataTOs.add(marksheetDataTO);
			}
			marksheetTO.setMarksheetDatas(marksheetDataTOs);
		}
		return marksheetTO;
	}
}