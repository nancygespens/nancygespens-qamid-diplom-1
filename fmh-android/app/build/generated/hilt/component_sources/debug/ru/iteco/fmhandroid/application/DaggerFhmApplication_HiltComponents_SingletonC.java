// Generated by Dagger (https://dagger.dev).
package ru.iteco.fmhandroid.application;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import ru.iteco.fmhandroid.api.ApiModule;
import ru.iteco.fmhandroid.api.ApiModule_ProvideClaimApiFactory;
import ru.iteco.fmhandroid.api.ApiModule_ProvideNewsApiFactory;
import ru.iteco.fmhandroid.api.ApiModule_ProvideUserApiFactory;
import ru.iteco.fmhandroid.api.AuthApi;
import ru.iteco.fmhandroid.api.AuthApiModule;
import ru.iteco.fmhandroid.api.AuthApiModule_ProvideAuthApiFactory;
import ru.iteco.fmhandroid.api.ClaimApi;
import ru.iteco.fmhandroid.api.NetworkModule;
import ru.iteco.fmhandroid.api.NetworkModule_AuthorizedOkhttpFactory;
import ru.iteco.fmhandroid.api.NetworkModule_LoggingInterceptorFactory;
import ru.iteco.fmhandroid.api.NetworkModule_NonAuthorizedOkhttpFactory;
import ru.iteco.fmhandroid.api.NetworkModule_ProvideAuthorizedRetrofitFactory;
import ru.iteco.fmhandroid.api.NetworkModule_ProvideNonAuthorizedRetrofitFactory;
import ru.iteco.fmhandroid.api.NetworkModule_ProvideRefreshRetrofitFactory;
import ru.iteco.fmhandroid.api.NetworkModule_RefreshOkhttpFactory;
import ru.iteco.fmhandroid.api.NewsApi;
import ru.iteco.fmhandroid.api.RefreshApiModule;
import ru.iteco.fmhandroid.api.RefreshApiModule_ProvideRefreshTokensApiFactory;
import ru.iteco.fmhandroid.api.RefreshTokensApi;
import ru.iteco.fmhandroid.api.UserApi;
import ru.iteco.fmhandroid.auth.AppAuth;
import ru.iteco.fmhandroid.dao.ClaimCommentDao;
import ru.iteco.fmhandroid.dao.ClaimDao;
import ru.iteco.fmhandroid.dao.DaoModule;
import ru.iteco.fmhandroid.dao.DaoModule_ProvideClaimCommentDaoFactory;
import ru.iteco.fmhandroid.dao.DaoModule_ProvideClaimDaoFactory;
import ru.iteco.fmhandroid.dao.DaoModule_ProvideNewsCategoryDaoFactory;
import ru.iteco.fmhandroid.dao.DaoModule_ProvideNewsDaoFactory;
import ru.iteco.fmhandroid.dao.NewsCategoryDao;
import ru.iteco.fmhandroid.dao.NewsDao;
import ru.iteco.fmhandroid.db.AppDb;
import ru.iteco.fmhandroid.db.DbModule;
import ru.iteco.fmhandroid.db.DbModule_ProvideDbFactory;
import ru.iteco.fmhandroid.repository.authRepository.AuthRepository;
import ru.iteco.fmhandroid.repository.authRepository.AuthRepositoryImpl;
import ru.iteco.fmhandroid.repository.claimRepository.ClaimRepositoryImpl;
import ru.iteco.fmhandroid.repository.newsRepository.NewsRepositoryImpl;
import ru.iteco.fmhandroid.repository.userRepository.UserRepositoryImpl;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.AuthFragment;
import ru.iteco.fmhandroid.ui.ClaimListFilteringDialogFragment;
import ru.iteco.fmhandroid.ui.ClaimListFragment;
import ru.iteco.fmhandroid.ui.CreateEditClaimCommentFragment;
import ru.iteco.fmhandroid.ui.CreateEditClaimFragment;
import ru.iteco.fmhandroid.ui.CreateEditNewsFragment;
import ru.iteco.fmhandroid.ui.FilterNewsListFragment;
import ru.iteco.fmhandroid.ui.MainFragment;
import ru.iteco.fmhandroid.ui.NewsControlPanelFragment;
import ru.iteco.fmhandroid.ui.NewsListFragment;
import ru.iteco.fmhandroid.ui.OpenClaimFragment;
import ru.iteco.fmhandroid.ui.OurMissionFragment;
import ru.iteco.fmhandroid.ui.SplashScreenFragment;
import ru.iteco.fmhandroid.ui.SplashScreenFragment_MembersInjector;
import ru.iteco.fmhandroid.viewmodel.AuthViewModel;
import ru.iteco.fmhandroid.viewmodel.AuthViewModel_HiltModules_KeyModule_ProvideFactory;
import ru.iteco.fmhandroid.viewmodel.ClaimCardViewModel;
import ru.iteco.fmhandroid.viewmodel.ClaimCardViewModel_HiltModules_KeyModule_ProvideFactory;
import ru.iteco.fmhandroid.viewmodel.ClaimViewModel;
import ru.iteco.fmhandroid.viewmodel.ClaimViewModel_HiltModules_KeyModule_ProvideFactory;
import ru.iteco.fmhandroid.viewmodel.NewsControlPanelViewModel;
import ru.iteco.fmhandroid.viewmodel.NewsControlPanelViewModel_HiltModules_KeyModule_ProvideFactory;
import ru.iteco.fmhandroid.viewmodel.NewsViewModel;
import ru.iteco.fmhandroid.viewmodel.NewsViewModel_HiltModules_KeyModule_ProvideFactory;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerFhmApplication_HiltComponents_SingletonC extends FhmApplication_HiltComponents.SingletonC {
  private final ApplicationContextModule applicationContextModule;

  private final DaggerFhmApplication_HiltComponents_SingletonC singletonC = this;

  private Provider<AppAuth> appAuthProvider;

  private Provider<AuthApi> provideAuthApiProvider;

  private Provider<RefreshTokensApi> provideRefreshTokensApiProvider;

  private Provider<AuthRepositoryImpl> authRepositoryImplProvider;

  private Provider<UserApi> provideUserApiProvider;

  private Provider<UserRepositoryImpl> userRepositoryImplProvider;

  private Provider<ClaimApi> provideClaimApiProvider;

  private Provider<AppDb> provideDbProvider;

  private Provider<ClaimRepositoryImpl> claimRepositoryImplProvider;

  private Provider<NewsApi> provideNewsApiProvider;

  private Provider<NewsRepositoryImpl> newsRepositoryImplProvider;

  private DaggerFhmApplication_HiltComponents_SingletonC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
    initialize(applicationContextModuleParam);

  }

  public static Builder builder() {
    return new Builder();
  }

  private OkHttpClient nonAuthorizedOkHttpClient() {
    return NetworkModule_NonAuthorizedOkhttpFactory.nonAuthorizedOkhttp(NetworkModule_LoggingInterceptorFactory.loggingInterceptor());
  }

  private Retrofit nonAuthorizedRetrofit() {
    return NetworkModule_ProvideNonAuthorizedRetrofitFactory.provideNonAuthorizedRetrofit(nonAuthorizedOkHttpClient());
  }

  private OkHttpClient refreshOkHttpClient() {
    return NetworkModule_RefreshOkhttpFactory.refreshOkhttp(NetworkModule_LoggingInterceptorFactory.loggingInterceptor(), appAuthProvider.get());
  }

  private Retrofit refreshRetrofit() {
    return NetworkModule_ProvideRefreshRetrofitFactory.provideRefreshRetrofit(refreshOkHttpClient());
  }

  private OkHttpClient authorizedOkHttpClient() {
    return NetworkModule_AuthorizedOkhttpFactory.authorizedOkhttp(NetworkModule_LoggingInterceptorFactory.loggingInterceptor(), appAuthProvider.get(), ((Provider) authRepositoryImplProvider));
  }

  private Retrofit authorizedRetrofit() {
    return NetworkModule_ProvideAuthorizedRetrofitFactory.provideAuthorizedRetrofit(authorizedOkHttpClient());
  }

  private ClaimDao claimDao() {
    return DaoModule_ProvideClaimDaoFactory.provideClaimDao(provideDbProvider.get());
  }

  private ClaimCommentDao claimCommentDao() {
    return DaoModule_ProvideClaimCommentDaoFactory.provideClaimCommentDao(provideDbProvider.get());
  }

  private NewsDao newsDao() {
    return DaoModule_ProvideNewsDaoFactory.provideNewsDao(provideDbProvider.get());
  }

  private NewsCategoryDao newsCategoryDao() {
    return DaoModule_ProvideNewsCategoryDaoFactory.provideNewsCategoryDao(provideDbProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final ApplicationContextModule applicationContextModuleParam) {
    this.appAuthProvider = DoubleCheck.provider(new SwitchingProvider<AppAuth>(singletonC, 0));
    this.provideAuthApiProvider = DoubleCheck.provider(new SwitchingProvider<AuthApi>(singletonC, 3));
    this.provideRefreshTokensApiProvider = DoubleCheck.provider(new SwitchingProvider<RefreshTokensApi>(singletonC, 4));
    this.authRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<AuthRepositoryImpl>(singletonC, 2));
    this.provideUserApiProvider = DoubleCheck.provider(new SwitchingProvider<UserApi>(singletonC, 1));
    this.userRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<UserRepositoryImpl>(singletonC, 5));
    this.provideClaimApiProvider = DoubleCheck.provider(new SwitchingProvider<ClaimApi>(singletonC, 7));
    this.provideDbProvider = DoubleCheck.provider(new SwitchingProvider<AppDb>(singletonC, 8));
    this.claimRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<ClaimRepositoryImpl>(singletonC, 6));
    this.provideNewsApiProvider = DoubleCheck.provider(new SwitchingProvider<NewsApi>(singletonC, 10));
    this.newsRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<NewsRepositoryImpl>(singletonC, 9));
  }

  @Override
  public Set<Boolean> getDisableFragmentGetContextFix() {
    return Collections.<Boolean>emptySet();
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder(singletonC);
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder(singletonC);
  }

  @Override
  public void injectFhmApplication(FhmApplication fhmApplication) {
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder apiModule(ApiModule apiModule) {
      Preconditions.checkNotNull(apiModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder networkModule(NetworkModule networkModule) {
      Preconditions.checkNotNull(networkModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder authApiModule(AuthApiModule authApiModule) {
      Preconditions.checkNotNull(authApiModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder daoModule(DaoModule daoModule) {
      Preconditions.checkNotNull(daoModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder dbModule(DbModule dbModule) {
      Preconditions.checkNotNull(dbModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder refreshApiModule(RefreshApiModule refreshApiModule) {
      Preconditions.checkNotNull(refreshApiModule);
      return this;
    }

    public FhmApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerFhmApplication_HiltComponents_SingletonC(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements FhmApplication_HiltComponents.ActivityRetainedC.Builder {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private ActivityRetainedCBuilder(DaggerFhmApplication_HiltComponents_SingletonC singletonC) {
      this.singletonC = singletonC;
    }

    @Override
    public FhmApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonC);
    }
  }

  private static final class ActivityCBuilder implements FhmApplication_HiltComponents.ActivityC.Builder {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public FhmApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonC, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements FhmApplication_HiltComponents.FragmentC.Builder {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public FhmApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonC, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements FhmApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public FhmApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonC, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements FhmApplication_HiltComponents.ViewC.Builder {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public FhmApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonC, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements FhmApplication_HiltComponents.ViewModelC.Builder {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelCBuilder(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public FhmApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      return new ViewModelCImpl(singletonC, activityRetainedCImpl, savedStateHandle);
    }
  }

  private static final class ServiceCBuilder implements FhmApplication_HiltComponents.ServiceC.Builder {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private Service service;

    private ServiceCBuilder(DaggerFhmApplication_HiltComponents_SingletonC singletonC) {
      this.singletonC = singletonC;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public FhmApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonC, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends FhmApplication_HiltComponents.ViewWithFragmentC {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends FhmApplication_HiltComponents.FragmentC {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonC, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }

    @Override
    public void injectAuthFragment(AuthFragment authFragment) {
    }

    @Override
    public void injectClaimListFilteringDialogFragment(
        ClaimListFilteringDialogFragment claimListFilteringDialogFragment) {
    }

    @Override
    public void injectClaimListFragment(ClaimListFragment claimListFragment) {
    }

    @Override
    public void injectCreateEditClaimCommentFragment(
        CreateEditClaimCommentFragment createEditClaimCommentFragment) {
    }

    @Override
    public void injectCreateEditClaimFragment(CreateEditClaimFragment createEditClaimFragment) {
    }

    @Override
    public void injectCreateEditNewsFragment(CreateEditNewsFragment createEditNewsFragment) {
    }

    @Override
    public void injectFilterNewsListFragment(FilterNewsListFragment filterNewsListFragment) {
    }

    @Override
    public void injectMainFragment(MainFragment mainFragment) {
    }

    @Override
    public void injectNewsControlPanelFragment(NewsControlPanelFragment newsControlPanelFragment) {
    }

    @Override
    public void injectNewsListFragment(NewsListFragment newsListFragment) {
    }

    @Override
    public void injectOpenClaimFragment(OpenClaimFragment openClaimFragment) {
    }

    @Override
    public void injectOurMissionFragment(OurMissionFragment ourMissionFragment) {
    }

    @Override
    public void injectSplashScreenFragment(SplashScreenFragment splashScreenFragment) {
      injectSplashScreenFragment2(splashScreenFragment);
    }

    private SplashScreenFragment injectSplashScreenFragment2(SplashScreenFragment instance) {
      SplashScreenFragment_MembersInjector.injectAuth(instance, singletonC.appAuthProvider.get());
      SplashScreenFragment_MembersInjector.injectUserApi(instance, singletonC.provideUserApiProvider.get());
      return instance;
    }
  }

  private static final class ViewCImpl extends FhmApplication_HiltComponents.ViewC {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, View viewParam) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends FhmApplication_HiltComponents.ActivityC {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonC.applicationContextModule), getViewModelKeys(), new ViewModelCBuilder(singletonC, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(5).add(AuthViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(ClaimCardViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(ClaimViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(NewsControlPanelViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(NewsViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonC, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonC, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonC, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public void injectAppActivity(AppActivity appActivity) {
    }
  }

  private static final class ViewModelCImpl extends FhmApplication_HiltComponents.ViewModelC {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<ClaimCardViewModel> claimCardViewModelProvider;

    private Provider<ClaimViewModel> claimViewModelProvider;

    private Provider<NewsControlPanelViewModel> newsControlPanelViewModelProvider;

    private Provider<NewsViewModel> newsViewModelProvider;

    private ViewModelCImpl(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam) {
      this.singletonC = singletonC;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam) {
      this.authViewModelProvider = new SwitchingProvider<>(singletonC, activityRetainedCImpl, viewModelCImpl, 0);
      this.claimCardViewModelProvider = new SwitchingProvider<>(singletonC, activityRetainedCImpl, viewModelCImpl, 1);
      this.claimViewModelProvider = new SwitchingProvider<>(singletonC, activityRetainedCImpl, viewModelCImpl, 2);
      this.newsControlPanelViewModelProvider = new SwitchingProvider<>(singletonC, activityRetainedCImpl, viewModelCImpl, 3);
      this.newsViewModelProvider = new SwitchingProvider<>(singletonC, activityRetainedCImpl, viewModelCImpl, 4);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, Provider<ViewModel>>newMapBuilder(5).put("ru.iteco.fmhandroid.viewmodel.AuthViewModel", ((Provider) authViewModelProvider)).put("ru.iteco.fmhandroid.viewmodel.ClaimCardViewModel", ((Provider) claimCardViewModelProvider)).put("ru.iteco.fmhandroid.viewmodel.ClaimViewModel", ((Provider) claimViewModelProvider)).put("ru.iteco.fmhandroid.viewmodel.NewsControlPanelViewModel", ((Provider) newsControlPanelViewModelProvider)).put("ru.iteco.fmhandroid.viewmodel.NewsViewModel", ((Provider) newsViewModelProvider)).build();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
          ActivityRetainedCImpl activityRetainedCImpl, ViewModelCImpl viewModelCImpl, int id) {
        this.singletonC = singletonC;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // ru.iteco.fmhandroid.viewmodel.AuthViewModel 
          return (T) new AuthViewModel(singletonC.userRepositoryImplProvider.get(), (AuthRepository) ((Provider) singletonC.authRepositoryImplProvider).get(), singletonC.appAuthProvider.get());

          case 1: // ru.iteco.fmhandroid.viewmodel.ClaimCardViewModel 
          return (T) new ClaimCardViewModel(singletonC.claimRepositoryImplProvider.get(), singletonC.userRepositoryImplProvider.get());

          case 2: // ru.iteco.fmhandroid.viewmodel.ClaimViewModel 
          return (T) new ClaimViewModel(singletonC.claimRepositoryImplProvider.get());

          case 3: // ru.iteco.fmhandroid.viewmodel.NewsControlPanelViewModel 
          return (T) new NewsControlPanelViewModel(singletonC.newsRepositoryImplProvider.get(), singletonC.userRepositoryImplProvider.get());

          case 4: // ru.iteco.fmhandroid.viewmodel.NewsViewModel 
          return (T) new NewsViewModel(singletonC.newsRepositoryImplProvider.get(), singletonC.userRepositoryImplProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends FhmApplication_HiltComponents.ActivityRetainedC {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    @SuppressWarnings("rawtypes")
    private Provider lifecycleProvider;

    private ActivityRetainedCImpl(DaggerFhmApplication_HiltComponents_SingletonC singletonC) {
      this.singletonC = singletonC;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.lifecycleProvider = DoubleCheck.provider(new SwitchingProvider<Object>(singletonC, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonC, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return (ActivityRetainedLifecycle) lifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
          ActivityRetainedCImpl activityRetainedCImpl, int id) {
        this.singletonC = singletonC;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.Lifecycle 
          return (T) ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends FhmApplication_HiltComponents.ServiceC {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(DaggerFhmApplication_HiltComponents_SingletonC singletonC,
        Service serviceParam) {
      this.singletonC = singletonC;


    }
  }

  private static final class SwitchingProvider<T> implements Provider<T> {
    private final DaggerFhmApplication_HiltComponents_SingletonC singletonC;

    private final int id;

    SwitchingProvider(DaggerFhmApplication_HiltComponents_SingletonC singletonC, int id) {
      this.singletonC = singletonC;
      this.id = id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
      switch (id) {
        case 0: // ru.iteco.fmhandroid.auth.AppAuth 
        return (T) new AppAuth(ApplicationContextModule_ProvideContextFactory.provideContext(singletonC.applicationContextModule));

        case 1: // ru.iteco.fmhandroid.api.UserApi 
        return (T) ApiModule_ProvideUserApiFactory.provideUserApi(singletonC.authorizedRetrofit());

        case 2: // ru.iteco.fmhandroid.repository.authRepository.AuthRepositoryImpl 
        return (T) new AuthRepositoryImpl(singletonC.provideAuthApiProvider.get(), singletonC.provideRefreshTokensApiProvider.get(), singletonC.appAuthProvider.get());

        case 3: // ru.iteco.fmhandroid.api.AuthApi 
        return (T) AuthApiModule_ProvideAuthApiFactory.provideAuthApi(singletonC.nonAuthorizedRetrofit());

        case 4: // ru.iteco.fmhandroid.api.RefreshTokensApi 
        return (T) RefreshApiModule_ProvideRefreshTokensApiFactory.provideRefreshTokensApi(singletonC.refreshRetrofit());

        case 5: // ru.iteco.fmhandroid.repository.userRepository.UserRepositoryImpl 
        return (T) new UserRepositoryImpl(singletonC.provideUserApiProvider.get());

        case 6: // ru.iteco.fmhandroid.repository.claimRepository.ClaimRepositoryImpl 
        return (T) new ClaimRepositoryImpl(singletonC.provideClaimApiProvider.get(), singletonC.claimDao(), singletonC.claimCommentDao());

        case 7: // ru.iteco.fmhandroid.api.ClaimApi 
        return (T) ApiModule_ProvideClaimApiFactory.provideClaimApi(singletonC.authorizedRetrofit());

        case 8: // ru.iteco.fmhandroid.db.AppDb 
        return (T) DbModule_ProvideDbFactory.provideDb(ApplicationContextModule_ProvideContextFactory.provideContext(singletonC.applicationContextModule));

        case 9: // ru.iteco.fmhandroid.repository.newsRepository.NewsRepositoryImpl 
        return (T) new NewsRepositoryImpl(singletonC.newsDao(), singletonC.newsCategoryDao(), singletonC.provideNewsApiProvider.get());

        case 10: // ru.iteco.fmhandroid.api.NewsApi 
        return (T) ApiModule_ProvideNewsApiFactory.provideNewsApi(singletonC.authorizedRetrofit());

        default: throw new AssertionError(id);
      }
    }
  }
}