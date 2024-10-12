package com.medicare.auth.detailscreen;

import com.medicare.data.repository.MedicineRepository;
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
public final class DetailViewModel_Factory implements Factory<DetailViewModel> {
  private final Provider<MedicineRepository> medicineRepositoryProvider;

  public DetailViewModel_Factory(Provider<MedicineRepository> medicineRepositoryProvider) {
    this.medicineRepositoryProvider = medicineRepositoryProvider;
  }

  @Override
  public DetailViewModel get() {
    return newInstance(medicineRepositoryProvider.get());
  }

  public static DetailViewModel_Factory create(
      Provider<MedicineRepository> medicineRepositoryProvider) {
    return new DetailViewModel_Factory(medicineRepositoryProvider);
  }

  public static DetailViewModel newInstance(MedicineRepository medicineRepository) {
    return new DetailViewModel(medicineRepository);
  }
}
