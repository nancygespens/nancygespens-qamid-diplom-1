// Generated by Dagger (https://dagger.dev).
package ru.iteco.fmhandroid.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import ru.iteco.fmhandroid.auth.AppAuth;
import ru.iteco.fmhandroid.repository.authRepository.AuthRepository;
import ru.iteco.fmhandroid.repository.userRepository.UserRepository;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<AppAuth> appAuthProvider;

  public AuthViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider, Provider<AppAuth> appAuthProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
    this.appAuthProvider = appAuthProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(userRepositoryProvider.get(), authRepositoryProvider.get(), appAuthProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider, Provider<AppAuth> appAuthProvider) {
    return new AuthViewModel_Factory(userRepositoryProvider, authRepositoryProvider, appAuthProvider);
  }

  public static AuthViewModel newInstance(UserRepository userRepository,
      AuthRepository authRepository, AppAuth appAuth) {
    return new AuthViewModel(userRepository, authRepository, appAuth);
  }
}