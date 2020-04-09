package Song.Sejong.model.dto;

import java.io.Serializable;

public class PortfolioDataObject implements Serializable{
    public String title;
    public String imageData;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImageData() {
        return imageData;
    }
    public void setImageData(String imageData) {
        StringBuilder builder = new StringBuilder();
        builder.append("<img width=\"500px\" src=");
        builder.append(imageData);
        builder.append(">");
        this.imageData = builder.toString();
        builder = null;
    }

    @Override
    public String toString() {
        return "{" +
                "\"title\":\"" + title + '\"' +
                ",\"data\":\"" + imageData + '\"' +
                '}';
    }
}
