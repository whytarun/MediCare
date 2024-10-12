package com.medicare.auth.home;

import com.medicare.data.repository.MedicineRepository;
import com.medicare.data.repository.UserRepository;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<MedicineRepository> medicineRepositoryProvider;

  public HomeViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<MedicineRepository> medicineRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.medicineRepositoryProvider = medicineRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(userRepositoryProvider.get(), medicineRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<MedicineRepository> medicineRepositoryProvider) {
    return new HomeViewModel_Factory(userRepositoryProvider, medicineRepositoryProvider);
  }

  public static HomeViewModel newInstance(UserRepository userRepository,
      MedicineRepository medicineRepository) {
    return new HomeViewModel(userRepository, medicineRepository);
  }
}
