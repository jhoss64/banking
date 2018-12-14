package com.ads2018II.banking.domain.repository.users;

import java.util.List;

import com.ads2018II.banking.domain.entity.users.UserClaim;

public interface UserClaimRepository {
	public List<UserClaim> findByUserId(Long userId) throws Exception;
}
