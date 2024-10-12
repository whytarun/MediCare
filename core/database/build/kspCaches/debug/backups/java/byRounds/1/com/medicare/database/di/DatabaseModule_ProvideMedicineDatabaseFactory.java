package com.medicare.database.di;

import android.app.Application;
import com.medicare.database.db.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideMedicineDatabaseFactory implements Factory<AppDatabase> {
  private final DatabaseModule module;

  private final Provider<Application> applicationProvider;

  public DatabaseModule_ProvideMedicineDatabaseFactory(DatabaseModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public AppDatabase get() {
    return provideMedicineDatabase(module, applicationProvider.get());
  }

  public static DatabaseModule_ProvideMedicineDatabaseFactory create(DatabaseModule module,
      Provider<Application> applicationProvider) {
    return new DatabaseModule_ProvideMedicineDatabaseFactory(module, applicationProvider);
  }

  public static AppDatabase provideMedicineDatabase(DatabaseModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideMedicineDatabase(application));
  }
}
