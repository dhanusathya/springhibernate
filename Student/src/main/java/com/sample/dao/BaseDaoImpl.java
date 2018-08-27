package com.sample.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sample.controller.StudentController;

public class BaseDaoImpl extends JdbcDaoSupport implements BaseDao{
	
	 @Autowired
	    protected SessionFactory sessionFactory;
	
	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
}

