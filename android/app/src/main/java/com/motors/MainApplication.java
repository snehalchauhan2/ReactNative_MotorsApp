package com.motors;

import android.content.Context;

import com.facebook.react.ReactApplication;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import io.invertase.firebase.RNFirebasePackage;

import com.google.android.gms.ads.MobileAds;
import com.oblador.vectoricons.VectorIconsPackage;
import com.motors.BuildConfig;
import com.swmansion.reanimated.ReanimatedPackage;
import com.airbnb.android.react.maps.MapsPackage;
import fr.bamlab.rnimageresizer.ImageResizerPackage;
import io.invertase.firebase.admob.RNFirebaseAdMobPackage;
import io.invertase.firebase.analytics.RNFirebaseAnalyticsPackage;
import io.invertase.firebase.auth.RNFirebaseAuthPackage;
import io.invertase.firebase.database.RNFirebaseDatabasePackage;
import io.invertase.firebase.messaging.RNFirebaseMessagingPackage;
import io.invertase.firebase.notifications.RNFirebaseNotificationsPackage;

import com.agontuk.RNFusedLocation.RNFusedLocationPackage;
import com.rnfs.RNFSPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.imagepicker.ImagePickerPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends MultiDexApplication implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
              new MainReactPackage(),
              new RNFirebasePackage(),
              new RNFirebaseAuthPackage(),
              new RNFirebaseAdMobPackage(),
              new RNFirebaseAnalyticsPackage(),
              new RNFirebaseMessagingPackage(),
              new RNFirebaseNotificationsPackage(),
              new RNFirebaseDatabasePackage(),
              new VectorIconsPackage(),
              new ReanimatedPackage(),
              new MapsPackage(),
              new ImageResizerPackage(),
              new RNFusedLocationPackage(),
              new RNFSPackage(),
              new AsyncStoragePackage(),
              new ImagePickerPackage(),
              new RNGestureHandlerPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    MobileAds.initialize(this, "your_mobile_ad_key_here");
  }

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }
}
