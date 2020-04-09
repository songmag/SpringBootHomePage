package Song.Sejong.model.entity;

import Song.Sejong.model.modelConverter.CustomEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity  extends CustomEntity {
    @Id @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String imageUrl;
    private String profileImageUrl;
    @ManyToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SubjectEntity> subjects = new ArrayList<>();
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<PostEntity> entities = new ArrayList<>();

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }
    public List<PostEntity> getEntities() {
        return entities;
    }
    public void setEntities(List<PostEntity> entities) {
        this.entities = entities;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void addSubject(SubjectEntity subject) {
        this.subjects.add(subject);
        subject.getUser().add(this);
    }
}
