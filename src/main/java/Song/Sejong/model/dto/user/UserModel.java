package Song.Sejong.model.dto.user;

import Song.Sejong.model.modelConverter.CustomModel;

public class UserModel  extends CustomModel {
    private String name;
    private Integer age;
    private String imageUrl;
    private String profileImageUrl;
    private String mode;
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private Long id;
    public String getProfileImageUrl() {
        return profileImageUrl;
    }
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
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
    public Long getId() {
        return id;
    }
}
