package edu.mum.cs544.mock;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MockEntry {

	@Value("${edu.mum.css544.needMock:true}")
	private boolean needMock;

	@Autowired
	private MockHandler mockHandler;

	@PostConstruct
	void createMockDateEntry() {
		if (needMock) {
//			mockHandler.createMockData();
		}
	}
}
