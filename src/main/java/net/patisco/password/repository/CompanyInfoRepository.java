package net.patisco.password.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import net.patisco.password.domain.CompanyInfo;

public interface CompanyInfoRepository extends Repository<CompanyInfo, Long> {

	List<CompanyInfo> findByEMailAddressOrEMailOfContact(String email, String email2);
	
}
