package com.korobko.dao;

import com.korobko.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author Vova Korobko
 */
public class UserDaoImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
    }

    @Test
    public void findById() {

        UserDaoImpl userDao = new UserDaoImpl(null);
        User actual = userDao.findById(null);
        assertEquals("User", actual.getClass().getSimpleName());
        assertEquals(null, actual.getId());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}