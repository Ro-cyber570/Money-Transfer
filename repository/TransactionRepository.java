package com.example.repository;

import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TransactionType;

public interface TransactionRepository {
	void insert(Transaction transaction,Account account);
	
}
