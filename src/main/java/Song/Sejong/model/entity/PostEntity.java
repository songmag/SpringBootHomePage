package Song.Sejong.model.entity;

import Song.Sejong.model.modelConverter.CustomEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PostEntity extends CustomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(name = "name")
    private String name;
    @Column(name="content", length = 5_000)
    private String content;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="subject_id")
    private SubjectEntity subject;
    @CreationTimestamp
    @Column(name="created_on")
    private LocalDateTime time;

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public UserEntity getUser() {
        return user;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addSubject(SubjectEntity subjectEntity) {
        this.subject = subjectEntity;
        subjectEntity.getPostEntities().add(this);
    }
}
