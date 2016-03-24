package org.testah.driver.http.requests;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPut;

public class PutRequestDto extends AbstractRequestDto {

    public PutRequestDto(final String uri) {
        super(new HttpPut(uri), "PUT");
    }

    public PutRequestDto(final String uri, final String payload) {
        super(new HttpPut(uri), "PUT");
        setPayload(payload);
    }

    public PutRequestDto(final String uri, final Object payload) {
        super(new HttpPut(uri), "PUT");
        setPayload(payload);
    }

    public PutRequestDto(final String uri, final HttpEntity payload) {
        super(new HttpPut(uri), "PUT");
        setPayload(payload);
    }

}