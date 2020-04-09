package Song.Sejong.model.modelConverter;

public interface ModelAndEntityConvertor<E extends CustomEntity,T extends CustomModel> {
    T entityToModel(E entity);
    E modelToEntity(T model);
}
