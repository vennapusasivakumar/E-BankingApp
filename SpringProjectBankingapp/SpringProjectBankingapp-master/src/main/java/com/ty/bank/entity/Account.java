package com.ty.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
@Column(name = "account_holder_name")
	private String accountHoldername;
	private double balance;
	
}
