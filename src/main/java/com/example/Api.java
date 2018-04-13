package com.example;

import com.example.configuration.Configuration;
import com.example.usecases.GetUserRepos;
import dagger.Component;

 @Component(modules = Configuration.class)
public interface Api {
  GetUserRepos getUserRepos();
}
