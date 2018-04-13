package com.example.usecases;

import org.junit.Test;
import com.example.Api;
import com.example.DaggerApi;
import com.example.usecases.GetUserRepos.Request;

public class GetUserReposTest {

  @Test
  public void testListRepos() throws Exception {
    final Api api = DaggerApi.builder().build();
    final GetUserRepos getUserRepos = api.getUserRepos();
    final Request request = GetUserRepos.Request.builder().user("elarif").build();
    final GetUserRepos.Response handle = getUserRepos.handle(request);
  }
}
