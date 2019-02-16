package com.akhilesh.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

	public Person mapRow(ResultSet resultSet, int i) throws SQLException {

		Person person = new Person();

		person.setId(resultSet.getLong("id"));
		person.setFirstName(resultSet.getString("firstname"));
		person.setLastName(resultSet.getString("lastname"));
		person.setAge(resultSet.getInt("age"));
		return person;
	}
}
