package edu.mum.cs544.bank.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.utils.EntityManagerHelper;

public class JPAAccountDAO implements IAccountDAO {

	@Override
	public void saveAccount(Account account) {
		EntityManagerHelper.getCurrent().persist(account);

	}

	@Override
	public void updateAccount(Account account) {
		EntityManagerHelper.getCurrent().merge(account);
	}

	@Override
	public Account loadAccount(long accountnumber) {
//		return EntityManagerHelper.getCurrent().getReference(Account.class, accountnumber);
		Map<String, Object> properties = new HashMap<>();
		EntityGraph<Account> eg = EntityManagerHelper.getCurrent().createEntityGraph(Account.class);
		eg.addAttributeNodes("entryList");
		eg.addAttributeNodes("customer");
		properties.put("javax.persistence.fetchgraph", eg);
		return EntityManagerHelper.getCurrent().find(Account.class, accountnumber, properties);
	}

	@Override
	public Collection<Account> getAccounts() {
//		return getAccountsWithEntityGraph();
		return getAccountsWithJoinFetch();
	}

	private Collection<Account> getAccountsWithEntityGraph() {
		CriteriaBuilder cb = EntityManagerHelper.getCurrent().getCriteriaBuilder();
		CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		Root<Account> root = cq.from(Account.class);
		cq.select(root);
		TypedQuery<Account> query = EntityManagerHelper.getCurrent().createQuery(cq);
		EntityGraph<Account> eg = EntityManagerHelper.getCurrent().createEntityGraph(Account.class);
		eg.addAttributeNodes("entryList");
		eg.addAttributeNodes("customer");
		query.setHint("javax.persistence.fetchgraph", eg);
		return query.getResultList();
	}

	private Collection<Account> getAccountsWithJoinFetch() {

		TypedQuery<Account> query = EntityManagerHelper.getCurrent()
				.createQuery("select distinct a from Account a left join fetch a.entryList left join fetch a.customer", Account.class);
		return query.getResultList();
	}

}
