package Song.Sejong.model.modelConverter;

import Song.Sejong.model.dto.post.Subject;
import Song.Sejong.model.entity.SubjectEntity;
import Song.Sejong.model.modelConverter.ModelAndEntityConvertor;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter implements ModelAndEntityConvertor<SubjectEntity, Subject> {
    @Override
    public Subject entityToModel(SubjectEntity entity) {
        Subject subject = new Subject();
        subject.setName(entity.getSubject());
        subject.setId(entity.getSubjectId());
        return subject;
    }

    @Override
    public SubjectEntity modelToEntity(Subject model) {
        SubjectEntity entity = new SubjectEntity();
        entity.setSubject(model.getName());
        entity.setSubjectId(model.getId());
        return entity;
    }
}
