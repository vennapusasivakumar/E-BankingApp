package com.ty.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.bank.entity.Account;

public interface Accountrepository extends JpaRepository<Account, Long> {

}
