package Song.Sejong.model.dto.post;

import java.util.ArrayList;
import java.util.List;

public class PostList {
    private List<Post> posts = new ArrayList<>();
    private int currentPage;
    private int pageSize;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
