package com.example.springmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 서비스 아래에만 붙을 수 있음. 서비스 안의 메소드가 실행이 안되면 전부 다 취소
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	public int getCountMember() {
		return memberMapper.selectCountMember();
	}
}
