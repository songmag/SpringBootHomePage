package Song.Sejong.controller;

public enum URLConst {
    MAIN("/","/post"),HOME("/howMake","/main"),MAKE("/portfolio","/"),POST("/main","/portfolio"),PORTFOLIO("/post","/howMake");
    private String left;
    private String right;
    URLConst(String left,String right)
    {
        this.left = left;
        this.right = right;
    }
    public String getLeft() {
        return left;
    }
    public void setLeft(String left) {
        this.left = left;
    }
    public String getRight() {
        return right;
    }
    public void setRight(String right) {
        this.right = right;
    }
}
