package com.workflow.conductor.mysql;

import com.workflow.conductor.domain.Workflow;
import com.workflow.conductor.usecase.workflow.port.WorkflowRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MysqlWorkflowRepository implements WorkflowRepository {

    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    public MysqlWorkflowRepository(String URL, String USERNAME, String PASSWORD) {
        this.URL = URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public Optional<Workflow> findById(long workflowId) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "SELECT * FROM WORKFLOW WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, workflowId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return Optional.of(new Workflow(
                        rs.getLong("id"),
                        rs.getLong("project_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("jsonDefinition"),
                        rs.getString("ownerMail"),
                        rs.getLong("timeout_seconds"),
                        rs.getTimestamp("create_time").toLocalDateTime(),
                        rs.getTimestamp("modified_time").toLocalDateTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Workflow> findAllByProjectId(long projectId) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "SELECT * FROM WORKFLOW WHERE project_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, projectId);
            ResultSet rs = statement.executeQuery();
            List<Workflow> result = new ArrayList<>();
            while (rs.next()) {
                result.add(
                        new Workflow(
                                rs.getLong("id"),
                                rs.getLong("project_id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getString("jsonDefinition"),
                                rs.getString("ownerMail"),
                                rs.getLong("timeout_seconds"),
                                rs.getTimestamp("create_time").toLocalDateTime(),
                                rs.getTimestamp("modified_time").toLocalDateTime()));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public long save(Workflow workflow) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "INSERT INTO WORKFLOW (create_time, description, json_definition, modified_time, name, owner_mail, timeout_seconds, project_id) " +
                    "VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, Timestamp.valueOf(workflow.getCreateTime()));
            statement.setString(2, workflow.getDescription());
            statement.setString(3, workflow.getJsonDefinition());
            statement.setTimestamp(4, Timestamp.valueOf(workflow.getModifiedTime()));
            statement.setString(5, workflow.getName());
            statement.setString(6, workflow.getOwnerMail());
            statement.setLong(7, workflow.getTimeoutSeconds());
            statement.setLong(8, workflow.getProjectId());
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
    public long update(Workflow workflow) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "UPDATE WORKFLOW SET " +
                    "description=?, json_definition=?, modified_time=?, name=?, owner_mail=?, timeout_seconds=?, project_id=? " +
                    "WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, workflow.getDescription());
            statement.setString(2, workflow.getJsonDefinition());
            statement.setTimestamp(3, Timestamp.valueOf(workflow.getModifiedTime()));
            statement.setString(4, workflow.getName());
            statement.setString(5, workflow.getOwnerMail());
            statement.setLong(6, workflow.getTimeoutSeconds());
            statement.setLong(7, workflow.getProjectId());
            statement.setLong(8, workflow.getId());
            statement.execute();
            return workflow.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public void deleteById(long workflowId) {
        try (Connection connection = DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD)) {
            String sql = "DELETE FROM WORKFLOW WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, workflowId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
