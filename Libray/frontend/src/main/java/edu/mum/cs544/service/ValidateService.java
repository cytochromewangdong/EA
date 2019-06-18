package edu.mum.cs544.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.mum.cs544.common.dto.ResultDto;
import edu.mum.cs544.common.service.base.BaseService;

@Service
@Transactional
public class ValidateService extends BaseService {

	public ResultDto validateEmailDuplicate(String email) {
		return new ResultDto(!this.loginUserRepository.findByUsernameIgnoreCase(email).isPresent());
	}
}
