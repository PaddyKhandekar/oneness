
package in.weq.oneness.bean;

import in.weq.exception.BusinessException;
import in.weq.oneness.constants.SessionConstants;
import in.weq.oneness.tos.MarksheetDataTO;
import in.weq.oneness.tos.MarksheetTO;
import in.weq.oneness.tos.SchoolTO;
import in.weq.oneness.tos.StudentSetTO;
import in.weq.oneness.tos.StudentTO;
import in.weq.oneness.tos.UserTO;
import in.weq.oneness.util.TextUtils;
import in.weq.service.SchoolServiceLocal;
import in.weq.service.StudentServiceLocal;
import in.weq.service.StudentSetServiceLocal;
import in.weq.service.UserServiceLocal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean(name = "schoolAdminBean")
@ViewScoped
public class SchoolAdminManagedBean {

    @EJB(mappedName = "SchoolService")
    private SchoolServiceLocal schoolServiceLocal;
    
    @EJB(mappedName = "StudentService")
    private StudentServiceLocal studentServiceLocal;

    @EJB(mappedName = "UserService")
    private UserServiceLocal userServiceLocal;
    
    @EJB(mappedName = "StudentSetService")
    private StudentSetServiceLocal studentSetServiceLocal;
    
    private SchoolTO logedInSchool;

    private List<StudentSetTO> sets;

    private List<StudentTO> students;

    private List<StudentTO> selectedStudents;

    private StudentSetTO selectedSet;
    
    private StudentTO selectedStudent;

    private boolean showStudentSet;
    
    private Date selectedDOB;
    
    private Date selectedFatherDOB;
    
    private Date selectedMotherDOB;
    
    private boolean studentDetailDialog;
    
    private boolean studentMarksDetailDialog;
    
    private boolean showStudents;
    
    private Boolean set;
    
    private MarksheetTO selectedMarksheet;
    
