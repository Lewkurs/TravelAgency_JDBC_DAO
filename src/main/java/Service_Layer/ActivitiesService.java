package Service_Layer;

import Business_Aspects.Activities;
import DAO.ActivitiesDAO;

import java.sql.SQLException;
import java.util.List;


import java.util.List;

public class ActivitiesService {
    private ActivitiesDAO activitiesDAO;

    public ActivitiesService(ActivitiesDAO activitiesDAO) {
        this.activitiesDAO = activitiesDAO;
    }

    public Activities getActivitiesByID(int id) {
        return activitiesDAO.getActivitiesByID(id);
    }

    public List<Activities> getAllActivities() {
        return activitiesDAO.getAllActivities();
    }

    public void saveActivities(Activities activities) {
        activitiesDAO.save(activities);
    }

    public void updateActivities(Activities activities) {
        activitiesDAO.update(activities);
    }

    public void deleteActivities(Activities activities) {
        activitiesDAO.delete(activities);
    }
}

