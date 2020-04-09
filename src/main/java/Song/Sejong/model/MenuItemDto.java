package Song.Sejong.model;

public enum MenuItemDto {
    HOME("홈","/"),MAIN("게시판 주인 소개","/main"),POST("게시판 목록","/post"),PORTFOLIO("포트폴리오","/portfolio")
    ,MAKE("제작 과정 소개","/howMake");
    private boolean active;
    private String name;
    private String url;
    MenuItemDto(String name,String url) {
        this.active = false;
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        if(this.equals(HOME))
        {
            MAKE.active = false;
            MAIN.active = false;
            POST.active = false;
            PORTFOLIO.active = false;
        }
        else if(this.equals(MAIN))
        {
            MAKE.active = false;
            HOME.active = false;
            POST.active = false;
            PORTFOLIO.active = false;
        }
        else if(this.equals(MAKE))
        {
            MAIN.active = false;
            HOME.active=false;
            POST.active = false;
            PORTFOLIO.active = false;
        }
        else if(this.equals(POST))
        {
            MAKE.active = false;
            HOME.active=false;
            MAIN.active = false;
            PORTFOLIO.active = false;
        }
        else if(this.equals(PORTFOLIO))
        {
            HOME.active=false;
            MAKE.active = false;
            POST.active = false;
            MAIN.active = false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
