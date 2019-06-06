package edu.mum.cs544.bank.service;

import java.util.Collection;
import java.util.function.Supplier;

import edu.mum.cs544.bank.dao.IAccountDAO;
import edu.mum.cs544.bank.dao.JPAAccountDAO;
import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.Customer;
import edu.mum.cs544.bank.jms.IJMSSender;
import edu.mum.cs544.bank.jms.JMSSender;
import edu.mum.cs544.bank.logging.ILogger;
import edu.mum.cs544.bank.logging.Logger;
import edu.mum.cs544.bank.utils.EntityManagerHelper;

public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private ICurrencyConverter currencyConverter;
	private IJMSSender jmsSender;
	private ILogger logger;

	public AccountService() {
		accountDAO = new JPAAccountDAO();
		currencyConverter = new CurrencyConverter();
		jmsSender = new JMSSender();
		logger = new Logger();
	}

	private <T> T executeInTrans(Supplier<T> s) {
		EntityManagerHelper.getCurrent().getTransaction().begin();
		try {
			T result = s.get();
			EntityManagerHelper.getCurrent().getTransaction().commit();
			return result;
		} catch (Exception e) {
			EntityManagerHelper.getCurrent().getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			EntityManagerHelper.getCurrent().close();
		}
	}

	public Account createAccount(long accountNumber, String customerName) {

		Account result = executeInTrans(() -> {
			Account account = new Account(accountNumber);
			Customer customer = new Customer(customerName);
			account.setCustomer(customer);
			accountDAO.saveAccount(account);
			return account;
		});
		logger.log(
				"createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
		return result;

	}

	public void deposit(long accountNumber, double amount) {
		executeInTrans(() -> {
			Account account = accountDAO.loadAccount(accountNumber);
			account.deposit(amount);
			accountDAO.updateAccount(account);
			return null;
		});
		logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
		}
	}

	public Account getAccount(long accountNumber) {
		return executeInTrans(() -> {
			Account account = accountDAO.loadAccount(accountNumber);
			return account;
		});
	}

	public Collection<Account> getAllAccounts() {
		return executeInTrans(() -> {
			return accountDAO.getAccounts();
		});
	}

	public void withdraw(long accountNumber, double amount) {
		executeInTrans(() -> {
			Account account = accountDAO.loadAccount(accountNumber);
			account.withdraw(amount);
			accountDAO.updateAccount(account);
			return null;
		});
		logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
	}

	public void depositEuros(long accountNumber, double amount) {
		Double amountDollarsResult = executeInTrans(() -> {
			Account account = accountDAO.loadAccount(accountNumber);
			double amountDollars = currencyConverter.euroToDollars(amount);
			account.deposit(amountDollars);
			accountDAO.updateAccount(account);
			return amountDollars;
		});
		logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
		if (amountDollarsResult > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
		}
	}

	public void withdrawEuros(long accountNumber, double amount) {
		executeInTrans(() -> {
			Account account = accountDAO.loadAccount(accountNumber);
			double amountDollars = currencyConverter.euroToDollars(amount);
			account.withdraw(amountDollars);
			accountDAO.updateAccount(account);
			return null;
		});
		logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);

	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account[] result = executeInTrans(() -> {
			Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
			Account toAccount = accountDAO.loadAccount(toAccountNumber);
			fromAccount.transferFunds(toAccount, amount, description);
			accountDAO.updateAccount(fromAccount);
			accountDAO.updateAccount(toAccount);
			return new Account[] {fromAccount, toAccount};
		});
		
		logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= "
				+ toAccountNumber + " , amount= " + amount + " , description= " + description);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("TransferFunds of $ " + amount + " from account with accountNumber= "
					+ result[0] + " to account with accountNumber= " + result[1]);
		}
	}
}
