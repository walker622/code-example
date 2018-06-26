package ivanov_dmitry_android_resume.openweathermap.di.module;

import android.content.Context;

import java.io.File;
import java.util.Arrays;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module(includes = {ApplicationModule.class})
public class OkHttpModule {
    @Provides
    public OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient()
                .newBuilder()
                .cache(cache)
                .connectionSpecs(Arrays.asList(
                        ConnectionSpec.MODERN_TLS,
                        ConnectionSpec.COMPATIBLE_TLS,
                        ConnectionSpec.CLEARTEXT))
                .build();
    }

    @Provides
    public Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1024 * 1024);
    }

    @Provides
    public File provideFile(Context context) {
        File file = new File(context.getCacheDir(), "httpCache");
        file.mkdirs();
        return file;
    }
}
