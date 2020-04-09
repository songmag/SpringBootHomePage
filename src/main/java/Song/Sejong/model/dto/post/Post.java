package Song.Sejong.model.dto.post;

import Song.Sejong.model.dto.user.UserModel;
import Song.Sejong.model.modelConverter.CustomModel;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post extends CustomModel {
    private Long number;
    private String name;
    private String content;
    private String date;
    private UserModel owner;
    private Long subject;

    public Long getSubject() {
        return subject;
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }


    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", time=" + date +
                ", owner='" + owner + '\'' +
                '}';
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
}
