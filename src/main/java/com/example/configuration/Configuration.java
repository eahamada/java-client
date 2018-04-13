package com.example.configuration;

import javax.inject.Named;
import com.example.usecases.GetUserRepos;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

@Module
public class Configuration {
  public Configuration() {}

  @Provides
  @Named("apiGithub")
  public static HttpUrl getBaseHttpUrl() {
    final HttpUrl base =
        new HttpUrl.Builder().scheme("https").port(443).host("api.github.com").build();
    return base;
  }
 
  @Provides
  public static ObjectMapper getObjectMapper() {
    final ObjectMapper mapper =
        new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .registerModules(new GuavaModule(), new Jdk8Module());
    return mapper;
  }

  @Provides
  public static OkHttpClient getHttpClient() {
    final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(Level.BODY);
    final OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
    return httpClient;
  }

  @Provides
  public static GetUserRepos getUserRepos(
      @Named("apiGithub") final HttpUrl baseHttpUrl, final ObjectMapper objectMapper, final OkHttpClient okHttpClient) {
    final GetUserRepos result =
        GetUserRepos.builder()
            .baseHttpUrl(baseHttpUrl)
            .objectMapper(objectMapper)
            .okHttpClient(okHttpClient)
            .build();
    return result;
  }
}
