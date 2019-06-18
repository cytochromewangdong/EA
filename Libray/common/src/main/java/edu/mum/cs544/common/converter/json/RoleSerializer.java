package edu.mum.cs544.common.converter.json;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import edu.mum.cs544.common.domain.Role;

@Component
public class RoleSerializer extends StdSerializer<Role> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4832332447387695299L;

	public RoleSerializer() {
		super(Role.class);
	}

	@Override
	public void serialize(Role r, JsonGenerator jsonGenerator, SerializerProvider serializer) {
		try {
			// jsonGenerator.writeStartObject();
			// jsonGenerator.writeStringField("student", student.getNumber());
			jsonGenerator.writeString(r.getRole());
			// jsonGenerator.writeEndObject();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}