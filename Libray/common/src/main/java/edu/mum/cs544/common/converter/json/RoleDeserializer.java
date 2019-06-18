package edu.mum.cs544.common.converter.json;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import edu.mum.cs544.common.domain.Role;

@Component
public class RoleDeserializer extends StdDeserializer<Role> {

	private static final long serialVersionUID = 7337085342539911425L;

	public RoleDeserializer() {
		super(Role.class);
	}

	@Override
	public Role deserialize(JsonParser parser, DeserializationContext deserializer) {
		ObjectCodec codec = parser.getCodec();
		JsonNode node;
		try {
			node = codec.readTree(parser);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		String roleName = node.asText();
		Role r = new Role();
		r.setRole(roleName);
		return r;
	}
}
