package com.expense.service;

import com.expense.dao.MenuDAO;
import com.expense.model.Menu;
import java.util.List;

public class MenuService {

    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu> getActiveMenus() {

        return menuDAO.getActiveMenus();
    }
}