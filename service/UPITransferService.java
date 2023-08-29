package com.example.service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TransactionType;
import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;

public class UPITransferService implements TransferService {

	private AccountRepository accountRepository;
	private TransactionRepository transactionRepository;

	public UPITransferService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;

	}

	@Override
	public boolean transfer(double amount, String source, String destination) {
		// TODO Auto-generated method stub
		LocalDateTime now = LocalDateTime.now();
		TransactionType typeDebit = TransactionType.DEBIT;
		TransactionType typeCredit = TransactionType.CREDIT;
		Account sourceAccount = accountRepository.loadAccount(source);
		if (sourceAccount == null)
			throw new AccountNotFoundException(source);
		Account destinationAccount = accountRepository.loadAccount(destination);
		if (destinationAccount == null)
			throw new AccountNotFoundException(source);

		if (sourceAccount.getBalance() < amount)
			throw new AccountBalanceException(String.valueOf(sourceAccount.getBalance()));
		Transaction transaction = new Transaction(amount, typeDebit, now, sourceAccount);
		Transaction destinationTransaction = new Transaction(amount, typeCredit, now, destinationAccount);
		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		transactionRepository.insert(transaction, sourceAccount);
		destinationAccount.setBalance(destinationAccount.getBalance() + amount);
		transactionRepository.insert(destinationTransaction, destinationAccount);
		accountRepository.updateAccount(sourceAccount);
		accountRepository.updateAccount(destinationAccount);

		return true;
	}

}
