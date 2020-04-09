package Song.Sejong.model.dto.portfolio;

public class PortfolioThumbnail {
    private String src;
    private String name;
    private String introduce;

    public PortfolioThumbnail() {
    }

    public PortfolioThumbnail(String src, String name, String introduce) {
        this.src = src;
        this.name = name;
        this.introduce = introduce;
    }
    public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