    @PostConstruct
    public void init() {

        FacesContext context = FacesContext.getCurrentInstance();
        UserTO user = (UserTO) context.getExternalContext().getSessionMap().get(SessionConstants.USER);

        try {
            logedInSchool = schoolServiceLocal.findSchoolById(user.getResourceId());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        sets = logedInSchool.getSets();
        students = logedInSchool.getStudents();
        
        if(sets == null){
            sets = new ArrayList<StudentSetTO>();
        }
        
        if(students == null){
            students = new ArrayList<StudentTO>();
        }
        
        selectedStudents = new ArrayList<StudentTO>();
        selectedDOB = new Date();
        selectedFatherDOB =  new Date();
        selectedMotherDOB = new Date();
        
        List<StudentTO> studentTOs = logedInSchool.getStudents();
        for (Iterator<StudentTO> iterator = studentTOs.iterator(); iterator.hasNext();) {
            StudentTO studentTO = (StudentTO) iterator.next();
            System.out.println("Name " + studentTO.getName());
        }
        
        List<StudentSetTO> setStudentSetTOs = logedInSchool.getSets();
        for (Iterator<StudentSetTO> iterator = setStudentSetTOs.iterator(); iterator.hasNext();) {
            StudentSetTO studentSetTO = (StudentSetTO) iterator.next();
            List<StudentTO> studentTOs2 = studentSetTO.getStudents();
            for (Iterator<StudentTO> iterator2 = studentTOs2.iterator(); iterator2.hasNext();) {
                StudentTO studentTO = (StudentTO) iterator2.next();
                System.out.println("Name " + studentTO.getName());
            }
        }
        
        resetStudent();
        
        for (Iterator<StudentTO> studentIterator = students.iterator(); studentIterator.hasNext();) {
            StudentTO student = studentIterator.next();

            for (Iterator<StudentSetTO> setIterator = sets.iterator(); setIterator.hasNext();) {
                List<StudentTO> studentsInSet = setIterator.next().getStudents();

                for (Iterator<StudentTO> studentInSetIterator = studentsInSet.iterator(); studentInSetIterator.hasNext();) {
                    StudentTO studentInSet = studentInSetIterator.next();
                    if (studentInSet.getResourceId() == student.getResourceId()) {
                        students.remove(student);
                    }
                }
            }
        }
    }
    
    private void resetStudent(){
        
        selectedStudent = new StudentTO();
        selectedStudent.setActive(true);
        selectedStudent.setCategory(0l);
        selectedStudent.setCurrentStandard("");
        selectedStudent.setDivision("");
        selectedStudent.setFatherName("");
        selectedStudent.setFatherOccupation("");
        selectedStudent.setGender("");
        selectedStudent.setLastName("");
        selectedStudent.setMediumOfEducation("");
        selectedStudent.setMotherName("");
        selectedStudent.setMotherOccupation("");
        selectedStudent.setName("");
        selectedStudent.setNumberOfFemaleSiblings(0);
        selectedStudent.setNumberOfMaleSiblings(0);
    }

    public void onAddNewSetClick() {
        FacesContext context = FacesContext.getCurrentInstance();
        selectedSet = new StudentSetTO();
        try {
            selectedSet = studentSetServiceLocal.addStudentSetTOSchool(selectedSet, logedInSchool);
            sets.add(selectedSet);
        }
        catch (BusinessException e) {
            context.addMessage(null, new FacesMessage("Unable to create "));
            return;
        }
    }
    
    public void onAddNewStudentClick(boolean set){
        this.set = set;
        
        resetStudent();
     
        showStudentSet = set;
        studentMarksDetailDialog = false;
        studentDetailDialog = true;
    }

    public void onRemoveStudentClick() {
    }
    
    public void onAddUpdateStudentClick(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        if(TextUtils.emptyUtil(selectedStudent.getLastName())){
            context.addMessage(null, new FacesMessage("Invalid Student Last Name"));
            return;
        }
        
        if(TextUtils.emptyUtil(selectedStudent.getName())){
            context.addMessage(null, new FacesMessage("Invalid Student Name"));
            return;
        }
        
        if(TextUtils.emptyUtil(selectedStudent.getFatherName())){
            context.addMessage(null, new FacesMessage("Invalid Student Middel Name"));
            return;
        }
        
        if(TextUtils.emptyUtil(selectedStudent.getMotherName())){
            context.addMessage(null, new FacesMessage("Invalid Student MOther Name"));
            return;
        }
        
        if(TextUtils.emptyUtil(selectedStudent.getGender())){
            context.addMessage(null, new FacesMessage("Invalid Student Gender"));
            return;
        }
        
        if(selectedDOB == null){
            context.addMessage(null, new FacesMessage("Invalid Student DOB"));
            return;
        }else {
            selectedStudent.setDOB(selectedDOB.getTime());
        }
        
        if(TextUtils.emptyUtil(selectedStudent.getMediumOfEducation())){
            context.addMessage(null, new FacesMessage("Invalid Student Medium"));
            return;
        }
        
        if(TextUtils.emptyUtil(selectedStudent.getDivision())){
            context.addMessage(null, new FacesMessage("Invalid Student Division"));
            return;
        }
        
        if(selectedFatherDOB == null){
            context.addMessage(null, new FacesMessage("Invalid Student's Father DOB"));
            return;
        } else {
            selectedStudent.setFatherDOB(selectedFatherDOB.getTime());
        }
        
        if(selectedMotherDOB == null){
            context.addMessage(null, new FacesMessage("Invalid Student's Mother DOB"));
            return;
        } else {
            selectedStudent.setMotherDOB(selectedMotherDOB.getTime());
        }
        
        if(TextUtils.emptyUtil(selectedStudent.getFatherOccupation())){
            context.addMessage(null, new FacesMessage("Invalid Student's Father Ocupation"));
            return;
        }
        
        if(TextUtils.emptyUtil(selectedStudent.getMotherOccupation())){
            context.addMessage(null, new FacesMessage("Invalid Student's Mother Occupation"));
            return;
        }
        
        try {
            if(selectedStudent.getResourceId() == null || selectedStudent.getResourceId() == 0l){
                selectedStudent = studentServiceLocal.addStudent(selectedStudent, logedInSchool);
            } else {
                selectedStudent = studentServiceLocal.editStudent(selectedStudent);
            }
            
            if(set){
                selectedSet = studentSetServiceLocal.addStudentTOSet(selectedSet, selectedStudent);
                set = false;
                selectedSet.getStudents().add(selectedStudent);
            }
            
            logedInSchool.getStudents().add(selectedStudent);
        }
        catch (BusinessException e) {
            e.printStackTrace();
        }
        studentDetailDialog = false;
    }

    public void onSetSelect(SelectEvent event) {
        selectedSet = (StudentSetTO) event.getObject();
    }

    public void onSetUnselect(UnselectEvent event) {
        selectedSet = null;
    }
    
    public void onStudentSelect(SelectEvent event) {
        selectedStudent = (StudentTO) event.getObject();
        if(selectedStudent.getDOB() != null){
            selectedDOB.setTime((selectedStudent.getDOB()));
        }
        
        if(selectedStudent.getFatherDOB() != null){
            selectedFatherDOB.setTime((selectedStudent.getDOB()));
        }
        
        if(selectedStudent.getMotherDOB() != null){
            selectedMotherDOB.setTime((selectedStudent.getDOB()));
        }
    }
    
    public void onEditMarksheet(ActionEvent event){
        studentMarksDetailDialog = true;
        List<MarksheetTO> marksheets = selectedStudent.getMarksheets(); 
        if(marksheets == null){
            marksheets = new ArrayList<MarksheetTO>();
            selectedStudent.setMarksheets(marksheets);
        }
    }
    
    public void onAddMarksheet(ActionEvent event){
        MarksheetTO marksheet = new MarksheetTO();
        List<MarksheetDataTO> marksheetDatas = new ArrayList<MarksheetDataTO>();
        marksheetDatas.add(new MarksheetDataTO());
        marksheet.setMarksheetDatas(marksheetDatas);
        selectedStudent.getMarksheets().add(marksheet);
    }
    
    public void onEditStudentClick(StudentTO student){
        selectedStudent = student;
        
        selectedDOB.setTime(selectedStudent.getDOB());
        selectedFatherDOB.setTime(selectedStudent.getFatherDOB());
        selectedMotherDOB.setTime(selectedStudent.getMotherDOB());
        studentDetailDialog = true;
    }
    
    public void onShowStudentClick(){
            selectedStudents = students;
        showStudents = true;
    }
    
    public void onEditSchoolSetClick(StudentSetTO set){
        showStudentSet = true;
        selectedSet = set;
    }
    
    public void onSelectMarksheet(SelectEvent event){
        selectedMarksheet = (MarksheetTO) event.getObject();
    }
    
    public void onRemoveMarksheet(MarksheetTO marksheet){
        selectedStudent.getMarksheets().remove(marksheet);
    }

    public void onStudentUnselect(SelectEvent event) {
        selectedStudents = null;
    }
    
    public void handleDateSelect(DateSelectEvent event){
    }

    public SchoolTO getLogedInSchool() {
        return logedInSchool;
    }

    public void setLogedInSchool(SchoolTO logedInSchool) {
        this.logedInSchool = logedInSchool;
    }

    public SchoolServiceLocal getSchoolServiceLocal() {
        return schoolServiceLocal;
    }

    public void setSchoolServiceLocal(SchoolServiceLocal schoolServiceLocal) {
        this.schoolServiceLocal = schoolServiceLocal;
    }

    public UserServiceLocal getUserServiceLocal() {
        return userServiceLocal;
    }

    public void setUserServiceLocal(UserServiceLocal userServiceLocal) {
        this.userServiceLocal = userServiceLocal;
    }

    public List<StudentSetTO> getSets() {
        return sets;
    }

    public void setSets(List<StudentSetTO> sets) {
        this.sets = sets;
    }

    public List<StudentTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentTO> students) {
        this.students = students;
    }

