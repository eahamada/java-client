package com.example.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableRepo.class)
@JsonDeserialize(as = ImmutableRepo.class)
public interface Repo {

  Optional<Integer> getId();

  Optional<String> getName();

  Optional<String> getFullName();

  Optional<Owner> getOwner();

  Optional<Boolean> getPrivate();

  Optional<String> getHtmlUrl();

  Optional<String> getDescription();

  Optional<Boolean> getFork();

  Optional<String> getUrl();

  Optional<String> getForksUrl();

  Optional<String> getKeysUrl();

  Optional<String> getCollaboratorsUrl();

  Optional<String> getTeamsUrl();

  Optional<String> getHooksUrl();

  Optional<String> getIssueEventsUrl();

  Optional<String> getEventsUrl();

  Optional<String> getAssigneesUrl();

  Optional<String> getBranchesUrl();

  Optional<String> getTagsUrl();

  Optional<String> getBlobsUrl();

  Optional<String> getGitTagsUrl();

  Optional<String> getGitRefsUrl();

  Optional<String> getTreesUrl();

  Optional<String> getStatusesUrl();

  Optional<String> getLanguagesUrl();

  Optional<String> getStargazersUrl();

  Optional<String> getContributorsUrl();

  Optional<String> getSubscribersUrl();

  Optional<String> getSubscriptionUrl();

  Optional<String> getCommitsUrl();

  Optional<String> getGitCommitsUrl();

  Optional<String> getCommentsUrl();

  Optional<String> getIssueCommentUrl();

  Optional<String> getContentsUrl();

  Optional<String> getCompareUrl();

  Optional<String> getMergesUrl();

  Optional<String> getArchiveUrl();

  Optional<String> getDownloadsUrl();

  Optional<String> getIssuesUrl();

  Optional<String> getPullsUrl();

  Optional<String> getMilestonesUrl();

  Optional<String> getNotificationsUrl();

  Optional<String> getLabelsUrl();

  Optional<String> getReleasesUrl();

  Optional<String> getDeploymentsUrl();

  Optional<String> getCreatedAt();

  Optional<String> getUpdatedAt();

  Optional<String> getPushedAt();

  Optional<String> getGitUrl();

  Optional<String> getSshUrl();

  Optional<String> getCloneUrl();

  Optional<String> getSvnUrl();

  Optional<String> getHomepage();

  Optional<Integer> getSize();

  Optional<Integer> getStargazersCount();

  Optional<Integer> getWatchersCount();

  Optional<String> getLanguage();

  Optional<Boolean> getHasIssues();

  Optional<Boolean> getHasProjects();

  Optional<Boolean> getHasDownloads();

  Optional<Boolean> getHasWiki();

  Optional<Boolean> getHasPages();

  Optional<Integer> getForksCount();

  Optional<Object> getMirrorUrl();

  Optional<Boolean> getArchived();

  Optional<Integer> getOpenIssuesCount();

  Optional<Object> getLicense();

  Optional<Integer> getForks();

  Optional<Integer> getOpenIssues();

  Optional<Integer> getWatchers();

  Optional<String> getDefaultBranch();

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ImmutableRepo.Builder {};
}
