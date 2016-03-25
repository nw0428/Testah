package org.testah.driver.http.requests;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;

public class DeleteRequestDto extends AbstractRequestDto {

    public DeleteRequestDto(final String uri) {
        super(new HttpDelete(uri), "DELETE");
    }

    public AbstractRequestDto setPayload(String payload) {
        return this;
    }

    public AbstractRequestDto setPayload(HttpEntity payload) {
        return this;
    }

    public AbstractRequestDto setPayload(Object payload) {
        return this;
    }

}
