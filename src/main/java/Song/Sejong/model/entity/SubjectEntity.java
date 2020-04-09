package Song.Sejong.model.entity;

import Song.Sejong.model.modelConverter.CustomEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubjectEntity  extends CustomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subject_id")
    private Long subjectId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "connect_table"
    ,joinColumns = @JoinColumn(name = "subject_id",referencedColumnName = "subject_id"),
    inverseJoinColumns = @JoinColumn(name="user_id",referencedColumnName = "user_id"))
    private List<UserEntity> user  = new ArrayList<>();
    private String subject;

    @OneToMany(mappedBy = "subject" ,cascade = CascadeType.ALL)
    private List<PostEntity> postEntities = new ArrayList<>();

    public List<PostEntity> getPostEntities() {
        return postEntities;
    }

    public void setPostEntities(List<PostEntity> postEntities) {
        this.postEntities = postEntities;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public List<UserEntity> getUser() {
        return user;
    }

    public void setUser(List<UserEntity> user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
