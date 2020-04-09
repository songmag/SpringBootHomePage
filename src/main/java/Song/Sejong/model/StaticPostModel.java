package Song.Sejong.model;


public class StaticPostModel {
    private String postForm;
    private final String postName="<input type=\"text\" style=\"width:100%;\" id=\"post_name\" name=\"post_name\"/>";
    public StaticPostModel() {
        StringBuilder builder = new StringBuilder();
        builder.append("<textarea id=\"editor\" name=\"editor\" /> ");
        builder.append("<button type=\"button\" class=\"btn btn-success\"  onclick=\"sendPost()\">");
        builder.append("Send Post </button>");
        postForm = builder.toString();
    }
    public String getPostForm() {
        return postForm;
    }
    public void setPostForm(String postForm) {
        this.postForm = postForm;
    }
    public String getPostName() {
        return postName;
    }
}
