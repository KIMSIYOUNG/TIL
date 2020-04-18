package com.spring.jpa;

import static org.assertj.core.api.Assertions.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJpaTest
class AccountRepositoryTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AccountRepository accountRepository;

	@Test
	void di() throws SQLException {
		final Account account = new Account();
		account.setName("kyle");

		final Account save = accountRepository.save(account);

		assertThat(save).isNotNull();

		Account saved2 = accountRepository.findByName(save.getName());
		assertThat(saved2.getId()).isEqualTo(1);
	}
}