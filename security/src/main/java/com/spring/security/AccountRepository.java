package com.spring.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByName(String name);
}
