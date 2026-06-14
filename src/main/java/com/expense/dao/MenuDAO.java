package com.expense.dao;

import com.expense.model.Menu;
import com.expense.util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MenuDAO {

    private static final Logger logger =
            Logger.getLogger(MenuDAO.class);

    public List<Menu> getActiveMenus() {

        Session session = null;
        Transaction transaction = null;
        List<Menu> menuList = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();

            menuList = session.createQuery(
                    "FROM Menu WHERE activeFlag = 'Y' ORDER BY displayOrder",
                    Menu.class)
                    .list();

            logger.info("Menus fetched successfully");

        } catch (Exception e) {

            logger.error("Error while fetching menus", e);

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return menuList;
    }
}