    public StudentSetTO getSelectedSet() {
        return selectedSet;
    }

    public void setSelectedSet(StudentSetTO selectedSet) {
        this.selectedSet = selectedSet;
    }

    public List<StudentTO> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<StudentTO> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }

    public boolean isShowStudentSet() {
        return showStudentSet;
    }

    public void setShowStudentSet(boolean showStudentSet) {
        this.showStudentSet = showStudentSet;
    }

    public StudentTO getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(StudentTO selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public Date getSelectedDOB() {
        return selectedDOB;
    }

    public void setSelectedDOB(Date selectedDOB) {
        this.selectedDOB = selectedDOB;
    }

    public Date getSelectedFatherDOB() {
        return selectedFatherDOB;
    }

    public void setSelectedFatherDOB(Date selectedFatherDOB) {
        this.selectedFatherDOB = selectedFatherDOB;
    }

    public Date getSelectedMotherDOB() {
        return selectedMotherDOB;
    }

    public void setSelectedMotherDOB(Date selectedMotherDOB) {
        this.selectedMotherDOB = selectedMotherDOB;
    }

    public boolean isStudentDetailDialog() {
        return studentDetailDialog;
    }

    public void setStudentDetailDialog(boolean studentDetailDialog) {
        this.studentDetailDialog = studentDetailDialog;
    }

    public boolean isStudentMarksDetailDialog() {
        return studentMarksDetailDialog;
    }

    public void setStudentMarksDetailDialog(boolean studentMarksDetailDialog) {
        this.studentMarksDetailDialog = studentMarksDetailDialog;
    }

    public MarksheetTO getSelectedMarksheet() {
        return selectedMarksheet;
    }

    public void setSelectedMarksheet(MarksheetTO selectedMarksheet) {
        this.selectedMarksheet = selectedMarksheet;
    }

    public Boolean getSet() {
        return set;
    }

    public void setSet(Boolean set) {
        this.set = set;
    }

    public boolean isShowStudents() {
        return showStudents;
    }

    public void setShowStudents(boolean showStudents) {
        this.showStudents = showStudents;
    }
}