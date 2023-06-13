package DAO;

import Business_Aspects.Activities;
import Business_Aspects.Destinations;
import DAO.ConnectionPool;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public interface ActivitiesDAO extends IDAO<Activities> {

    Activities create(Activities activity); // Create a new activity

    Activities getById(int activityID); // Get an activity by its ID

    List<Activities> getAll(); // Get all activities

    Activities update(Activities activity); // Update an activity

    Activities delete(Activities activity); // Delete an activity


}

