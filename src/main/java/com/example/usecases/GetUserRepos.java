package com.example.usecases;

import com.damnhandy.uri.template.UriTemplate;
import com.example.model.Repo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.immutables.value.Value;

@Value.Enclosing
@Value.Immutable
public abstract class GetUserRepos {
  protected static final String PATH = "/users/{user}/repos";

  public abstract HttpUrl getBaseHttpUrl();

  public abstract ObjectMapper getObjectMapper();

  public abstract OkHttpClient getOkHttpClient();

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ImmutableGetUserRepos.Builder {};

  @Value.Immutable
  public interface Request {
    public String getUser();

    public static Builder builder() {
      return new Builder();
    }

    public static class Builder extends ImmutableGetUserRepos.Request.Builder {};
  }

  public interface Response {}

  @Value.Immutable
  @JsonSerialize(as = ImmutableGetUserRepos.DefaultResponse.class)
  @JsonDeserialize(as = ImmutableGetUserRepos.DefaultResponse.class)
  public interface DefaultResponse extends Response {
    @JsonValue
    public List<Repo> getRepos();

    public static Builder builder() {
      return new Builder();
    }

    public static class Builder extends ImmutableGetUserRepos.DefaultResponse.Builder {};
  }

  @Value.Immutable
  @JsonSerialize(as = ImmutableGetUserRepos.NotFoundResponse.class)
  @JsonDeserialize(as = ImmutableGetUserRepos.NotFoundResponse.class)
  public interface NotFoundResponse extends Response {
    public String getMessage();

    public String getDocumentationUrl();

    public static Builder builder() {
      return new Builder();
    }

    public static class Builder extends ImmutableGetUserRepos.NotFoundResponse.Builder {};
  }

  public final Response handle(final Request request) throws IOException {
    final String uri = UriTemplate.expand(PATH, ImmutableMap.of("user", request.getUser()));
    final HttpUrl url = getBaseHttpUrl().resolve(uri);
    final okhttp3.Request httpRequest = new okhttp3.Request.Builder().url(url).build();

    final okhttp3.Response httpResponse = getOkHttpClient().newCall(httpRequest).execute();
    httpResponse.code();
    final Response result;
    if (httpResponse.isSuccessful()) {
      result = mapTo(httpResponse, DefaultResponse.class);
    } else {
      result = mapTo(httpResponse, NotFoundResponse.class);
    }
    return result;
  }

  private <T extends Response> T mapTo(final okhttp3.Response httpResponse, Class<T> class1)
      throws IOException, JsonParseException, JsonMappingException {
    return getObjectMapper().readValue(httpResponse.body().string(), class1);
  }
}
