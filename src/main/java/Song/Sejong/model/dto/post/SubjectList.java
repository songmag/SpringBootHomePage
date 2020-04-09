package Song.Sejong.model.dto.post;

import java.util.List;

public class SubjectList {
    protected List<Subject> subjectList;
    protected Subject selectedSubject;

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Subject getSelectedSubject() {
        return selectedSubject;
    }

    public void setSelectedSubject(Subject selectedSubject) {
        this.selectedSubject = selectedSubject;
    }
}
