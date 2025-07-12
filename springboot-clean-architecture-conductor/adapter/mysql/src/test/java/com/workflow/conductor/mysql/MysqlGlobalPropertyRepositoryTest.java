package com.workflow.conductor.mysql;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.usecase.globalprop.port.GlobalPropertyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class MysqlGlobalPropertyRepositoryTest {

    @Container
    static JdbcDatabaseContainer mySQLContainer = new MySQLContainer("mysql:latest")
            .withDatabaseName("workflow")
            .withUsername("test")
            .withPassword("test")
            .withInitScript("db/init.sql");

    private static final GlobalPropertyRepository repository;

    static {
        mySQLContainer.start();
        repository = new MysqlGlobalPropertyRepository(mySQLContainer.getJdbcUrl(), mySQLContainer.getUsername(), mySQLContainer.getPassword());
    }

    @BeforeEach
    void init() {
        repository.save(new GlobalProperty(1L, "testName1", "testValue1"));
    }

    @AfterEach
    void clear() {
        repository.deleteAll();
    }

    @Test
    public void testSaveAndFindById() {
        long autoIncrementId = 2L;
        String name = "testName2";
        String value = "testValue2";
        GlobalProperty globalProperty = new GlobalProperty(name, value);

        repository.save(globalProperty);
        GlobalProperty findById = repository.findById(autoIncrementId)
                .orElse(null);

        Assertions.assertNotNull(findById);
        Assertions.assertEquals(findById.getId().longValue(), autoIncrementId);
        Assertions.assertEquals(findById.getName(), name);
        Assertions.assertEquals(findById.getValue(), value);
    }

    @Test
    public void testUpdateAndFindById() {
        long existId = 1L;
        String name = "testName1";
        String updatedValue = "value-update";
        GlobalProperty globalProperty = new GlobalProperty(existId, name, updatedValue);

        repository.update(globalProperty);
        GlobalProperty findById = repository.findById(existId)
                .orElse(null);

        Assertions.assertNotNull(findById);
        Assertions.assertEquals(findById.getId().longValue(), existId);
        Assertions.assertEquals(findById.getName(), name);
        Assertions.assertEquals(findById.getValue(), updatedValue);
    }

    @Test
    public void testDeleteByIdAndFindById() {
        long existId = 1L;

        repository.deleteById(existId);

        Assertions.assertTrue(repository.findById(existId).isEmpty());
    }
}
