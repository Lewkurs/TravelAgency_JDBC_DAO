package DAO;

import Business_Aspects.Activities;
import Business_Aspects.Destinations;

import java.util.List;

public interface ActivitiesDAO extends IDAO<Activities> {

    Activities create(Activities activity); // Create a new activity

    Activities getById(int activityID); // Get an activity by its ID

    List<Activities> getAll(); // Get all activities

    Activities update(Activities activity); // Update an activity

    Activities delete(Activities activity); // Delete an activity
}
