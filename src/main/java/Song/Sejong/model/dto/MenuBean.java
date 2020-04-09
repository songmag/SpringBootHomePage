package Song.Sejong.model.dto;

import Song.Sejong.model.MenuItemDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuBean {
    private List<MenuItemDto> menus;

    public MenuBean() {
        this.menus = new ArrayList(Arrays.asList(MenuItemDto.values()));
    }
    public void setMenu(MenuItemDto menuItemValue,boolean active)
    {
        for(MenuItemDto dto : menus)
        {
            if(dto.equals(menuItemValue))
            {
                dto.setActive(active);
            }
        }
    }
    public List<MenuItemDto> getMenus() {
        return menus;
    }
    public void setMenus(List<MenuItemDto> menus) {
        this.menus = menus;
    }
}
