package com.workflow.conductor.mysql;

import com.workflow.conductor.domain.Project;
import com.workflow.conductor.usecase.project.port.ProjectRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MysqlProjectPropertyRepository implements ProjectRepository {

    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    public MysqlProjectPropertyRepository(String URL, String USERNAME, String PASSWORD) {
        this.URL = URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public Optional<Project> findById(long id) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "SELECT * FROM PROJECT WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return Optional.of(new Project(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("value")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Project> findAll() {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "SELECT * FROM PROJECT";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Project> result = new ArrayList<>();
            while (rs.next()) {
                result.add(
                        new Project(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public long save(Project project) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "INSERT INTO PROJECT (description, name) VALUE (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, project.getDescription());
            statement.setString(2, project.getName());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public long update(Project project) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "UPDATE PROJECT SET description=?, name=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, project.getDescription());
            statement.setString(2, project.getName());
            statement.setLong(3, project.getId());
            statement.execute();
            return project.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "DELETE FROM PROJECT WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
