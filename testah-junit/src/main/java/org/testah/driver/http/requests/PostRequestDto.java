package org.testah.driver.http.requests;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.testah.TS;

public class PostRequestDto extends AbstractRequestDto<PostRequestDto> {

    public PostRequestDto(final String uri) {
        super(new HttpPost(uri), "POST");
    }

    public PostRequestDto(final String uri, final String payload) {
        super(new HttpPost(uri), "POST");
        setPayload(payload);
    }

    public PostRequestDto(final String uri, final byte[] payload) {
        super(new HttpPost(uri), "POST");
        setPayload(new ByteArrayEntity(payload));
        setContentType("application/octet-stream");
    }

    public PostRequestDto(final String uri, final Object payload) {
        super(new HttpPost(uri), "POST");
        setPayload(payload);
    }

    public PostRequestDto(final String uri, final HttpEntity payload) {
        super(new HttpPost(uri), "POST");
        setPayload(payload);
    }

    public PostRequestDto setPayload(String payload) {
        try {
            if (null == payload) {
                TS.log().warn("Payload cannot be null, setting to empty string");
                payload = "";
            }
            return setPayload(new StringEntity(payload));
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PostRequestDto setPayload(final Object payload) {
        try {
            if (null == payload) {
                TS.log().warn("Payload cannot be null, setting to empty string");
                return setPayload(new StringEntity(""));
            } else {
                return setPayload(new StringEntity(TS.util().toJson(payload)));
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PostRequestDto setPayload(final HttpEntity payload) {
        try {
            if (null != payload) {
                httpEntity = payload;
                ((HttpPost) httpRequestBase).setEntity(payload);
            } else {
                TS.log().warn("payload was null so setting to empty string");
                ((HttpPost) httpRequestBase).setEntity(new StringEntity(""));
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}
