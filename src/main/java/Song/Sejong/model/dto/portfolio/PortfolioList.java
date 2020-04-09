package Song.Sejong.model.dto.portfolio;

import java.util.ArrayList;
import java.util.List;

public class PortfolioList {
    List<PortfolioThumbnail> thumbnail;

    public PortfolioList() {
        thumbnail = new ArrayList<>();
    }

    public List<PortfolioThumbnail> getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(List<PortfolioThumbnail> datas) {
        this.thumbnail = datas;
    }

    public PortfolioList(List<PortfolioThumbnail> datas) {
        this.thumbnail = datas;
    }
}
