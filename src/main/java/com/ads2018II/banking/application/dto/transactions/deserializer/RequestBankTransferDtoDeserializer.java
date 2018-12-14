package com.ads2018II.banking.application.dto.transactions.deserializer;

import java.io.IOException;
import java.math.BigDecimal;

import com.ads2018II.banking.application.dto.transactions.RequestBankTransferDto;
import com.ads2018II.banking.application.enum_common.RequestBodyType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


public class RequestBankTransferDtoDeserializer extends JsonDeserializer<RequestBankTransferDto>{
	@Override
	public RequestBankTransferDto deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		RequestBankTransferDto requestBankTransferDto = null;
		try {
    		ObjectCodec objectCodec = jsonParser.getCodec();
            JsonNode node = objectCodec.readTree(jsonParser);
            String fromAccountNumber = node.get("fromAccountNumber").asText();
            String toAccountNumber = node.get("toAccountNumber").asText();
            BigDecimal amount = new BigDecimal(node.get("amount").asText());
            requestBankTransferDto = new RequestBankTransferDto(fromAccountNumber, toAccountNumber, amount);
    	} catch(Exception ex) {
    		requestBankTransferDto = new RequestBankTransferDto(RequestBodyType.INVALID.toString(), RequestBodyType.INVALID.toString(), null);
    	}
        return requestBankTransferDto;
	}	
}
