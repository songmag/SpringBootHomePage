package Song.Sejong.model.dto.post;

import Song.Sejong.model.modelConverter.CustomModel;

public class Subject  extends CustomModel {
    private String name;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
