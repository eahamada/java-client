package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableOwner.class)
@JsonDeserialize(as = ImmutableOwner.class)
@JsonIgnoreProperties({"gravatar_id"})
public interface Owner {

  Optional<String> getLogin();

  Optional<Integer> getId();

  Optional<String> getAvatarUrl();

  Optional<String> getUrl();

  Optional<String> getHtmlUrl();

  Optional<String> getFollowersUrl();

  Optional<String> getFollowingUrl();

  Optional<String> getGistsUrl();

  Optional<String> getStarredUrl();

  Optional<String> getSubscriptionsUrl();

  Optional<String> getOrganizationsUrl();

  Optional<String> getReposUrl();

  Optional<String> getEventsUrl();

  Optional<String> getReceivedEventsUrl();

  Optional<String> getType();

  Optional<Boolean> getSiteAdmin();

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ImmutableOwner.Builder {};
}
