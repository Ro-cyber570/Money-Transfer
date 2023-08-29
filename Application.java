package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JDBCAccountRepository;
import com.example.repository.JDBCTransactionRepository;
import com.example.repository.TransactionRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;

public class Application {
	public static void main(String[] args) {
		AccountRepository accountRepository = new JDBCAccountRepository();
		TransactionRepository transactionRepository=new JDBCTransactionRepository();
		TransferService transferService = new UPITransferService(accountRepository,transactionRepository);
		transferService.transfer(100, "1", "2");
	}
}
