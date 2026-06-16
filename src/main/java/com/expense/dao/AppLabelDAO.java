package com.expense.dao;

import com.expense.model.AppLabel;
import com.expense.util.HibernateUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

public class AppLabelDAO {

    public Map<String, String> getLabels() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<AppLabel> list = session.createQuery(
                "FROM AppLabel", AppLabel.class).list();

        Map<String, String> labels = new HashMap<>();

        for (AppLabel label : list) {
            labels.put(label.getLabelKey(),
                       label.getLabelValue());
        }

        session.close();

        return labels;
    }
}