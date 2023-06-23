package Service_Layer;

import Business_Aspects.Activities;
import DAO.ActivitiesDAO;

import java.util.List;

public class ActivitiesService {
    private ActivitiesDAO activitiesDAO;

    public ActivitiesService(ActivitiesDAO activitiesDAO) {
        this.activitiesDAO = activitiesDAO;
    }

    public Activities create(Activities activity) {
        return activitiesDAO.create(activity);
    }

    public Activities getById(int id) {
        return activitiesDAO.getById(id);
    }

    public List<Activities> getAll() {
        return activitiesDAO.getAll();
    }

    public Activities update(Activities activity) {
        return activitiesDAO.update(activity);
    }

    public Activities delete(Activities activity) {
        return activitiesDAO.delete(activity);
    }
}
