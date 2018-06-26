package ivanov_dmitry_android_resume.openweathermap.domain.mapper;

public interface Mapper<F, T> {
    T fromEntity(F value);

    F toEntity(T value);
}
