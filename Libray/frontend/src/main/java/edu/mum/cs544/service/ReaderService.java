package edu.mum.cs544.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.mum.cs544.common.Constants;
import edu.mum.cs544.common.domain.Member;
import edu.mum.cs544.common.service.base.BaseService;
import edu.mum.cs544.dto.ListResultDto;
import edu.mum.cs544.dto.SimpleResultDto;
import edu.mum.cs544.dto.base.DataPart;

@Service
@Transactional
public class ReaderService extends BaseService {

	public void deleteUser(Long id) {
		Member member = memberRepository.getOne(id);
		member.setRemovalFlag(1);
	}

	public ListResultDto<Member> getAll(int page) {
		Page<Member> pageItem = memberRepository.findByRemovalFlagOrderByModifyDate(0,
				PageRequest.of(page, Constants.PAGE_SIZE));
		return new ListResultDto<>(new DataPart<>(pageItem.getContent(), pageItem.getTotalElements()));
	}

	public SimpleResultDto<Member> add(Member m) {
		memberRepository.save(m);
		return new SimpleResultDto<>(m);
	}

	public SimpleResultDto<Member> update(Member member, Long id) {
		member.setId(id);
		memberRepository.save(member);
//		member.getRoleList().forEach(e->{});
		return new SimpleResultDto<>(member);
	}

	public SimpleResultDto<Member> getOne(long id) {
		return new SimpleResultDto<>(memberRepository.findById(id).get());
	}

}
