package com.example.demo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BankDetails;

@Repository
public class BankDetailsDao extends AbstractDao<Long, BankDetails> {

	public BankDetails findByIfsc(String ifsc) {
		return (BankDetails) getCriteria()
				.add(Restrictions.eq("bank_ifsc", ifsc.toUpperCase()))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<BankDetails> findByNameAndCity(String name, String city) {
		return getCriteria()

				.add(Restrictions.and(Restrictions.eq("bank_name", name.toUpperCase()),
						Restrictions.eq("bank_city", city.toUpperCase())))
				.list();
	}

}
