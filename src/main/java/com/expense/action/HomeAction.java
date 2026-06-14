package com.expense.action;

import com.expense.model.Menu;
import com.expense.service.MenuService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class HomeAction extends ActionSupport {

    private List<Menu> menuList;

    public String execute() {

        MenuService menuService = new MenuService();

        menuList = menuService.getActiveMenus();

        return SUCCESS;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}