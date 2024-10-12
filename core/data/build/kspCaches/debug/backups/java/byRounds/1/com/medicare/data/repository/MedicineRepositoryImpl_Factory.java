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
public final class MedicineRepositoryImpl_Factory implements Factory<MedicineRepositoryImpl> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public MedicineRepositoryImpl_Factory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public MedicineRepositoryImpl get() {
    return newInstance(appDatabaseProvider.get());
  }

  public static MedicineRepositoryImpl_Factory create(Provider<AppDatabase> appDatabaseProvider) {
    return new MedicineRepositoryImpl_Factory(appDatabaseProvider);
  }

  public static MedicineRepositoryImpl newInstance(AppDatabase appDatabase) {
    return new MedicineRepositoryImpl(appDatabase);
  }
}
