package com.ads2018II.banking.application.dto.users.deserializer;

import java.io.IOException;

import com.ads2018II.banking.application.dto.users.UserDto;
import com.ads2018II.banking.application.enum_common.RequestBodyType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class UserDtoDeserializer extends JsonDeserializer<UserDto> {
	
	@Override
	public UserDto deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		UserDto userDto = null;
		try {
    		ObjectCodec objectCodec = jsonParser.getCodec();
            JsonNode node = objectCodec.readTree(jsonParser);
            String name = node.get("name").asText();
            String password = node.get("password").asText();
            userDto = new UserDto(name, password);
    	} catch(Exception ex) {
    		userDto = new UserDto(RequestBodyType.INVALID.toString(), RequestBodyType.INVALID.toString());
    	}
        return userDto;
}
}
