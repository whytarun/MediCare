package com.medicare.data.repository;

import com.medicare.database.db.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class UserRepositoryImpl_Factory implements Factory<UserRepositoryImpl> {
  private final Provider<AppDatabase> databaseProvider;

  public UserRepositoryImpl_Factory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UserRepositoryImpl get() {
    return newInstance(databaseProvider.get());
  }

  public static UserRepositoryImpl_Factory create(Provider<AppDatabase> databaseProvider) {
    return new UserRepositoryImpl_Factory(databaseProvider);
  }

  public static UserRepositoryImpl newInstance(AppDatabase database) {
    return new UserRepositoryImpl(database);
  }
}
